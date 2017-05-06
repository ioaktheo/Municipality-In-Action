CREATE TABLE PROBLEM (
problem_id unsigned auto_increment not null,
title varchar(55),
problem_type varchar(25),
description varchar(500),
road varchar(25), 
street_number varchar(25), 
area varchar(25),
CONSTRAINT PK_problem_ID PRIMARY KEY (problem_id));
