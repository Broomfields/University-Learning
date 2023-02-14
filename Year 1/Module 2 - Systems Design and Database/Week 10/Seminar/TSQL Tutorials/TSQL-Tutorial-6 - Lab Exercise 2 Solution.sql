---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 6 - Using built in Functions
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 5: Exercise 2 - Solutions
---------------------------------------------------------------------
USE TSQL;
GO
---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement against the Sales.Customers table and retrieve the custid and contactname columns. 
-- Add a calculated column named segmentgroup using a logical function IIF with the value “Target group” for customers that are from Mexico and have in the contact title the value “Owner”. Use the value “Other” for the rest of the customers. 
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT
	IIF(country = N'Mexico' AND contacttitle = N'Owner', N'Target group', N'Other') AS segmentgroup, custid, contactname
FROM Sales.Customers;

---------------------------------------------------------------------
-- Task 2
-- Modify the T-SQL statement from task 1 to change the calculated column to show the value “Target group” for all customers without a missing value in the region attribute or with the value “Owner” in the contact title attribute.
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT
	IIF(contacttitle = N'Owner' OR region IS NOT NULL, N'Target group', N'Other') AS segmentgroup,  custid,  contactname
FROM Sales.Customers;

---------------------------------------------------------------------
-- Task 3
-- Write a SELECT statement against the Sales.Customers table and retrieve the custid and contactname columns. Add a calculated column named segmentgroup using the logic function CHOOSE with four possible descriptions (“Group One”, “Group Two”, “Group Three”, “Group Four”). Use the modulo operator on the column custid. (Use the expression custid % 4 + 1 to determine the target group.)
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT CHOOSE(custid % 4 + 1, N'Group One', N'Group Two', N'Group Three', N'Group Four') AS segmentgroup, custid, contactname
FROM Sales.Customers;


