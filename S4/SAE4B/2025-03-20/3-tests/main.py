#!/usr/bin/python3

from utils.CSVReader import readHostsCSV
from connectivite.connectivite import connectiviteTests
from dns.dns import dnsTests

import os

if __name__ == "__main__":
	with open(os.path.realpath(__file__ + "/../hosts.csv"), "r") as f:
		hosts = readHostsCSV(f)
	with open(os.path.realpath(__file__ + "/../connectivite/tests.csv"), "r") as f:
		connectiviteTests(hosts, f)
	with open(os.path.realpath(__file__ + "/../dns/tests.csv"), "r") as f:
		dnsTests(hosts, f)