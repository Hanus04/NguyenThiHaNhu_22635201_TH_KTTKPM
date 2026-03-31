# ===== Stage 1: Build =====
FROM node:18 AS build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build


# ===== Stage 2: Runtime =====
FROM node:18-alpine

WORKDIR /app

# chỉ copy file cần thiết từ stage build
COPY --from=build /app/dist ./dist
COPY --from=build /app/package.json ./

# chỉ cài production dependency (ở đây không có nhưng vẫn đúng chuẩn)
RUN npm install --omit=dev

EXPOSE 3000

CMD ["npm", "start"]

# docker build -t bai6-node .
# docker run -p 3002:3000 bai6-node
# http://localhost:3002