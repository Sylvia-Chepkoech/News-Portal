SET MODE PostgreSQL;

CREATE DATABASE news_portal;
\c news_portal

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 departmentName VARCHAR,
 description VARCHAR,
 numberOfEmployees VARCHAR
);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 heading VARCHAR,
 context VARCHAR,
 departmentId INTEGER
);

CREATE TABLE IF NOT EXISTS employees (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 position VARCHAR,
 email VARCHAR,
 departmentId INTEGER

);

 CREATE TABLE IF NOT EXISTS departments_employees (
 id int PRIMARY KEY auto_increment,
 employeeid INTEGER,
 departmentid INTEGER
);

CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;