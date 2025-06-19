#!/usr/bin/python3

import sys
from _io import TextIOWrapper
from utils.CSVReader import *
from utils.SSH import *

def connectiviteTests(hosts: dict[str: str], testFile: TextIOWrapper):
	totalNb, failNb = 0, 0
	tests = readInlineCSV(testFile)
	for sip, dip, expected in tests:
		expected = expected == "t"
		shostname = hosts[sip]["hostname"]
		dhostname = shostname if sip == "localhost" else hosts[dip]["hostname"]
		host = Host(hosts, ["192.168.42.2", sip])
		try:
			host.connect()
		except:
			print(f"ping : {sip} [{shostname}] SSH failed")
			failNb += 1
		else:
			stdin, stdout, stderr = host.getClient().exec_command(f"ping {dip} -c 1 -W 0.1")
			success = "".join(stderr.readlines()) == ""			
			host.disconnect()
			totalNb += 1
			if success != expected:
				failNb += 1
				print(f"ping : {sip} [{shostname}] -> {dip} [{dhostname}] - {success}, expected: {expected}")	

	print(f"{totalNb} ping tests, {failNb} failed")	

if __name__ == "__main__":
	with open(sys.argv[1], "r") as f:
		hosts = readHostsCSV(f)
	with open(sys.argv[2], "r") as f:
		connectiviteTests(hosts, f)

