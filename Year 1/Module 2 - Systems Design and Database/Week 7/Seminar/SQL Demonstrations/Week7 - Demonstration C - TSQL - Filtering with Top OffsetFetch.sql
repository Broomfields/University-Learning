-- Week - 07 - Sorting and Filtering Data
-- Author: Mansha Nawaz/Dr Yar Muhammad 

-- Demonstration C - Filtering with Top Offset/Fetch

-- Step 1: Connect to the TSQL database
USE TSQL;
GO

-- Step 1a: Run the following command and note the dates should be set as 2008

Select OrderID, OrderDate,  ShippedDate, requiredDate
from Sales.Orders
GO

-- To UPDATE values for a particular SET of data we can repare the environment by running the following query to update the dates to 2021)
UPDATE Sales.Orders 
SET	OrderDate = DATEADD(YEAR, 10, '2008-06-01'),
	ShippedDate = DATEADD(YEAR,11, '2008-06-08'),
	RequiredDate = DATEADD(YEAR,12, '2008-06-08');

-- Step 2: Use TOP to filter results
-- Most recent 6 orders
-- This will ignore rows with duplicate order dates
-- which would otherwise qualify
-- compare this to next example
SELECT TOP (6) OrderID, CustID, orderdate, MONTH(OrderDate) AS ordermonth
FROM Sales.Orders
order by OrderDate ASC;

-- Step 3: Use TOP to filter results
-- Most recent 10 orders
-- This will include rows with duplicate order dates
-- which qualify as most recent
SELECT TOP (10) OrderID, CustID, orderdate, MONTH(OrderDate) AS ordermonth
FROM Sales.Orders
order by OrderDate ASC;


-- Step 4: Use TOP to filter results
-- Top ten percent of rowcount by orderdate
SELECT TOP (10) percent OrderID, CustID, orderdate, MONTH(OrderDate) AS ordermonth
FROM Sales.Orders
order by OrderDate ASC;
-- 830 records so expect 10% records back - 83

-- Step 5: Use OFFSET/FETCH to filter results
-- OFFSET/FETCH examples
-- First 10 rows only as
-- alternative to SELECT TOP (10)
SELECT OrderID, CustID, OrderDate
FROM Sales.Orders
ORDER BY OrderDate ASC, OrderID DESC
OFFSET 0 ROWS FETCH FIRST 10 ROWS ONLY;

-- Step 6: Use OFFSET/FETCH to filter results
-- Skips first 10 rows, returns rows 11-20
SELECT OrderID, CustID, OrderDate
FROM Sales.Orders
ORDER BY OrderDate ASC, OrderID DESC
OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;

-- Step 7: Revert the changes made to date columns - revert back to the original values. 
UPDATE Sales.Orders
SET OrderDate = '2008-06-01', 
	ShippedDate = '2008-06-08';