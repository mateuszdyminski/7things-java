--liquibase formatted sql

--changeset mdyminski:1 dbms:mssql
--comment create users table
create table users (
    id int primary key,
    name varchar(255)
);
--rollback drop table users;

--changeset mdyminski:2 dbms:mssql
--comment alter table users - add new field
alter table users add phone nvarchar (255) NULL;
--rollback ALTER TABLE users DROP COLUMN phone;
