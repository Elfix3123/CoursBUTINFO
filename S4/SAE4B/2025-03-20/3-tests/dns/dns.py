#!/usr/bin/python3

import os
import sys
from _io import TextIOWrapper
from utils.CSVReader import *

def dnsTests(hosts: dict[str: str], testFile: TextIOWrapper):
	totalNb, failNb = 0, 0
	tests = readInlineCSV(testFile)
	for host, dns, domainName, expected in tests:
		expected = expected == "t"
		user = hosts[host]["user"]
		success = os.system(f"ssh -o ConnectTimeout=1 -J router@192.168.42.2 {user}@{host} \"dig {dns} {domainName}\" >> /dev/null")
		totalNb += 1
		if success == 255:
			raise Exception("SSH connection failed")
		elif (success == 0) != expected:
			failNb += 1
			hhostname = hosts[host]["hostname"]
			dhostname = hosts[dns]["hostname"]
			print(f"DNS request : {host} [{hhostname}] -> {dns} [{dhostname}] on {domainName} - {success}, expected: {expected}")
		
	print(f"{totalNb} DNS tests, {failNb} failed")	

if __name__ == "__main__":
	with open(sys.argv[1], "r") as f:
		hosts = readHostsCSV(f)
	with open(sys.argv[2], "r") as f:
		dnsTests(hosts, f)