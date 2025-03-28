#!/usr/bin/python3

import os
import sys
from _io import TextIOWrapper
from utils.CSVReader import *

def connectiviteTests(hosts: dict[str: str], testFile: TextIOWrapper):
	totalNb, failNb = 0, 0
	tests = readInlineCSV(testFile)
	for sip, dip, expected in tests:
		expected = expected == "t"
		user = hosts[sip]["user"]
		success = os.system(f"ssh -o ConnectTimeout=1 -J router@192.168.42.2 {user}@{sip} \"ping {dip} -c 1 -W 0.1\" >> /dev/null")
		totalNb += 1
		if success == 255:
			raise Exception("SSH connection failed")
		elif (success == 0) != expected:
			failNb += 1
			shostname = hosts[sip]["hostname"]
			dhostname = hosts[dip]["hostname"]
			print(f"ping : {sip} [{shostname}] -> {dip} [{dhostname}] - {success}, expected: {expected}")	

	print(f"{totalNb} ping tests, {failNb} failed")	

if __name__ == "__main__":
	with open(sys.argv[1], "r") as f:
		hosts = readHostsCSV(f)
	with open(sys.argv[2], "r") as f:
		connectiviteTests(hosts, f)

