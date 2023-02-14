---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 3 - Sorting and Filtering Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 3: Exercise 4 - Solutions
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement to retrieve the custid, orderid, and orderdate columns from the Sales.Orders table. Order the rows by orderdate and orderid. Retrieve the first 20 rows.
-- Execute the written statement and compare the results that you got with the below given possible result of query.
---------------------------------------------------------------------

SELECT 
	custid, orderid, orderdate
FROM Sales.Orders
ORDER BY orderdate, orderid
OFFSET 0 ROWS FETCH FIRST 20 ROWS ONLY;

---------------------------------------------------------------------
-- Task 2
-- Copy the SELECT statement in task 1 and modify the OFFSET-FETCH clause to skip the first 20 rows and fetch the next 20 rows.
-- Execute the written statement and compare the results that you got with the below given possible result of query.
---------------------------------------------------------------------

SELECT 
	custid, orderid, orderdate
FROM Sales.Orders
ORDER BY orderdate, orderid
OFFSET 20 ROWS FETCH NEXT 20 ROWS ONLY;

---------------------------------------------------------------------
-- Task Extra
--You are given the parameters @pagenum for requested page number and @pagesize for requested page size. Can you work out how to write a generic form of the OFFSET-FETCH clause using those parameters? (Do not worry about not being familiar with those parameters yet.)
---------------------------------------------------------------------
-- Solution (fragment)
OFFSET (@pagenum - 1) * @pagesize ROWS FETCH NEXT @pagesize ROWS ONLY;

