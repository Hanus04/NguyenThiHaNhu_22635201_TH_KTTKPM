const express = require("express");
const mysql = require("mysql2");

const app = express();
const port = 3000;

const db = mysql.createConnection({
  host: "mysql",
  user: "user",
  password: "password",
  database: "mydb"
});

db.connect((err) => {
  if (err) {
    console.error("MySQL connection failed:", err.message);
    return;
  }
  console.log("Connected to MySQL");

  const sql = `
    CREATE TABLE IF NOT EXISTS users (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100) NOT NULL
    )
  `;

  db.query(sql, (err) => {
    if (err) {
      console.error("Create table failed:", err.message);
    } else {
      console.log("Table users is ready");
    }
  });
});

app.get("/", (req, res) => {
  res.send("Node.js connected to MySQL successfully");
});

app.get("/users", (req, res) => {
  db.query("SELECT * FROM users", (err, results) => {
    if (err) {
      return res.status(500).send(err.message);
    }
    res.json(results);
  });
});

app.get("/add", (req, res) => {
  db.query("INSERT INTO users (name) VALUES ('Hao')", (err, result) => {
    if (err) {
      return res.status(500).send(err.message);
    }
    res.send("Inserted 1 user successfully");
  });
});

app.listen(port, () => {
  console.log(`App running at http://localhost:${port}`);
});