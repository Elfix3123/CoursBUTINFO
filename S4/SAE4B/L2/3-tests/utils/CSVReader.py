from _io import TextIOWrapper

def readHostsCSV(hostsFile: TextIOWrapper) -> dict[str: str]:
	hosts = {}
	while row := hostsFile.readline():
		if len(row.strip()) != 0 and row.strip()[0] != "#":
			ip, user, hostname = row.strip().split(";")
			hosts[ip] = {"user": user, "hostname": hostname}
	return hosts

def readInlineCSV(file: TextIOWrapper) -> list[str]:
	rows = []
	while row := file.readline():
		if len(row.strip()) != 0 and row.strip()[0] != "#":
			rows.append(row.strip().split(";"))
	return rows