FROM postgres:15

COPY init.sql /docker-entrypoint-initdb.d/

# docker build -t bai8-postgres .
# docker run --name my-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=schooldb -p 5432:5432 bai8-postgres