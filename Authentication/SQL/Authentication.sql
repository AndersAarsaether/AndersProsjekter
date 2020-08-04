DROP SCHEMA IF EXISTS authentication_jpa CASCADE;

CREATE SCHEMA authentication_jpa;
SET search_path TO authentication_jpa;
    
CREATE TABLE accounts
(
	userName VARCHAR(30) UNIQUE NOT NULL,
	password VARCHAR(100) NOT NULL PRIMARY KEY,
	fname VARCHAR(30) NOT NULL,
	lname VARCHAR(30) NOT NULL
);