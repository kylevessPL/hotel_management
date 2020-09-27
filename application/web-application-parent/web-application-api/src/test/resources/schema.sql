--liquibase formatted sql

--changeset geekon:1.0-1
CREATE TABLE public.test_table (id INT AUTO_INCREMENT NOT NULL, CONSTRAINT test_table_pk PRIMARY KEY (id));

--changeset geekon:2.0-1
DROP TABLE public.test_table;

--changeset geekon:3.0-1
CREATE SEQUENCE seq_additional_services START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:3.0-2
CREATE TABLE additional_services (id INT DEFAULT nextval('seq_additional_services') NOT NULL, name VARCHAR(40) NOT NULL, price DECIMAL(10, 2) DEFAULT 0, CONSTRAINT additional_services_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:3.0-3
CREATE SEQUENCE seq_amenities START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:3.0-4
CREATE TABLE amenities (id INT DEFAULT nextval('seq_amenities') NOT NULL, name VARCHAR(40) NOT NULL, CONSTRAINT amenities_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:3.0-5
CREATE SEQUENCE seq_rooms START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:3.0-6
CREATE TABLE rooms (id INT DEFAULT nextval('seq_rooms') NOT NULL, room_number VARCHAR(10) NOT NULL, bed_amount INT DEFAULT 2 NOT NULL, standard_price DECIMAL(10, 2) DEFAULT 0, CONSTRAINT rooms_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:3.0-7
CREATE SEQUENCE seq_special_offers START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:3.0-8
CREATE TABLE special_offers (id INT DEFAULT nextval('seq_special_offers') NOT NULL, discount INT DEFAULT 0, bookings_amount INT DEFAULT 0, description VARCHAR(100), CONSTRAINT special_offers_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:3.0-9
CREATE SEQUENCE seq_bookings START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:3.0-10
CREATE TABLE bookings (id INT DEFAULT nextval('seq_bookings') NOT NULL, book_date TIMESTAMP NOT NULL, start_date date NOT NULL, end_date date NOT NULL, customer_id INT NOT NULL, room_id INT NOT NULL, offer_id INT, final_price DECIMAL(10, 2), CONSTRAINT bookings_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:3.0-11
CREATE SEQUENCE seq_customers START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:3.0-12
CREATE TABLE customers (id INT DEFAULT nextval('seq_customers') NOT NULL, first_name VARCHAR(30) NOT NULL, last_name VARCHAR(30) NOT NULL, street_name VARCHAR(30) NOT NULL, house_number INT NOT NULL, zip_code VARCHAR(10) NOT NULL, city VARCHAR(30) NOT NULL, document_type VARCHAR(10) NOT NULL, document_id VARCHAR(10) NOT NULL, CONSTRAINT customers_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:3.0-13
CREATE SEQUENCE seq_payments START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:3.0-14
CREATE TABLE payments (id INT DEFAULT nextval('seq_payments') NOT NULL, booking_id INT NOT NULL, payment_date TIMESTAMP NOT NULL, payment_form_id INT NOT NULL, CONSTRAINT payments_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:3.0-15
CREATE TABLE bookings_services (booking_id INT NOT NULL, service_id INT NOT NULL, CONSTRAINT bookings_services_pk PRIMARY KEY (booking_id));

--changeset geekon:3.0-16
CREATE SEQUENCE seq_payment_forms START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:3.0-17
CREATE TABLE payment_forms (id INT DEFAULT nextval('seq_payment_forms') NOT NULL, name VARCHAR(10) NOT NULL, CONSTRAINT payment_forms_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:3.0-18
CREATE TABLE room_amenities (room_id INT NOT NULL, amenity_id INT NOT NULL, CONSTRAINT room_amenities_pk PRIMARY KEY (room_id));

--changeset geekon:3.0-19
ALTER TABLE bookings_services ADD CONSTRAINT bookings_services_fk1 FOREIGN KEY (service_id) REFERENCES additional_services (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:3.0-20
ALTER TABLE room_amenities ADD CONSTRAINT room_amenities_fk1 FOREIGN KEY (amenity_id) REFERENCES amenities (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:3.0-21
ALTER TABLE bookings ADD CONSTRAINT bookings_fk1 FOREIGN KEY (room_id) REFERENCES rooms (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:3.0-22
ALTER TABLE bookings ADD CONSTRAINT bookings_fk2 FOREIGN KEY (offer_id) REFERENCES special_offers (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:3.0-23
ALTER TABLE bookings_services ADD CONSTRAINT bookings_services_fk0 FOREIGN KEY (booking_id) REFERENCES bookings (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:3.0-24
ALTER TABLE payments ADD CONSTRAINT payments_fk0 FOREIGN KEY (booking_id) REFERENCES bookings (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:3.0-25
ALTER TABLE payments ADD CONSTRAINT payments_fk1 FOREIGN KEY (payment_form_id) REFERENCES payment_forms (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:3.0-26
ALTER TABLE room_amenities ADD CONSTRAINT room_amenities_fk0 FOREIGN KEY (room_id) REFERENCES rooms (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:3.0-27
ALTER TABLE bookings ADD CONSTRAINT bookings_fk0 FOREIGN KEY (customer_id) REFERENCES customers (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:4.0-1
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P01', '4', '600.53');

--changeset geekon:4.0-2
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P02', '1', '286.17');

--changeset geekon:4.0-3
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P03', '2', '375.54');

--changeset geekon:4.0-4
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P04', '4', '564.26');

--changeset geekon:4.0-5
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P05', '4', '612.7');

--changeset geekon:4.0-6
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P06', '3', '457.4');

--changeset geekon:4.0-7
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P07', '3', '304.93');

--changeset geekon:4.0-8
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P08', '4', '584.28');

--changeset geekon:4.0-9
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P09', '2', '345.88');

--changeset geekon:4.0-10
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P10', '2', '358.96');

--changeset geekon:4.0-11
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P11', '1', '228.57');

--changeset geekon:4.0-12
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P12', '1', '253.84');

--changeset geekon:4.0-13
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P13', '4', '584.88');

--changeset geekon:4.0-14
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P14', '4', '562.0');

--changeset geekon:4.0-15
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P15', '4', '613.96');

--changeset geekon:4.0-16
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P16', '4', '578.46');

--changeset geekon:4.0-17
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P17', '1', '274.37');

--changeset geekon:4.0-18
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P18', '2', '388.18');

--changeset geekon:4.0-19
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P19', '4', '642.8');

--changeset geekon:4.0-20
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P20', '4', '589.29');

--changeset geekon:4.0-21
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P21', '2', '354.1');

--changeset geekon:4.0-22
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P22', '1', '263.19');

--changeset geekon:4.0-23
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P23', '1', '247.08');

--changeset geekon:4.0-24
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P24', '4', '617.65');

--changeset geekon:4.0-25
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P25', '1', '206.09');

--changeset geekon:4.0-26
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P26', '1', '288.18');

--changeset geekon:4.0-27
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P27', '4', '601.48');

--changeset geekon:4.0-28
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P28', '1', '265.8');

--changeset geekon:4.0-29
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P29', '1', '243.05');

--changeset geekon:4.0-30
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P30', '1', '209.42');

--changeset geekon:4.0-31
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P31', '1', '279.79');

--changeset geekon:4.0-32
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P32', '4', '580.17');

--changeset geekon:4.0-33
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P33', '2', '349.69');

--changeset geekon:4.0-34
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P34', '3', '481.25');

--changeset geekon:4.0-35
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P35', '1', '234.56');

--changeset geekon:4.0-36
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P36', '2', '387.99');

--changeset geekon:4.0-37
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P37', '3', '429.63');

--changeset geekon:4.0-38
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P38', '4', '620.3');

--changeset geekon:4.0-39
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P39', '4', '576.77');

--changeset geekon:4.0-40
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P40', '4', '640.31');

--changeset geekon:4.0-41
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P41', '3', '478.85');

--changeset geekon:4.0-42
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P42', '4', '590.07');

--changeset geekon:4.0-43
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P43', '3', '507.64');

--changeset geekon:4.0-44
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P44', '1', '297.61');

--changeset geekon:4.0-45
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P45', '2', '377.95');

--changeset geekon:4.0-46
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P46', '3', '474.27');

--changeset geekon:4.0-47
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P47', '3', '463.8');

--changeset geekon:4.0-48
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P48', '4', '590.16');

--changeset geekon:4.0-49
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P49', '2', '358.95');

--changeset geekon:4.0-50
INSERT INTO public.rooms (room_number, bed_amount, standard_price) VALUES ('P50', '3', '488.44');

--changeset geekon:5.0-1
INSERT INTO public.additional_services (name, price) VALUES ('Breakfast Pack', '19.99');

--changeset geekon:5.0-2
INSERT INTO public.additional_services (name, price) VALUES ('Lunch & Dinner Pack', '39.99');

--changeset geekon:5.0-3
INSERT INTO public.additional_services (name, price) VALUES ('Cleaning Service', '14.99');

--changeset geekon:5.0-4
INSERT INTO public.additional_services (name, price) VALUES ('Additional Bed', '9.99');

--changeset geekon:6.0-1
CREATE SEQUENCE seq_room_amenities START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:6.0-2
DROP TABLE room_amenities CASCADE;

--changeset geekon:6.0-3
CREATE TABLE room_amenities (id INT DEFAULT nextval('seq_room_amenities') NOT NULL, room_id INT NOT NULL, amenity_id INT NOT NULL, CONSTRAINT room_amenities_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:6.0-4
INSERT INTO amenities (name) VALUES ('en suite');
INSERT INTO amenities (name) VALUES ('balcony');
INSERT INTO amenities (name) VALUES ('TV');
INSERT INTO amenities (name) VALUES ('radio');
INSERT INTO amenities (name) VALUES ('phone');
INSERT INTO amenities (name) VALUES ('A/C');

--changeset geekon:6.0-5
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P02'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P12'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P17'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P22'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P26'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P28'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P31'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P44'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P03'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P18'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P36'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P45'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P06'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P34'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P37'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P41'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P43'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P46'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P47'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P50'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P01'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P05'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P15'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P19'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P24'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P27'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P38'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P40'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P42'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P48'), (select id from amenities where name='en suite'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P02'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P26'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P31'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P44'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P03'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P18'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P36'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P45'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P06'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P34'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P41'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P43'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P46'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P47'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P50'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P19'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P24'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P38'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P40'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P02'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P12'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P17'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P22'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P23'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P26'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P28'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P31'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P44'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P03'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P10'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P18'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P36'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P45'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P49'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P06'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P34'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P37'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P41'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P43'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P46'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P47'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P50'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P01'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P05'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P08'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P13'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P15'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P16'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P19'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P20'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P24'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P27'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P32'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P38'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P39'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P40'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P42'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P48'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P44'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P18'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P36'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P34'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P41'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P43'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P46'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P47'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P50'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P19'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P40'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P18'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P43'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P01'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P05'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P15'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P19'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P20'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P24'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P27'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P38'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P40'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P42'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P48'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P02'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P11'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P12'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P17'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P22'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P23'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P26'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P28'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P29'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P31'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P35'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P44'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P03'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P10'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P18'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P21'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P33'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P36'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P45'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P49'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P06'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P34'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P37'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P41'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P43'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P46'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P47'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P50'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P01'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P05'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P08'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P13'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P15'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P16'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P19'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P20'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P24'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P27'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P32'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P38'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P39'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P40'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P42'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P48'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P04'), (select id from amenities where name='TV'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P07'), (select id from amenities where name='balcony'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P09'), (select id from amenities where name='phone'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P14'), (select id from amenities where name='A/C'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P25'), (select id from amenities where name='radio'));
INSERT INTO room_amenities (room_id, amenity_id) VALUES ((select id from rooms where room_number='P30'), (select id from amenities where name='en suite'));

--changeset geekon:7.0-1
ALTER TABLE public.payment_forms ALTER COLUMN name VARCHAR(20);

--changeset geekon:7.0-2
INSERT INTO public.payment_forms (name) VALUES ('Cash');

--changeset geekon:7.0-3
INSERT INTO public.payment_forms (name) VALUES ('Check');

--changeset geekon:7.0-4
INSERT INTO public.payment_forms (name) VALUES ('Credit Card');

--changeset geekon:7.0-5
INSERT INTO public.payment_forms (name) VALUES ('PayPal');

--changeset geekon:7.0-6
INSERT INTO public.payment_forms (name) VALUES ('Western Union');

--changeset geekon:7.0-7
ALTER TABLE public.customers ALTER COLUMN house_number VARCHAR(10);

--changeset geekon:7.0-8
ALTER TABLE public.bookings ADD confirmed BOOLEAN DEFAULT FALSE NOT NULL;

--changeset geekon:8.0-1
ALTER TABLE public.payments ADD transaction_id CHAR(36) NOT NULL;

--changeset geekon:9.0-1
CREATE SEQUENCE seq_bookings_services START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:9.0-2
DROP TABLE bookings_services CASCADE;

--changeset geekon:9.0-3
CREATE TABLE bookings_services (id INT DEFAULT nextval('seq_bookings_services') NOT NULL, booking_id INT NOT NULL, service_id INT NOT NULL, CONSTRAINT bookings_services_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:9.0-4
ALTER TABLE bookings_services ADD CONSTRAINT bookings_services_fk0 FOREIGN KEY (service_id) REFERENCES additional_services (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:9.0-5
ALTER TABLE bookings_services ADD CONSTRAINT bookings_services_fk1 FOREIGN KEY (booking_id) REFERENCES bookings (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:9.0-6
ALTER TABLE room_amenities ADD CONSTRAINT room_amenities_fk0 FOREIGN KEY (room_id) REFERENCES rooms (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:9.0-7
ALTER TABLE room_amenities ADD CONSTRAINT room_amenities_fk1 FOREIGN KEY (amenity_id) REFERENCES amenities (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

--changeset geekon:10.0-1
ALTER TABLE public.bookings ALTER COLUMN confirmed RENAME TO status;

--changeset geekon:10.0-2
ALTER TABLE public.bookings ALTER COLUMN status VARCHAR(15);

--changeset geekon:10.0-3
ALTER TABLE public.bookings ALTER COLUMN  status SET DEFAULT 'NOT_CONFIRMED';

