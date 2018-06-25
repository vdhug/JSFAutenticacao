CREATE TABLE Users(
	id int(20) 		NOT NULL AUTO_INCREMENT, 
	username 				VARCHAR(60) NOT NULL, 
	password 			VARCHAR(60) NOT NULL, 
	PRIMARY KEY(id)
);
INSERT INTO users (id, username, password) VALUES (1, "root", "root");
SELECT * FROM loginjsf.users;