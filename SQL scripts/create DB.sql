create database if not exists tourfirm; 

create user `admin`@`localhost`;
grant all on tourfirm1.* to `admin`;

create user `manager`@localhost;
grant select, update, insert on tourfirm1.* to `manager`@localhost;

create user `user`@`%`;
grant select on tourfirm1.tours_list to `user`;
