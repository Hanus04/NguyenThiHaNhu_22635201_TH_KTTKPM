CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL
);

INSERT INTO students (name, email) VALUES
('Nguyen Van A', 'a@gmail.com'),
('Tran Thi B', 'b@gmail.com');