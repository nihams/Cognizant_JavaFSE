-- Run this in MySQL Workbench (or mysql client) BEFORE running the app.
-- Since ddl-auto=validate, Hibernate expects this table to already exist.

CREATE SCHEMA IF NOT EXISTS ormlearn;
USE ormlearn;

CREATE TABLE country (co_code varchar(2) primary key, co_name varchar(50));

insert into country (co_code, co_name) values ('AF', 'Afghanistan');
insert into country (co_code, co_name) values ('AL', 'Albania');
insert into country (co_code, co_name) values ('DZ', 'Algeria');
insert into country (co_code, co_name) values ('AS', 'American Samoa');
insert into country (co_code, co_name) values ('AD', 'Andorra');
insert into country (co_code, co_name) values ('AO', 'Angola');
insert into country (co_code, co_name) values ('AI', 'Anguilla');
insert into country (co_code, co_name) values ('AQ', 'Antarctica');
insert into country (co_code, co_name) values ('AG', 'Antigua and Barbuda');
insert into country (co_code, co_name) values ('AR', 'Argentina');
insert into country (co_code, co_name) values ('AM', 'Armenia');
insert into country (co_code, co_name) values ('AW', 'Aruba');
insert into country (co_code, co_name) values ('AU', 'Australia');
insert into country (co_code, co_name) values ('AT', 'Austria');
insert into country (co_code, co_name) values ('AZ', 'Azerbaijan');
insert into country (co_code, co_name) values ('BS', 'Bahamas');
insert into country (co_code, co_name) values ('BH', 'Bahrain');
insert into country (co_code, co_name) values ('BD', 'Bangladesh');
insert into country (co_code, co_name) values ('BB', 'Barbados');
insert into country (co_code, co_name) values ('BY', 'Belarus');
insert into country (co_code, co_name) values ('BE', 'Belgium');
insert into country (co_code, co_name) values ('BZ', 'Belize');
insert into country (co_code, co_name) values ('BJ', 'Benin');
insert into country (co_code, co_name) values ('BM', 'Bermuda');
insert into country (co_code, co_name) values ('BT', 'Bhutan');
insert into country (co_code, co_name) values ('IN', 'India');
insert into country (co_code, co_name) values ('US', 'United States');
insert into country (co_code, co_name) values ('GB', 'United Kingdom');
insert into country (co_code, co_name) values ('FR', 'France');
insert into country (co_code, co_name) values ('DE', 'Germany');
insert into country (co_code, co_name) values ('JP', 'Japan');
insert into country (co_code, co_name) values ('CN', 'China');
insert into country (co_code, co_name) values ('AU', 'Australia') ON DUPLICATE KEY UPDATE co_name=co_name;
insert into country (co_code, co_name) values ('CA', 'Canada');
insert into country (co_code, co_name) values ('BR', 'Brazil');
insert into country (co_code, co_name) values ('ZA', 'South Africa');
insert into country (co_code, co_name) values ('RU', 'Russian Federation');
insert into country (co_code, co_name) values ('IT', 'Italy');
insert into country (co_code, co_name) values ('ES', 'Spain');
insert into country (co_code, co_name) values ('MX', 'Mexico');
insert into country (co_code, co_name) values ('SG', 'Singapore');
insert into country (co_code, co_name) values ('NZ', 'New Zealand');

SELECT COUNT(*) AS total_countries FROM country;
