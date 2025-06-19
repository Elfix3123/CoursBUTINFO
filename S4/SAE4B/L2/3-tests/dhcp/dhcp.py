#!/usr/bin/python3

import sys
from _io import TextIOWrapper
from utils.CSVReader import *
from utils.SSH import *

def dhcpTests(hosts: dict[str: str], testFile: TextIOWrapper):
	totalNb, failNb = 0, 0
	tests = readInlineCSV(testFile)
	for hostaddress, expected in tests:
		expected = expected == "t"
		hhostname = hosts[hostaddress]["hostname"]
		host = Host(hosts, ["192.168.42.2", hostaddress])
		try:
			host.connect()
		except:
			print(f"DHCP request : {hostaddress} [{hhostname}] SSH failed")
			failNb += 1
		else:
			# Utilisation d'un script local pour ifdown/ifup les interfaces sans être root
			stdin, stdout, stderr = host.getClient().exec_command("~/dhcpdiscover.sh")
			success = "".join(stderr.readlines()) == ""
			host.disconnect()
			totalNb += 1
			if success != expected:
				failNb += 1
				print(f"DHCP request : {hostaddress} [{hhostname}] - {success}, expected: {expected}")
		
	print(f"{totalNb} DNS tests, {failNb} failed")	

if __name__ == "__main__":
	with open(sys.argv[1], "r") as f:
		hosts = readHostsCSV(f)
	with open(sys.argv[2], "r") as f:
		dhcpTests(hosts, f)