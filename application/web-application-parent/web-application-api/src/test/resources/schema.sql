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

--changeset geekon:6.0-1
CREATE SEQUENCE seq_room_amenities START WITH 1 INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807;

--changeset geekon:6.0-2
DROP TABLE room_amenities CASCADE;

--changeset geekon:6.0-3
CREATE TABLE room_amenities (id INT DEFAULT nextval('seq_room_amenities') NOT NULL, room_id INT NOT NULL, amenity_id INT NOT NULL, CONSTRAINT room_amenities_pk PRIMARY KEY (id), UNIQUE (id));

--changeset geekon:7.0-1
ALTER TABLE public.payment_forms ALTER COLUMN name VARCHAR(20);

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
