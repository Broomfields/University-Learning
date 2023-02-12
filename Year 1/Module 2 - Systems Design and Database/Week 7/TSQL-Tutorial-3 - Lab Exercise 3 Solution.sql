---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 3 - Sorting and Filtering Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 3: Exercise 3 - Solutions
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement against the Sales.Orders table and retrieve the orderid and orderdate columns. 
-- Retrieve the 20 most recent orders, ordered by orderdate.
-- Execute the written statement and compare the results that you got with the below given possible result of query.
---------------------------------------------------------------------

SELECT 
	custid, orderid, orderdate
FROM Sales.Orders
ORDER BY orderdate, orderid
OFFSET 0 ROWS FETCH FIRST 20 ROWS ONLY;

---------------------------------------------------------------------
-- Task 2
-- Write a SELECT statement to retrieve the same result as in task 1, but use the OFFSET-FETCH NEXT clause.
-- Execute the written statement and compare the results that you got with the results from task 1.
---------------------------------------------------------------------

SELECT 
	custid, orderid, orderdate
FROM Sales.Orders
ORDER BY orderdate, orderid
OFFSET 20 ROWS FETCH NEXT 20 ROWS ONLY;

---------------------------------------------------------------------
-- Extra Task
-- Write a SELECT statement to retrieve the productname and unitprice columns from the Production.Products table.
-- Execute the T-SQL statement and notice the number of the rows returned.
-- Modify the SELECT statement to include only the top 10 percent of products based on unitprice ordering.
-- Execute the written statement and compare the results that you got with the recommended result shown in the file 73 - Lab Exercise 3 - Task 2 Result.txt. Notice the number of rows returned.
-- Is it possible to implement this task with the OFFSET-FETCH clause?
---------------------------------------------------------------------
-- Solution (fragment)
OFFSET (@pagenum - 1) * @pagesize ROWS FETCH NEXT @pagesize ROWS ONLY;

