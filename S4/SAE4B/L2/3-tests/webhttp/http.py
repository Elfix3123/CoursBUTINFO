#!/usr/bin/python3

import sys
from _io import TextIOWrapper
from utils.CSVReader import *
from utils.SSH import *

def httpTests(hosts: dict[str: str], testFile: TextIOWrapper):
	totalNb, failNb = 0, 0
	tests = readInlineCSV(testFile)
	for hostaddress, domainName, expected in tests:
		expected = expected == "t"
		hhostname = hosts[hostaddress]["hostname"]
		host = Host(hosts, ["192.168.42.2", hostaddress])
		try:
			host.connect()
		except:
			print(f"HTTP request : {hostaddress} [{hhostname}] SSH failed")
			failNb += 1
		else:
			stdin, stdout, stderr = host.getClient().exec_command(f"wget {domainName} -O /dev/stdout -o /dev/null -T 1")
			success = "".join(stdout.readlines()) != ""
			host.disconnect()
			totalNb += 1
			if success != expected:
				failNb += 1
				print(f"HTTP request : {hostaddress} [{hhostname}] -> {domainName} - {success}, expected: {expected}")
		
	print(f"{totalNb} HTTP tests, {failNb} failed")	

if __name__ == "__main__":
	with open(sys.argv[1], "r") as f:
		hosts = readHostsCSV(f)
	with open(sys.argv[2], "r") as f:
		webhttpTests(hosts, f)