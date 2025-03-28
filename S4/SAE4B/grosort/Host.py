import paramiko as pa
from Interface import *

class Host:
	def __init__(self, id: str, interfaces: list[Interface], sshport: int = 22, itinerary: list["Host"] = []):
		self.__id = id
		self.__interfaces = interfaces
		self.__sshport = sshport
		self.__itinerary = itinerary
		self.__connected = False
	
	def getId(self) -> str:
		return self.__id
	
	def getInterfaces(self) -> list:
		return self.__interfaces
	
	def getItinerary(self) -> list:
		return self.__itinerary
	
	def connect(self, interface: Interface):
		for host in self.__itinerary:
			client = pa.SSHClient()
			client.set_missing_host_key_policy(pa.AutoAddPolicy())
			pa.connect(interface.getIp(), self.__sshport)
			transport = client.get_transport()
		
		client1 = paramiko.SSHClient()
		client1.set_missing_host_key_policy(paramiko.AutoAddPolicy())
		client1.connect(host1, 22, username, password=password)

		transport = client1.get_transport()

		dest_addr = (host2, 22)
		local_addr = ('127.0.0.1', 22)
		channel = transport.open_channel("direct-tcpip", dest_addr, local_addr)

		client2 = paramiko.SSHClient()
		client2.set_missing_host_key_policy(paramiko.AutoAddPolicy())
		client2.connect(host2, username, password=password, sock=channel)
