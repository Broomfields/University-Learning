---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 4 - Working with SQL Server Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 4: Exercise 2 - Solution
---------------------------------------------------------------------
USE TSQL;
GO
---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement to retrieve distinct values for the custid column from the Sales.Orders table. Filter the results to include only orders placed in February 2008.
-- Execute the written statement and compare the results that you got with the possible result(s) of the query. 
---------------------------------------------------------------------

SELECT DISTINCT
	custid
FROM Sales.Orders 
WHERE 
	YEAR(orderdate) = 2008 
	AND MONTH(orderdate) = 2;

-- This one can better utilize indexing than the first solution.

SELECT DISTINCT
	custid
FROM Sales.Orders 
WHERE 
	orderdate >= '20080201'
	AND orderdate < '20080301';


---------------------------------------------------------------------
-- Task 2
-- Write a SELECT statement with these columns:
--  Current date and time
--  First date of the current month
--  Last date of the current month
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.  The results will differ because they rely on the current date.
---------------------------------------------------------------------

SELECT
	CURRENT_TIMESTAMP AS currentdate, 
	DATEADD (day, 1, EOMONTH(CURRENT_TIMESTAMP, -1)) AS firstofmonth,
	EOMONTH(CURRENT_TIMESTAMP) AS endofmonth;

---------------------------------------------------------------------
-- Task 3
-- Write a SELECT statement against the Sales.Orders table and retrieve the orderid, custid, and orderdate columns. Filter the results to include only orders placed in the last five days of the order month.
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT 
	orderid, custid, orderdate
FROM Sales.Orders
WHERE 
	DATEDIFF(
		day,
		orderdate,
		EOMONTH(orderdate)  
	) < 5;


---------------------------------------------------------------------
-- Task 4
-- Write a SELECT statement against the Sales.Orders and Sales.OrderDetails tables and retrieve all the distinct values for the productid column. Filter the results to include only orders placed in the first 10 weeks of the year 2007.
-- Execute the written statement and compare the results that you got with the possible result(s) of the query.
---------------------------------------------------------------------

SELECT DISTINCT
	d.productid
FROM Sales.Orders AS o
INNER JOIN Sales.OrderDetails AS d ON d.orderid = o.orderid
WHERE 
	DATEPART(week, orderdate) <= 10 
	AND YEAR(orderdate) = 2007;