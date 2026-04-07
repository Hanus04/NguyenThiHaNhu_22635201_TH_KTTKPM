# Bài 14: Private Network Docker

## Chạy
docker compose up -d

## Test kết nối
docker exec -it client_bai14 sh
wget -qO- http://server

Nếu thấy HTML nginx => OK
