DROP database IF EXISTS feedback_db ;

CREATE DATABASE feedback_db;
USE feedback_db;

CREATE TABLE feedback (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    message VARCHAR(1000) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO feedback (name, email, message, created_at) VALUES
('Arun Kumar', 'arun@gmail.com', 'Great website, very clean UI.', '2025-01-10 10:15:00'),
('Priya Sharma', 'priya@yahoo.com', 'Feedback form is simple and easy to use.', '2025-01-10 11:20:00'),
('Rahul Verma', 'rahul@gmail.com', 'Loading speed is good, nice experience.', '2025-01-11 09:05:00'),
('Sneha Iyer', 'sneha@outlook.com', 'Please add dark mode support.', '2025-01-11 14:45:00'),
('Vikram Singh', 'vikram@gmail.com', 'Admin dashboard table looks neat.', '2025-01-12 08:30:00'),
('Ananya Rao', 'ananya@gmail.com', 'Pagination works smoothly.', '2025-01-12 12:10:00'),
('Karthik S', 'karthik@yahoo.com', 'Search by email is very helpful.', '2025-01-13 16:55:00'),
('Meera N', 'meera@gmail.com', 'Overall experience is good.', '2025-01-14 09:40:00'),
('Suresh Patel', 'suresh@gmail.com', 'Mobile view could be improved.', '2025-01-14 18:25:00'),
('Divya Malhotra', 'divya@outlook.com', 'Nice small full stack project.', '2025-01-15 11:00:00');
