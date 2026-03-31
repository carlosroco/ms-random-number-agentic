const express = require('express');
const { getRandomNumber } = require('./randomNumber');

const app = express();

app.use(express.json());

/**
 * GET /random
 * Returns a random integer between 1 and 9.
 */
app.get('/random', (req, res) => {
  const number = getRandomNumber();
  res.json({ value: number, type: 'integer' });
});

module.exports = app;
