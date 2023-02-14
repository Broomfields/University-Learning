---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 2: Querying with Multiple Tables
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 2: Exercise 4 - Solution
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Task 1
-- 
-- copy-paste text about lab from doc file
---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement to retrieve the custid and contactname columns from the Sales.Customers table and the orderid column from the Sales.Orders table. The statement should retrieve all rows from the Sales.Customers table.
-- Execute the written statement and compare the results that you got with the recommended result shown in the file 82 - Lab Exercise 4 - Task 1 Result.txt. 
--
-- Notice the values in the column orderid. Are there any missing values (marked as NULL)? Why? 

SELECT 
	c.custid, c.contactname, o.orderid
FROM Sales.Customers AS c
LEFT OUTER JOIN Sales.Orders AS o ON c.custid = o.custid;

