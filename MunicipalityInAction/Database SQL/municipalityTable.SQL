CREATE TABLE MUNICIPALITY (
municipality_id unsigned auto_increment not null,
name varchar(45) NOT NULL,
department varchar(45),
law varchar(45),
fax varchar(15),
country varchar(25),
road varchar(25),
street_Number (15),
postcode varchar(15) INT, 
phone_number varchar(25),
mayor varchar(25),
population varchar(25),
CONSTRAINT PK_municipality_ID PRIMARY KEY (municipality_id));