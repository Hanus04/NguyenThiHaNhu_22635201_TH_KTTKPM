# Bài 8: Kết nối nhiều dịch vụ với Docker Compose

## Mô tả
Chạy ứng dụng Node.js kết nối với MySQL bằng Docker Compose.

## Cách chạy
docker compose up -d --build

## Truy cập
- App: http://localhost:3000
- Danh sách users: http://localhost:3000/users
- Thêm user mẫu: http://localhost:3000/add

## Thông tin MySQL
- Host: mysql
- Port: 3306
- Database: mydb
- User: user
- Password: password
- Root Password: rootpassword