-- Week - 07 - Sorting and Filtering Data
-- Author: Mansha Nawaz/Dr Yar Muhammad 

-- Demonstration C - Filtering with Top Offset/Fetch

-- Step 1: Connect to the AdventureWorksLT database
USE AdventureWorksLT2019;
GO

-- Step 1a: Run the following command and note the dates should be set as 2008

Select SalesOrderID, OrderDate, DueDate, ShipDate
from SalesLT.SalesOrderHeader
GO

-- To UPDATE values for a particular SET of data we can repare the environment by running the following query to update the dates to 2021)
UPDATE SalesLT.SalesOrderHeader 
SET	OrderDate = DATEADD(d,SalesOrderID % 7, '2021-06-01'),
	ShipDate = DATEADD(d,7 + (SalesOrderID % 7), '2021-06-08'),
	DueDate = DATEADD(d,14 + (SalesOrderID % 7), '2021-06-13');

-- Step 2: Use TOP to filter results
-- Most recent 6 orders
-- This will ignore rows with duplicate order dates
-- which would otherwise qualify
-- compare this to next example
SELECT TOP (6) SalesOrderID, CustomerID, OrderDate
FROM SalesLT.SalesOrderHeader
ORDER BY OrderDate ASC;

-- Step 3: Use TOP to filter results
-- Most recent 6 orders
-- This will include rows with duplicate order dates
-- which qualify as most recent
SELECT TOP (6) WITH TIES SalesOrderID, CustomerID, OrderDate
FROM SalesLT.SalesOrderHeader
ORDER BY OrderDate ASC;

-- Step 4: Use TOP to filter results
-- Top ten percent of rowcount by orderdate
SELECT TOP (10) PERCENT SalesOrderID, CustomerID, OrderDate
FROM SalesLT.SalesOrderHeader
ORDER BY OrderDate ASC;

-- Step 5: Use TOP to filter results
-- Point out that without an ORDER BY clause
-- SQL Server may return any 5 rows
SELECT TOP (6) SalesOrderID, CustomerID, OrderDate
FROM SalesLT.SalesOrderHeader;

-- Step 6: Use OFFSET/FETCH to filter results
-- OFFSET/FETCH examples
-- First 10 rows only as
-- alternative to SELECT TOP (10)
SELECT SalesOrderID, CustomerID, OrderDate
FROM SalesLT.SalesOrderHeader
ORDER BY OrderDate ASC, SalesOrderID DESC
OFFSET 0 ROWS FETCH FIRST 10 ROWS ONLY;

-- Step 7: Use OFFSET/FETCH to filter results
-- Skips first 10 rows, returns rows 11-20
SELECT SalesOrderID, CustomerID, OrderDate
FROM SalesLT.SalesOrderHeader
ORDER BY OrderDate ASC, SalesOrderID DESC
OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;

-- Step 8: Revert the changes made to date columns - revert back to the original values. 
UPDATE SalesLT.SalesOrderHeader 
SET OrderDate = '2008-06-01', 
	ShipDate = '2008-06-08',
	DueDate = '2008-06-13';