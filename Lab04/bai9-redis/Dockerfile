FROM redis:latest

COPY redis.conf /usr/local/etc/redis/redis.conf

CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]

# docker build -t bai9-redis .
# docker run -p 6379:6379 bai9-redis