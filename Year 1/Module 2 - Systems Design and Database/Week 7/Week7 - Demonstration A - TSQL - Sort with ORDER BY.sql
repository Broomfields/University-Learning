-- Week - 07 - Sorting and Filtering Data
-- Author: Mansha Nawaz/Dr Yar Muhammad

-- Demonstration A - Sort and Filter - ORDER BY
-- date support: https://www.w3schools.com/sqL/func_sqlserver_dateadd.asp
-- update support: https://www.w3schools.com/SQL/sql_update.asp
-- set Operators %: https://www.w3schools.com/sql/sql_operators.asp

-- Step 1: Connect to the AdventureWorksLT2019 database
-- Step 1b: Try to execute the bellow statement
USE TSQL;
GO

-- list the records we are going to update the Date fields 
-- and note all the dates should be 2008
SELECT OrderID, CustID, OrderDate, shippeddate, shipname
FROM Sales.Orders
ORDER BY OrderDate;

-- Demo results for sales.orderid on 2006-07-08
SELECT OrderID, CustID, OrderDate, shippeddate, shipname
FROM Sales.Orders
where OrderDate = '2008-06-01'
ORDER BY OrderDate;

-- Prepare the environment by running the following query (without this, all order dates are the same)
-- we are adding 10 & 11 years to the respective dates. 
UPDATE Sales.Orders 
SET	OrderDate = DATEADD(YEAR, 10, '2008-06-01'),
	ShippedDate = DATEADD(YEAR,11, '2008-06-08');

-- Step 2: Use ORDER BY to sort results 
-- Sorting by column name
-- Demo results for updating dates to 2018 onwards
SELECT OrderID, CustID, OrderDate, shippeddate, shipname
FROM Sales.Orders
where OrderDate = '2018-06-01'
ORDER BY OrderDate;


-- Step 3: Use ORDER BY to sort results
-- Sorting by column alias name
SELECT OrderID, CustID, MONTH(OrderDate) AS ordermonth
FROM Sales.Orders
ORDER BY ordermonth DESC;

-- Step 4: Use ORDER BY to sort results
-- Sorting by column name in descending order
SELECT OrderID, CustID, OrderDate
FROM Sales.Orders
ORDER BY OrderDate DESC;

-- Step 5: Use ORDER BY to sort results
-- Changing sort order for multiple columns
SELECT City, CustID, CompanyName
FROM Sales.Customers
ORDER BY City DESC, CustID ASC;

-- Step 6: Revert the changes made to date columns
UPDATE Sales.Orders
SET OrderDate = '2008-06-01', 
	shippeddate = '2008-06-08';

-- list the records with changes -update changes
Select OrderDate = '2008-06-01', 
	ShipDate = '2008-06-08'
from Sales.Orders 

