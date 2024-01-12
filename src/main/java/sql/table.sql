CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    national_id VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255)
);