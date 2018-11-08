--liquibase formatted sql
--changeset kevin:1

CREATE TABLE myuser (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);