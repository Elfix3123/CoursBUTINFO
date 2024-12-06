import {view} from "./view.js";
import {model} from "./model.js";

function updateDie() {
	view.writeOutput(model.roll(view.readInput()));
}

view.addDieButtonEventListener(updateDie);