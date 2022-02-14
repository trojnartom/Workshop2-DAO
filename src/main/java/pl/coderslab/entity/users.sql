INSERT INTO users (email, username, password) VALUES ('tt@hotmail.com', 'trojnartom', 'abc123');

UPDATE users SET email = 'trojnart@hotmail.com', username = 'trojnart', password = '123abc';

USE users_ws;

SELECT * FROM users WHERE id = 1;

DELETE FROM users WHERE id = 1;

INSERT INTO users (username, email, password) VALUES ('Tomek', 'trojnar.t@hotmail.com', 'abc123');