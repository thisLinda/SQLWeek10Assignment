DROP TABLE if exists meds;

CREATE TABLE meds (
  med_id int NOT NULL AUTO_INCREMENT PRIMARY key,
  generic_name varchar(40) NOT NULL
);