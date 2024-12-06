let text = "";
let value = window.prompt('Entrez un nombre.');

for (let i = 1; i <= 10; i++) {
	text += `${i} x ${value} = ${i * value}\n`;
}

document.getElementById('table').textContent = text;