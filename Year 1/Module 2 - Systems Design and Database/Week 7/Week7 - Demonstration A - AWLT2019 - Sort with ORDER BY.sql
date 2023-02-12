-- Week - 07 - Sorting and Filtering Data
-- Author: Mansha Nawaz/Dr Yar Muhammad

-- Demonstration A - ORDER BY

-- Step 1: Connect to the AdventureWorksLT2019 database
-- Step 1b: Try to execute the bellow statements
USE AdventureWorksLT2019;
GO

-- list the records we are going to update the Date fields 
SELECT SalesOrderID, CustomerID, OrderDate, ShipDate, DueDate
FROM SalesLT.SalesOrderHeader
ORDER BY OrderDate;

-- Demo results for salesorderid = 71782
SELECT SalesOrderID, CustomerID, OrderDate, ShipDate, DueDate
FROM SalesLT.SalesOrderHeader
where SalesOrderID = 71782 
ORDER BY OrderDate;

-- Prepare the environment by running the following query (without this, all order dates are the same)
-- we are adding 1, 7 or 14 days to the respective dates. 
UPDATE SalesLT.SalesOrderHeader 
SET	OrderDate = DATEADD(D, 1, '2008-06-01'),
	ShipDate = DATEADD(D,7, '2008-06-08'),
	DueDate = DATEADD(D,14,'2008-06-13');

-- Demo results for salesorderid = 71782
SELECT SalesOrderID, CustomerID, OrderDate, ShipDate, DueDate
FROM SalesLT.SalesOrderHeader
where SalesOrderID = 71782 
ORDER BY OrderDate;

select * from SalesLT.SalesOrderHeader;

-- Step 2: Use ORDER BY to sort results 
-- Sorting by column name
SELECT SalesOrderID, CustomerID, OrderDate, ShipDate, DueDate
FROM SalesLT.SalesOrderHeader
where SalesOrderID = 71782 
ORDER BY OrderDate;

-- Step 3: Use ORDER BY to sort results
-- Sorting by column alias name
SELECT SalesOrderID, CustomerID, MONTH(OrderDate) AS ordermonth
FROM SalesLT.SalesOrderHeader
ORDER BY ordermonth DESC;

-- Step 4: Use ORDER BY to sort results
-- Sorting by column name in descending order
SELECT SalesOrderID, CustomerID, OrderDate
FROM SalesLT.SalesOrderHeader
ORDER BY OrderDate DESC;

-- Step 5: Use ORDER BY to sort results
-- Changing sort order for multiple columns
SELECT ModifiedDate, CustomerID, CompanyName
FROM SalesLT.Customer
ORDER BY ModifiedDate DESC, CustomerID ASC;

-- Step 6: Revert the changes made to date columns
UPDATE SalesLT.SalesOrderHeader 
SET OrderDate = '2008-06-01', 
	ShipDate = '2008-06-08',
	DueDate = '2008-06-13';

-- list the records with changes -update changes
Select OrderDate = '2008-06-01', 
	ShipDate = '2008-06-08',
	DueDate = '2008-06-13'
from SalesLT.SalesOrderHeader 

