/**
 * Generates a random integer between 1 and 9 (inclusive).
 * @returns {number} A random integer from 1 to 9
 */
function getRandomNumber() {
  return Math.floor(Math.random() * 9) + 1;
}

module.exports = { getRandomNumber };
