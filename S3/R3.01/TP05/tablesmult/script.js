function tablesMultiplication(n) {
	i = 1;
	while (i <= 10) {
		console.log(n + " x " + i + " = " + n * i);
		i++;
	}
}

function readInt(p) {
	n = parseInt(prompt(p));
	if (!isNaN(n)) {
		return n;
	}
	else {
		console.log("Erreur : entrez un nombre");
		return readInt(p);
	}
}