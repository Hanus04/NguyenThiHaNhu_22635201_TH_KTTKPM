const http = require("http");

const server = http.createServer((req, res) => {
  res.writeHead(200, { "Content-Type": "text/plain" });
  res.end("Hello, Docker!");
});

server.listen(3000, () => {
  console.log("Server is running on port http://localhost:3000");
});

// Build và run
// docker build -t bai1-node .
// docker run -p 3000:3000 bai1-node