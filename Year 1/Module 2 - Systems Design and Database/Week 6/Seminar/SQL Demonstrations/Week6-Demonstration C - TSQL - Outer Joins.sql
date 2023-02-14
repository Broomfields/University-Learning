-- Week - 06 - Querying Tables with SELECT
-- Author: Mansha Nawaz/Dr Yar Muhammad

-- Demonstration C - Joining multiple tables

--  Step 1: Open a new query window to the TSQL database
USE TSQL;
GO

-- Step 2: Join 2 tables
-- Select and execute the following query
-- to show only matching customers and orders
SELECT c.CustID, soh.OrderID
FROM Sales.Customers c JOIN Sales.Orders soh
ON c.CustID = soh.CustID;
-- (830 row(s) affected)

-- Step 3: Join 2 tables
-- Select and execute the following query
-- to show all customers and any matching orders
SELECT *
FROM Sales.Customers c LEFT OUTER JOIN Sales.Orders soh
ON c.CustID = soh.CustID;
-- (832 row(s) affected)

-- Step 4: Join 2 tables
-- Select and execute the following query to show
-- a left outer join
USE TSQL;
GO
SELECT c.custid, c.companyname, o.orderid, o.orderdate
FROM Sales.Customers AS c
LEFT OUTER JOIN Sales.Orders AS o
ON c.custid =o.custid;

-- Step 5: Join 2 tables
-- Select and execute the following query to
-- show customers without orders
USE TSQL;
GO
SELECT c.custid, c.companyname, o.orderid, o.orderdate
FROM Sales.Customers AS c
LEFT OUTER JOIN Sales.Orders AS o
ON c.custid =o.custid
WHERE o.orderid IS NULL;

-- Step 6: Join 2 tables
-- Select and execute the following query to
-- show a right outer join
USE TSQL;
GO
SELECT c.custid, c.companyname, o.orderid, o.orderdate
FROM Sales.Customers AS c
RIGHT OUTER JOIN Sales.Orders AS o
ON c.custid =o.custid;

-- Step 7: Join 2 tables
-- Select and execute the following query
-- to show orders without customers
USE TSQL;
GO
SELECT c.custid, c.companyname, o.orderid, o.orderdate
FROM Sales.Customers AS c
RIGHT OUTER JOIN Sales.Orders AS o
ON c.custid =o.custid
WHERE c.custid IS NULL;