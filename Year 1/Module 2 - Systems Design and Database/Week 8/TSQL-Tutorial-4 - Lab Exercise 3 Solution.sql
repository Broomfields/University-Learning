---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 4 - Working with SQL Server Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 4: Exercise 3 - Solutions
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement against the Sales.Customers table and retrieve the contactname and city columns. Concatenate both columns so that the new column looks like this:
--   Allen, Michael (city: Berlin)
-- Execute the written statement and compare the results that you got with the below given possible result of query. 
---------------------------------------------------------------------

SELECT 
	CONCAT(contactname, N' (city: ', city, N')') AS contactwithcity
FROM Sales.Customers;

SELECT 
	contactname + N' (city: ' + city + N')' AS contactwithcity 
FROM Sales.Customers;

---------------------------------------------------------------------
-- Task 2
-- Copy the T-SQL statement in task 1 and modify it to extend the calculated column with new information from the region column. Treat a NULL in the region column as an empty string for concatenation purposes. When the region is NULL, the modified column should look like this:
--  Allen, Michael (city: Berlin, region: )
-- When the region is not NULL, the modified column should look like this
--  Richardson, Shawn (city: Sao Paulo, region: SP)
-- Execute the written statement and compare the results that you got with the below given possible result of query. 
---------------------------------------------------------------------

SELECT 
	CONCAT(contactname, N' (city: ', city,  N', region: ', region, N')') AS fullcontact
FROM Sales.Customers;

SELECT 
	contactname + N' (city: ' + city + N', region: ' + COALESCE(region, '') + N')' AS fullcontact
FROM Sales.Customers;

---------------------------------------------------------------------
-- Task 3
-- Write a SELECT statement to retrieve the contactname and contacttitle columns from the Sales.Customers table. Return only rows where the first character in the contact name is ‘A’ through ‘G’.
-- Execute the written statement and compare the results that you got with the below given possible result of query. Notice the number of rows returned.
---------------------------------------------------------------------

SELECT contactname, contacttitle
FROM Sales.Customers
WHERE contactname LIKE N'[A-G]%'
ORDER BY contactname;


