SET MODE Oracle;

CREATE TABLE CART (
id int AUTO_INCREMENT PRIMARY KEY,
name varchar2(100)
);

CREATE TABLE ITEM (
id int AUTO_INCREMENT PRIMARY KEY,
serial_number varchar2(50),
cart_id int NOT NULL,
CONSTRAINT cart_id FOREIGN KEY (cart_id) REFERENCES CART (id)
);