let dieInput = document.getElementById("dieInput");
let dieOutput = document.getElementById("dieOutput");
let dieButton = document.getElementById("dieButton");

let view = {
	readInput: function() {return Number(dieInput.value);},
	writeOutput: function(newValue) {dieOutput.textContent = newValue.toString();},
	addDieButtonEventListener: function(callback) {dieButton.addEventListener("click", callback);}
}

export {view};