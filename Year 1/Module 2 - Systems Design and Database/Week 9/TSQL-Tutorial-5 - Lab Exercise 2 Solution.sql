-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 5 - Using DML to modify Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 5: Exercise 2 - solution

USE TSQL

/***************************************************************
Task 1

-- Update the city as London of ‘Laurence Grinder’
*****************************************************************/
UPDATE HR.Employees
SET city = 'London'
WHERE lastname='Grider'

-- Select Record
Select *
From HR.Employees
where lastname = 'Grider'

/***************************************************************
Task 2
Update the contacttitle as 'Sales Consultant'. It is important that city should be 'Berlin' and contacttitle should be 'Sales Representative'.  Use table Sales.Customers
*****************************************************************/
UPDATE Sales.Customers
SET contacttitle = 'Sales Consultant'
WHERE city='Berlin'
AND contacttitle='Sales Representative';

-- Select Record
select * from sales.customers where city = 'berlin'


/***************************************************************
Task 3
Delete record where lastname is Grider
*****************************************************************/
DELETE FROM 
HR.Employees
where lastname = 'Grider'

-- Select Record where lastname is Grider
Select *
From HR.Employees
where lastname = 'Grider'
