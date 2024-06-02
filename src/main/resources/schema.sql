CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS food_giver (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    event_type VARCHAR(255),
    location VARCHAR(255),
    date DATE,
    estimated_attendees INT,
    food_type VARCHAR(255),
    number_of_food_items INT,
    number_of_persons_served INT
);

CREATE TABLE IF NOT EXISTS food_taker (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number_of_people INT,
    place VARCHAR(255),
    dietary_preference VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS grah_laxmi (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(255),
    name VARCHAR(255),
    city VARCHAR(255),
    aadhar_number VARCHAR(255)
);
-- Define the item table
CREATE TABLE item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    expiration_date DATE NOT NULL,
    category VARCHAR(255) NOT NULL
);

CREATE TABLE matches (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    food_giver_id BIGINT NOT NULL,
    food_taker_id BIGINT NOT NULL,
    date VARCHAR(255) NOT NULL
);


