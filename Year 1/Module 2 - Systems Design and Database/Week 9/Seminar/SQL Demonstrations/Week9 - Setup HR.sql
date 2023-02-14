-- TSQL-Mod07 - Using DML to modify Data
-- Author: Mansha Nawaz TU

-- Setup exercise environment

-- just in case you have ran the exersise before ... 
DROP TABLE IF EXISTS Hr.employees; 
DROP TABLE IF EXISTS Sales.customers; 
DROP SCHEMA IF EXISTS Hr;
DROP SCHEMA IF EXISTS Sales;
GO

-- Excersise 1:  
-- Task A: Create a new Database called [tempdb] 
-- Task B: Create new schema called [Hr] and [Sales] for the [tempdb] 

CREATE DATABASE TempDB;

USE TempDB
GO
CREATE SCHEMA Hr
GO
CREATE SCHEMA Sales
GO

-- Note that there is a much more efficient way, as above, of deleting exisitng objects in SQL Server 2019. 
-- However one often needs to get meta data information from the Information_Schema so both 
-- methods are useful to know about. The alternative method is used in the 99 Cleanup script,
-- which can be used at the end of this lab or if you want to restart part way through.


-- Task C: Using the select statement copy over the TSQL.Hr.Employees data into the tempdb.Hr.Employees.
--         Add the check to see Drop the table if it already exists. 

IF EXISTS (	SELECT * 
			FROM INFORMaTION_SCHEMA.TABLES 
			WHERE TABLE_NAME = 'Employees'
			AND TABLE_SCHEMA = 'Hr' 
			AND TABLE_CATALOG = 'tempdb' )   
			DROP TABLE Hr.Employees 
GO

SELECT * INTO hr.employees FROM TSQL.hr.Employees;
GO

-- check to see if data has been transfered. 
Select * from tempdb.hr.employees


-- Task D: Using the select statement copy over the TSQL Sales.Customers data into the tempDB Sales.Customers.
-- However please xplude the following customer - 'Taylor, Maurice','Mallit, Ken' and 'Tiano, Mike' 
-- (Hint ContactName NOT IN)
-- Add the check to see Drop the table if it already exists.  

IF EXISTS (	SELECT * 
			FROM INFORMaTION_SCHEMA.TABLES 
			WHERE TABLE_NAME = 'Customers'
			AND TABLE_SCHEMA = 'sales' 
			AND TABLE_CATALOG = 'tempdb' ) 
			DROP TABLE sales.Customers; 
GO


SELECT * INTO sales.Customers from TSQL.Sales.Customers
WHERE contactname NOT IN (
'Taylor, Maurice',
'Mallit, Ken',
'Tiano, Mike');
GO

-- check to see if data has been transfered. 
Select * from tempdb.Sales.Customers


-- Task E: Using the select statement copy over the TSQL Sales.Customers data 
--         into the tempDB [PotentialCustomers] table
-- However we only need to include the following customer - 'Taylor, Maurice','Mallit, Ken' and 'Tiano, Mike' 
-- (Hint where ContactName IN)
-- Add the check to see Drop the table if it already exists.  

IF EXISTS (	SELECT * 
			FROM INFORMaTION_SCHEMA.TABLES 
			WHERE TABLE_NAME = 'PotentialCustomers'
			AND TABLE_SCHEMA = 'dbo' 
			AND TABLE_CATALOG = 'tempdb' ) 
			DROP TABLE tempdb.dbo.PotentialCustomers; 
GO

SELECT * INTO dbo.PotentialCustomers from TSQL.Sales.Customers
WHERE contactname IN (
'Taylor, Maurice',
'Mallit, Ken',
'Tiano, Mike');
GO

