SET MODE Oracle;

create table IMAGES (
  image_id int AUTO_INCREMENT PRIMARY KEY,
create_at timestamp,
  image_url varchar2(100)
);

create table PRODUCTS (
    product_id int AUTO_INCREMENT PRIMARY KEY,
    product_name varchar2(50),
    material varchar2(50),
    price double,
    create_at timestamp,
    description varchar2(250),
    image_id int NOT NULL,
    CONSTRAINT image_id FOREIGN KEY (image_id) REFERENCES IMAGES (image_id)
);

CREATE TABLE CARTS (
  cart_id int AUTO_INCREMENT PRIMARY KEY,
  cart_name varchar2(100)
);

CREATE TABLE ITEMS (
  item_id int AUTO_INCREMENT PRIMARY KEY,
  serial_number varchar2(50),
  cart_id int NOT NULL,
  CONSTRAINT cart_id FOREIGN KEY (cart_id) REFERENCES CARTS (cart_id)
);