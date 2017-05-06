CREATE TABLE CITIZEN (
citizen_id unsigned auto_increment not null,
name varchar(45) NOT NULL,
surname varchar(45),
birthdate date,
gender varchar(15),
road varchar(25),
street_Number (15),
postcode varchar(15),
municipality_id INT, 
CONSTRAINT PK_citizenID PRIMARY KEY (citizen_id));
