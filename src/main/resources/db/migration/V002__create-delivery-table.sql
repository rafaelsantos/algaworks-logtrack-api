CREATE TABLE delivery (
	id BIGINT NOT NULL AUTO_INCREMENT,
	customer_id BIGINT NOT NULL,
	tax DECIMAL(10,2) NOT NULL,
	status VARCHAR(20) NOT NULL,
	order_date DATETIME NOT NULL,
	end_date DATETIME,
	destination_name VARCHAR(60) NOT NULL,
	destination_address VARCHAR(255) NOT NULL,
	destination_number VARCHAR(30) NOT NULL,
	destination_complement VARCHAR(60) NOT NULL,
	destination_district VARCHAR(30) NOT NULL,
	PRIMARY KEY(id)
);

ALTER TABLE delivery ADD CONSTRAINT fk_delivery_customer
FOREIGN KEY(customer_id) REFERENCES customer(id);
