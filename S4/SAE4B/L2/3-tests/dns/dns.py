#!/usr/bin/python3

import sys
from _io import TextIOWrapper
from utils.CSVReader import *
from utils.SSH import *

def dnsTests(hosts: dict[str: str], testFile: TextIOWrapper):
	totalNb, failNb = 0, 0
	tests = readInlineCSV(testFile)
	for hostaddress, dns, domainName, expected in tests:
		expected = expected == "t"
		hhostname = hosts[hostaddress]["hostname"]
		dhostname = hhostname if dns == "localhost" else hosts[dns]["hostname"]
		host = Host(hosts, ["192.168.42.2", hostaddress])
		try:
			host.connect()
		except:
			print(f"DNS request : {hostaddress} [{hhostname}] SSH failed")
			failNb += 1
		else:
			stdin, stdout, stderr = host.getClient().exec_command("dig {dns} {domainName}")
			success = "".join(stderr.readlines()) == ""
			host.disconnect()
			totalNb += 1
			if success != expected:
				failNb += 1
				print(f"DNS request : {hostaddress} [{hhostname}] -> {dns} [{dhostname}] on {domainName} - {success}, expected: {expected}")
		
	print(f"{totalNb} DNS tests, {failNb} failed")	

if __name__ == "__main__":
	with open(sys.argv[1], "r") as f:
		hosts = readHostsCSV(f)
	with open(sys.argv[2], "r") as f:
		dnsTests(hosts, f)