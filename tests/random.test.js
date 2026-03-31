const request = require('supertest');
const app = require('../src/app');

describe('GET /random', () => {
  it('should return a JSON object with value and type fields', async () => {
    const res = await request(app).get('/random');
    expect(res.statusCode).toBe(200);
    expect(res.body).toHaveProperty('value');
    expect(res.body).toHaveProperty('type', 'integer');
  });

  it('should return a number between 1 and 9 inclusive', async () => {
    const res = await request(app).get('/random');
    expect(res.statusCode).toBe(200);
    expect(res.body.value).toBeGreaterThanOrEqual(1);
    expect(res.body.value).toBeLessThanOrEqual(9);
  });

  it('should return an integer value', async () => {
    const res = await request(app).get('/random');
    expect(Number.isInteger(res.body.value)).toBe(true);
  });
});
