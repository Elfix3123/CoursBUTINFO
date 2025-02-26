/**
 * Return the factorial of i.
 * @param {number} i - an integer number.
 * @return {number} the factorial of i.
 */
export const factorial = function (i) {
	if (typeof(i) != 'number' || i < 0) {
		throw null;
	}
	else if (i == 0) {
		return 1;
	}
	else {
		return i * factorial(i-1);
	}
};

export default factorial;
