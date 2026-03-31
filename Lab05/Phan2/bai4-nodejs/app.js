const express = require("express");
const app = express();

const PORT = 3000;

app.get("/", (req, res) => {
  res.send("Hello from Node.js + Docker Compose 🚀");
});

app.get("/api", (req, res) => {
  res.json({
    message: "API is working",
    status: "success"
  });
});

app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});

// docker compose up -d --build