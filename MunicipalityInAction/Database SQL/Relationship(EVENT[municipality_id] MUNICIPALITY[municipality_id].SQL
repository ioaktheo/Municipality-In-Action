ALTER TABLE EVENTS 
ADD CONSTRAINT FK5 
FOREIGN KEY(municipality_id)
REFERENCES
MUNICIPALITY(municipality_id);