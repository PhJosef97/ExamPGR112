CREATE DATABASE universityDB;

USE universityDB;

CREATE USER 'examPGR112'@'localhost' IDENTIFIED BY 'PGR112';

GRANT ALL PRIVILEGES ON universityDB.* TO 'examPGR112'@'localhost';

FLUSH PRIVILEGES;

CREATE TABLE Students (
                          studentID INT PRIMARY KEY,
                          name VARCHAR(100),
                          programID INT
);
CREATE TABLE Staff (
                       staffID INT PRIMARY KEY,
                       name VARCHAR(100),
                       role VARCHAR(50),
                       programID INT
);

CREATE TABLE Programs (
                          programID INT PRIMARY KEY,
                          programName VARCHAR(100),
                          programResponsibleID INT
);

ALTER TABLE Staff
    ADD FOREIGN KEY (programID) REFERENCES Programs(programID);

ALTER TABLE Programs
    ADD FOREIGN KEY (programResponsibleID) REFERENCES Staff(staffID);

ALTER TABLE Students
    ADD FOREIGN KEY (programID) REFERENCES Programs(programID);

create schema eventDB;

USE eventdb;

CREATE TABLE EventRegistrations (
                                    registrationID INT PRIMARY KEY,
                                    studentID INT,
                                    guestName VARCHAR(100),
                                    programID INT,
                                    FOREIGN KEY (studentID) REFERENCES universityDB.Students(studentID),
                                    FOREIGN KEY (programID) REFERENCES universityDB.Programs(programID)
);

Select * from eventregistrations;

GRANT ALL PRIVILEGES ON eventDB.* TO 'examPGR112'@'localhost';
FLUSH PRIVILEGES ;

INSERT INTO Students (studentID, name, programID) VALUES (1, 'Jonathan Ibsen', 3);
INSERT INTO Students (studentID, name, programID) VALUES (2, 'Lars Olsen', 2);
INSERT INTO Students (studentID, name, programID) VALUES (3, 'Anne Andersen', 3);
INSERT INTO Students (studentID, name, programID) VALUES (4, 'Per Johansen', 2);
INSERT INTO Students (studentID, name, programID) VALUES (5, 'Ingrid Pettersen', 1);
INSERT INTO Students (studentID, name, programID) VALUES (6, 'Emma Svendsen', 2);
INSERT INTO Students (studentID, name, programID) VALUES (7, 'Martin Pedersen', 3);
INSERT INTO Students (studentID, name, programID) VALUES (8, 'Jonas Eriksen', 2);

-- Insert into Programs
INSERT INTO Programs (programID, programName, programResponsibleID) VALUES (1, 'Cyber sikkerhet',1);
INSERT INTO Programs (programID, programName, programResponsibleID) VALUES (2, 'Interaksjonsdesign',1);
INSERT INTO Programs (programID, programName, programResponsibleID) VALUES (3, 'Frontend utvikling',1);


INSERT INTO Staff (staffID, name, role, programID) VALUES (1, 'Per Hansen', 'Programansvarlig', 1);
INSERT INTO Staff (staffID, name, role, programID) VALUES (2, 'Lise Olsen', 'Lærer', 2);
INSERT INTO Staff (staffID, name, role, programID) VALUES (3, 'Morten Pedersen', 'lærer', 3);
INSERT INTO Staff (staffID, name, role, programID) VALUES (4, 'Sofie Larsen', 'Lærer', 1);
INSERT INTO Staff (staffID, name, role, programID) VALUES (5, 'Erik Johansen', 'Lærer', 3);
INSERT INTO Staff (staffID, name, role, programID) VALUES (6, 'Johan Solbakken', 'lærer', 1);

Select *
FROM Programs;

select* from staff;

select* from Students;
use eventDB;
ALTER TABLE EventRegistrations MODIFY registrationID INT AUTO_INCREMENT;
use universityDB;
select * from EventRegistrations;