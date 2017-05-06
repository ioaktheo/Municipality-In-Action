CREATE TABE REPORT(
problem_id INT NOT NULL,
citizen_id INT NOT NULL,
reportedDate date, 
CONSTRAINT PK_report_ID PRIMARY KEY (problem_id, citizen_id));
 