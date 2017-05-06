CREATE TABLE EVENTS (
event_id unsigned auto_increment not null,
title varchar(100),
event_type varchar(25),
location varchar(25),
description varchar(500),
municipality_id INT, 
CONSTRAINT PK_event_ID PRIMARY KEY (event_id));
