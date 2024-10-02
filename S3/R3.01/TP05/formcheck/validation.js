// Returns true is there is a digit in string t
function hasDigit(t) {
	var regex = /\d/;
	return regex.test(t);
}

// Returns true is there is a uppercase letter in string t
function hasUppercase(t) {
	var regex = /[A-Z]/;
	return regex.test(t);
}

// Returns true is there is a lowercase letter in string t
function hasLowercase(t) {
	var regex = /[a-z]/;
	return regex.test(t);
}

// Returns true if form has valid data
function validateForm() {
	let password = document.getElementById("password").value;
	let passcheck = document.getElementById("passcheck").value;
	if (password != passcheck) {
		alert("Passwords do not match");
		return false;
	}
	else if (password.length < 8) {
		alert("Password must be at least 8 characters long");
		return false;
	}
	else if (!hasDigit(password)) {
		alert("Password must contain at least one digit");
		return false;
	}
	else if (!hasUppercase(password)) {
		alert("Password must contain at least one uppercase letter");
		return false;
	}
	else if (!hasLowercase(password)) {
		alert("Password must contain at least one lowercase letter");
		return false;
	}
	else {
		return true;
	}
}