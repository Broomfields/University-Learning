---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 3 - Sorting and Filtering Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 3: Exercise 1 - Solutions
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement that will return the custid, companyname, contactname, address, city, country, and phone columns from the Sales.Customers table. 
-- Filter the results to include only the customers from the country Brazil.
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT
	custid, companyname, contactname, address, city, country, phone
FROM Sales.Customers
WHERE 
	country = N'Brazil';

---------------------------------------------------------------------
-- Task 2
-- Write a SELECT statement that will return the custid, companyname, contactname, address, city, country, and phone columns from the Sales.Customers table. 
-- Filter the results to include only customers from the countries Brazil, UK, and USA.
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT
	custid, companyname, contactname, address, city, country, phone
FROM Sales.Customers
WHERE 
	country IN (N'Brazil', N'UK', N'USA');

---------------------------------------------------------------------
-- Task 3
-- Write a SELECT statement that will return the custid, companyname, contactname, address, city, country, and phone columns from the Sales.Customers table. 
-- Filter the results to include only the customers with a contact name starting with the letter A.
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT
	custid, companyname, contactname, address, city, country, phone
FROM Sales.Customers
WHERE 
	contactname LIKE N'A%';

---------------------------------------------------------------------
-- Task 4
-- The IT department has written a T-SQL statement that retrieves the custid and companyname columns from the Sales.Customers table and the orderid column from the Sales.Orders table.
-- Execute the query. Notice two things: 
--  First, the query retrieves all the rows from the Sales.Customers table. 
--  Second, there is a comparison operator in the ON clause specifying that the city column should be equal to the value “Paris”.
---------------------------------------------------------------------

SELECT
	c.custid, c.companyname, o.orderid
FROM Sales.Customers AS c
LEFT OUTER JOIN Sales.Orders AS o ON c.custid = o.custid AND c.city = N'Paris';

SELECT
	c.custid, c.companyname, o.orderid
FROM Sales.Customers AS c
LEFT OUTER JOIN Sales.Orders AS o ON c.custid = o.custid 
WHERE 
	c.city = N'Paris';

---------------------------------------------------------------------
-- Task 5
-- Write a T-SQL statement to retrieve customers from the Sales.Customers table that do not have matching orders in the Sales.Orders table. 
-- Matching customers with orders is based on a comparison between the customer’s custid value and the order’s custid value. 
-- Retrieve the custid and companyname columns from the Sales.Customers table. 
-- (Hint: Use a T-SQL statement that is similar to the one in the previous task.)
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT
	c.custid, c.companyname
FROM Sales.Customers AS c
LEFT OUTER JOIN Sales.Orders AS o ON c.custid = o.custid 
WHERE o.custid IS NULL;
