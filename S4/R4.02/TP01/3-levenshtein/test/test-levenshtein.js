import assert from 'node:assert';
import levenshtein from '../src/levenshtein.js';

describe('#levenshtein()', function () {
	it("La distance de levenshtein entre 'niche' et 'chiens' est de 5", function () {
		assert.equal(levenshtein('niche', 'chiens').distance, 5);
	});

	it("La distance de levenshtein entre 'chiens' et 'niche' est de 5", function () {
		assert.equal(levenshtein('chiens', 'niche').distance, 5);
	});

	it("La distance de levenshtein entre 'niche' et '' est de 5", function () {
		assert.equal(levenshtein('niche', '').distance, 5);
	});

	it("La distance de levenshtein entre '' et 'niche' est de 5", function () {
		assert.equal(levenshtein('', 'niche').distance, 5);
	});

	it("La distance de levenshtein entre 'niche' et 'niche' est de 0", function () {
		assert.equal(levenshtein('niche', 'niche').distance, 0);
	});

	it("La distance de levenshtein entre '' et '' est de 0", function () {
		assert.equal(levenshtein('', '').distance, 0);
	});

	it("La distance de levenshtein entre 3 et 'niche' doit renvoyer une exception", function () {
		assert.throws(function () {
			levenshtein(3, 'niche');
		});
	});

	it("La distance de levenshtein entre 'chien' et '3' doit renvoyer une exception", function () {
		assert.throws(function () {
			levenshtein('chien', 3);
		});
	});
});
