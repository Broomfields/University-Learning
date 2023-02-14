---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 1: Writing Simple SELECT Statements
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 1: Exercise 3
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Scenario: After receiving the initial list of customers, the marketing department would like to have column titles that are more readable and a list of all products in the TSQL database.
-- Write a SELECT statement that Using Column and Table Aliases from the Sales.Customers and Production.Products tables.
---------------------------------------------------------------------

-- Columns and Tables Aliases on Sales.Customers
SELECT C.contactname AS Name, C.contacttitle AS Title, C.companyname AS [Company Name]
FROM Sales.Customers AS C;

-- Columns and Tables Aliases on Production.Products
SELECT P.productname AS [Product Name]
FROM Production.Products AS P;
