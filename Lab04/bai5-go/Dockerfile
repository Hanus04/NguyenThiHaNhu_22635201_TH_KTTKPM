FROM golang:1.22

WORKDIR /app

COPY go.mod ./
COPY main.go ./

RUN go build -o app .

EXPOSE 8080

CMD ["./app"]

# docker build -t bai5-go .
# docker run -p 8080:8080 bai5-go
# http://localhost:8080