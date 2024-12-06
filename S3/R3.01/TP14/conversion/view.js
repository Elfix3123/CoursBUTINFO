//////////////// Partie Vue  ///////////////////////
let input = document.getElementById("input");
let output = document.getElementById("output");
let button = document.getElementById("button")

let view = {
	getInput: function() {return Number(input.value)},
	setOutput: function(newValue) {output.textContent = newValue},
	setButtonEvent: function(callback) {button.addEventListener("click", callback)}
}

export {view};