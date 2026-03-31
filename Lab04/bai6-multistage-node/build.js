const fs = require("fs");
const path = require("path");

// tạo folder dist
const distDir = path.join(__dirname, "dist");

if (!fs.existsSync(distDir)) {
  fs.mkdirSync(distDir);
}

// copy file từ src → dist
fs.copyFileSync(
  path.join(__dirname, "src", "index.js"),
  path.join(distDir, "index.js")
);

console.log("Build completed!");