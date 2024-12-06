//////////////// Partie Contrôleur /////////////////
import {model} from "./model.js";
import {view} from "./view.js";

function convert() {
	view.setOutput(model.convert(view.getInput()));
}

view.setButtonEvent(convert);