
INSERT INTO IMAGES (create_at, image_url) VALUES (TO_DATE('2021-03-23 11:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'https://picsum.photos/350/256'),
    (TO_DATE('2021-03-24 10:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'https://picsum.photos/350/257'),
    (TO_DATE('2021-03-24 09:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'https://picsum.photos/350/258'),
    (TO_DATE('2021-03-24 08:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'https://picsum.photos/350/259'),
    (TO_DATE('2021-03-25 07:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'https://picsum.photos/350/260'),
    (TO_DATE('2021-03-24 16:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'https://picsum.photos/350/261'),
    (TO_DATE('2021-03-24 17:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'https://picsum.photos/350/262'),
    (TO_DATE('2021-03-24 11:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'https://picsum.photos/350/263');

INSERT INTO PRODUCTS (product_name, material, price, create_at, description, image_id) VALUES ('Handmade Granite Shirt', 'Metal',
                      19.90, TO_DATE('2020-03-23 11:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'i dont know', 1),
('Handmade Granite Shirt2', 'Cloth', 29.90, TO_DATE('2020-03-23 11:10:00', 'yyyy/mm/dd hh24:mi:ss'), 'i dont know', 1);

INSERT INTO CARTS (cart_name) VALUES ('C999');

INSERT INTO ITEMS (serial_number, cart_id) VALUES ('I333', 1), ('I444', 1);