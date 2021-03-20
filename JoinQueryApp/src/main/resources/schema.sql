SET MODE Oracle;

CREATE SEQUENCE CUSTOMER_SEQ INCREMENT BY 1 MINVALUE 1  CACHE 1000;

create table Customer (
    customer_id number AUTO_INCREMENT PRIMARY KEY,
    customer_name varchar2(50),

);

create table product (
    product_id number primary key,
    product_name varchar2(50),
    product_price number(5,2),
    customer_id number(5)
);