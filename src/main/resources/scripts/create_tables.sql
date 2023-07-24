create database demo;
use demo;
create table product
(
    id   int          not null
        primary key,
    name varchar(100) null
);
create table employee
(
    id   int          not null
        primary key,
    name varchar(100) null,
    address varchar(150) null
);
select id,name,address
from employee;
