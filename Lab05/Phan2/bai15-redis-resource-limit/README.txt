# Bài 15: Giới hạn tài nguyên cho container Redis

## Mục tiêu
Chạy Redis bằng Docker Compose và giới hạn:
- CPU: 0.50
- RAM: 256MB

## File chính
- docker-compose.yml

## Cách chạy
docker compose up -d

## Kiểm tra container
docker ps

## Kiểm tra giới hạn tài nguyên
docker inspect redis_bai15

## Kiểm tra realtime
docker stats

## Dừng hệ thống
docker compose down

## Xóa luôn volume dữ liệu
docker compose down -v
