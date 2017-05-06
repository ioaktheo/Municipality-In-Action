CREATE TABLE ANNOUNCEMENTS (
announcement_id unsigned auto_increment not null,
title varchar(100),
reliability varchar(25),
an_type varchar(25),
description varchar(500), 
road varchar(25), 
postcode varchar(25),
municipality_id INT, 
CONSTRAINT PK_announcement_ID PRIMARY KEY (announcement_id));
