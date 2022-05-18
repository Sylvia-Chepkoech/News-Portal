SET MODE PostgreSQL;

CREATE DATABASE news_portal;
\c news_portal

CREATE TABLE IF NOT EXISTS departments (
 id serial PRIMARY KEY,
 departmentName VARCHAR,
 description VARCHAR,
 numberOfEmployees VARCHAR
);

CREATE TABLE IF NOT EXISTS news (
 id serial PRIMARY KEY,
 heading VARCHAR,
 context VARCHAR,
 departmentId INTEGER
);

CREATE TABLE IF NOT EXISTS employees (
 id serial PRIMARY KEY,
 name VARCHAR,
 position VARCHAR,
 email VARCHAR,
 departmentId INTEGER

);

 CREATE TABLE IF NOT EXISTS departments_employees (
 id serial PRIMARY KEY,
 employeeid INTEGER,
 departmentid INTEGER
);

CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;