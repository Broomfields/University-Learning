---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 4 - Working with SQL Server Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 4: Exercise 4 - Solutions
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement to retrieve the contactname column from the Sales.Customers table. Based on this column, add a calculated column named lastname, which should consist of all the characters before the comma.
-- Execute the written statement and compare the results that you got with the below given possible result of query. 
---------------------------------------------------------------------

SELECT
	contactname,
	SUBSTRING(contactname, 0, CHARINDEX(N',', contactname)) AS lastname
FROM Sales.Customers;

---------------------------------------------------------------------
-- Task 2
-- Write a SELECT statement to retrieve the contactname column from the Sales.Customers table and replace the comma in the contact name with an empty string. Based on this column, add a calculated column named firstname, which should consist of all the characters after the comma.
-- Execute the written statement and compare the results that you got with the below given possible result of query.

---------------------------------------------------------------------

SELECT
	REPLACE(contactname, ',', '') AS newcontactname,
	SUBSTRING(contactname, CHARINDEX(N',', contactname)+1, LEN(contactname)-CHARINDEX(N',', contactname)+1) AS firstname
FROM Sales.Customers;

---------------------------------------------------------------------
-- Task 3
-- Write a SELECT statement to retrieve the custid column from the Sales.Customers table. Add a new calculated column to create a string representation of the custid as a fixed-width (6 characters) customer code prefixed with the letter C and leading zeros. For example, the custid value 1 should look like C00001.
-- Execute the written statement and compare the results that you got with the below given possible result of query.
---------------------------------------------------------------------

SELECT 
	custid,
	N'C' + RIGHT(REPLICATE('0', 5) + CAST(custid AS VARCHAR(5)), 5) AS custnewid
FROM Sales.Customers;

-- using FORMAT
SELECT
	custid,
	FORMAT(custid, N'\C00000') AS custnewid
FROM Sales.Customers;

---------------------------------------------------------------------
-- Task 4
-- Write a SELECT statement to retrieve the contactname column from the Sales.Customers table. Add a calculated column, which should count the number of occurrences of the character ?a? inside the contact name. (Hint: Use the string functions REPLACE and LEN.) Order the result from rows with the highest occurrences to lowest.
-- Execute the written statement and compare the results that you got with the below given possible result of query. 
---------------------------------------------------------------------

SELECT
	contactname,
	LEN(contactname) - LEN(REPLACE(contactname, 'a', '')) AS numberofa
FROM Sales.Customers
ORDER BY numberofa DESC;

