--liquibase formatted sql
--changeset kevin:2

CREATE TABLE wallet (
  id INT NOT NULL AUTO_INCREMENT,
  balance VARCHAR(255) NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES myuser(id)
);