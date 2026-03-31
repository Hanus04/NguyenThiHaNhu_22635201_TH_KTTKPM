FROM node:18

# Tạo thư mục app
WORKDIR /app

# Copy package.json trước để cache layer
COPY package*.json ./

# Cài dependencies
RUN npm install

# Copy toàn bộ code
COPY . .

# Expose port
EXPOSE 3000

# Chạy app
CMD ["npm", "start"]