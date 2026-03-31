const express = require("express");
const { createClient } = require("redis");

const app = express();
const port = 3000;

const redisHost = process.env.REDIS_HOST || "redis";
const redisPort = process.env.REDIS_PORT || 6379;

const client = createClient({
  url: `redis://${redisHost}:${redisPort}`
});

client.on("error", (err) => {
  console.error("Redis error:", err.message);
});

(async () => {
  try {
    await client.connect();
    console.log("Connected to Redis");
  } catch (err) {
    console.error("Failed to connect Redis:", err.message);
  }
})();

app.get("/", async (req, res) => {
  try {
    let count = await client.get("visit_count");
    count = count ? parseInt(count) + 1 : 1;
    await client.set("visit_count", count);

    res.send(`
      <h1>Docker Compose Demo</h1>
      <p>Visit count: ${count}</p>
      <p>Web service is running!</p>
    `);
  } catch (err) {
    res.status(500).send("Redis connection failed: " + err.message);
  }
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});

// docker compose up
// http://localhost:3000