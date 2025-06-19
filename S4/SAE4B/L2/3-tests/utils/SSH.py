from paramiko import *

class Host:
	def __init__(self, hosts, targets: list[str]):
		self.hosts = hosts
		self.conns = list()
		self.targets = targets
	
	def connect(self):
		client = SSHClient()
		client.set_missing_host_key_policy(AutoAddPolicy())
		client.connect(self.targets[0], 22, self.hosts[self.targets[0]]["user"])
		self.conns.append(client)
		transport = client.get_transport()

		i = 1
		while i < len(self.targets):
			dest_addr = (self.targets[i], 22)
			local_addr = ("localhost", 22)
			channel = transport.open_channel("direct-tcpip", dest_addr, local_addr)

			client = SSHClient()
			client.set_missing_host_key_policy(AutoAddPolicy())
			client.connect(self.targets[i], 22, self.hosts[self.targets[i]]["user"], sock=channel)
			transport = client.get_transport()
			self.conns.append(client)
			
			i += 1
	
	def getClient(self):
		return self.conns[-1]

	def disconnect(self):
		i = len(self.conns) - 1
		while i >= 0:
			self.conns[i].close()
			i -= 1

if __name__ == "__main__":
	from CSVReader import *
	with open("/home/felix/Documents/Cours/S4/SAE4B/L2/3-tests/.hostsdebug.csv", "r") as f:
		hosts = readHostsCSV(f)
	host = Host(hosts, ["localhost", "localhost"])
	host.connect()
	stdin, stdout, stderr = host.getClient().exec_command("ping 1.1.1.1 -c 10 -i 0.002")
	print("".join(stdout.readlines()))
	host.disconnect()