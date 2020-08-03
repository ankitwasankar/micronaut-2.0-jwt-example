### Securing Rest Endpoints | Micronaut 2.0 | JWT | MySQL

1. Micronaut Security + JWT token generation + MySQL
2. Fetching JWT token and accessing secured endpoints using this bearer token. 

# Micronaut 2.0 - JWT token Example




### How to use this example
- Import project in Intellij or Eclipse
- Update datasource in ``application.yml`` database details.
- Execute database queries given below in MySQL database.
- Run the Application
- <b>Verification</b>: Test using postman

#### 1. Execute database queries:
```roomsql
drop database if exists demo;
create database demo;
use demo;
create table auth_user ( id int auto_increment primary key, username varchar(100), password varchar(50));
create table auth_role ( id int auto_increment primary key, name varchar(50), description varchar(200));
create table auth_user_role ( auth_user_id int, auth_role_id int);
insert into auth_user (username, password) values ('sherlock', 'password');
insert into auth_role (name, description) values ('ADMIN', 'Admin user');
insert into auth_role (name, description) values ('USER', 'User');
insert into auth_user_role (auth_user_id, auth_role_id) values (1,1);
```

#### 2. Using Postman to test the application

- Get JWT Token by providing username and password:
![](https://raw.githubusercontent.com/ankitwasankar/micronaut-2.0-jwt-example/master/src/test/resources/postman-sample.PNG)


- Use JWT token to access secured rest end point:
![](https://raw.githubusercontent.com/ankitwasankar/micronaut-2.0-jwt-example/master/src/test/resources/postman-sample2.PNG)

## References 

### Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

### Feature security-jwt documentation

- [Micronaut Micronaut Security JWT documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)

### Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)

### Feature security documentation

- [Micronaut Micronaut Security documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)

### Feature testcontainers documentation

- [https://www.testcontainers.org/](https://www.testcontainers.org/)

