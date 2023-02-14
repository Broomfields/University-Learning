---------------------------------------------------------------------
---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 1: Writing Simple SELECT Statements
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 1: Exercise 2
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Task 1
-- Scenario: After supplying the marketing department with a list of all customers for a new campaign, you are asked to provide a list of all the countries that the customers come from. 
  -- Write a SELECT statement that Eliminating Duplicates with DISTINCT clause from the Sales.Customers table.
---------------------------------------------------------------------

SELECT DISTINCT country
FROM Sales.Customers;
