CREATE TABLE customer(
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	mail VARCHAR(255) NOT NULL,
	phone VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
);