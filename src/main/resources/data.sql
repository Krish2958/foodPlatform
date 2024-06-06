-- data.sql

INSERT INTO user (email, password) VALUES ('test@example.com', '$2a$10$D4Oqk5i5E3e0Zg/CIXkhuOeTPo4sQEmKOe3V0y/B.GOo7x4jNXn/S'); -- password is 'password' encrypted using bcrypt

INSERT INTO food_giver (event_type, location, date, estimated_attendees, food_type, number_of_food_items, number_of_persons_served)
VALUES ('Charity Event', 'Community Hall', '2023-06-15', 100, 'Veg', 10, 50);

INSERT INTO food_taker (id, number_of_people, place, dietary_preference) VALUES
(1, 5, 'Community Center', 'Vegetarian'),
(2, 3, 'Shelter Home', 'Non-Vegetarian'),
(3, 10, 'Park', 'Vegan');

INSERT INTO grah_laxmi (id, account_number, name, city, aadhar_number) VALUES
(1, '1234567890', 'Anita Sharma', 'Mumbai', '1234-5678-9101'),
(2, '0987654321', 'Sunita Patel', 'Delhi', '2345-6789-1011'),
(3, '1122334455', 'Kamla Devi', 'Bangalore', '3456-7891-0112');

INSERT INTO food_item (id, name, quantity, expiration_date,category) VALUES
(1, 'Rice', 50, '2024-06-30','Fruits'),
(2, 'Pasta', 30, '2024-07-15','Bakery'),
(3, 'Bread', 100, '2024-05-29','Dairy');

INSERT INTO matches (food_giver_id, food_taker_id, date) VALUES (1, 2, '2024-05-31');

INSERT INTO user (email, password) VALUES ('test@example.com', 'password');

INSERT INTO user_authentication (username, password, role) VALUES ('admin', 'adminpassword', 'ROLE_ADMIN');
INSERT INTO user_authentication (username, password, role) VALUES ('user', 'userpassword', 'ROLE_USER');

