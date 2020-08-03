create database demo;
use demo;

create table auth_user (
	id int auto_increment primary key,
	username varchar(100),
	password varchar(50)
)
;


create table auth_role (
	id int auto_increment primary key,
	name varchar(50),
	description varchar(200)
)
;

create table auth_user_role (
	auth_user_id int,
	auth_role_id int
)
;

insert into auth_user (username, password) values ('sherlock', 'password');
insert into auth_role (name, description) values ('ADMIN', 'Admin user');
insert into auth_role (name, description) values ('USER', 'User');
insert into auth_user_role (auth_user_id, auth_role_id) values (1,1);