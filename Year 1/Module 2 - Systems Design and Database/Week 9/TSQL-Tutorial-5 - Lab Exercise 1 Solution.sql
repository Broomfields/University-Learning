-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 5 - Using DML to modify Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 5: Exercise 1 - solution

USE TSQL

/***************************************************************
Task 1

Write an INSERT statement to add your Group member names and one more with listed as below value to the Employees table:
•Title: Sales Representative
•Titleofcourtesy: Mr
•FirstName: Laurence
•Lastname: Grider
•Hiredate: 04/04/2016
•Birthdate: 10/25/1975
•Address: 1234 1st Ave. S.E.
•City: Seattle
•Country: USA
•Phone: (206)555-0105
*****************************************************************/

INSERT INTO HR.Employees
(
Title,
titleofcourtesy,
FirstName,
Lastname,
hiredate,
birthdate,
address,
city,
country,
phone
)

VALUES
(
'Sales Representative',
'Mr',
'Laurence',
'Grider',
'04/04/2016',
'10/25/1975',
'1234 1st Ave. S.E.',
'Seattle',
'USA',
'(206)555-0105');

-- Select Record
Select *
From HR.Employees
where lastname = 'Grider'



