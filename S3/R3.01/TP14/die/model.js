let model = {
	roll: function(faces) {
		return Math.floor(Math.random() * faces) + 1;
	}
}

export {model};