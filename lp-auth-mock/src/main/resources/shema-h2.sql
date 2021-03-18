CREATE TABLE IF NOT EXISTS user
( id bigint(10) NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    PRIMARY KEY (id) );