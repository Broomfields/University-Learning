---------------------------------------------------------------------
---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 1: Writing Simple SELECT Statements
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 1: Exercise 1
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Scenario: As a business analyst, you want a better understanding of your corporate data. Usually, the best approach for an initial project is to get an overview of the main tables and columns, so you can better understand different business requirements. After an initial overview, you will provide a report for the marketing department, whose staff want to send invitation letters for a new campaign. You will use the TSQL sample database.
   -- Write a SELECT statement that will return all rows and all columns from the Sales.Customers table.
---------------------------------------------------------------------

SELECT *
FROM Sales.Customers;

GO

-- When writing queries we avoid using * and always specify the needed columns. 
-- One way to select all columns using SQL Management Studio is to use Object Explorer and expand the database TSQL
-- and then expand the table Sales.Customers and drag the Columns folder on to this script file.

SELECT custid, companyname, contactname, contacttitle, [address], city, region, postalcode, country, phone, fax
FROM Sales.Customers;

GO

---------------------------------------------------------------------
-- Write a query to display only selected columns 
---------------------------------------------------------------------

SELECT contactname, [address], postalcode, city, country
FROM Sales.Customers;

GO
