-- Week - 07 - Sorting and Filtering Data
-- Author: Mansha Nawaz/Dr Yar Muhammad 

-- Demonstration B - Filter with WHERE

-- Step 1: Connect to the TSQL database
USE TSQL;
GO

-- Prepare the environment by running the following query (without this, all order dates are the same)
-- we are adding 10 & 11 days to the respective dates. 
UPDATE Sales.Orders 
SET	OrderDate = DATEADD(YEAR, 10, '2008-06-01'),
	ShippedDate = DATEADD(YEAR,11, '2008-06-08');

-- Step 2: Use WHERE to filter results
-- WHERE clause referencing an expression defined in the SELECT clause
-- 2a
SELECT OrderID, CustID, orderdate, MONTH(OrderDate) AS ordermonth
FROM Sales.Orders
where MONTH(OrderDate) = 6;
-- returns 830 records as all orders are in June. 

-- 2b
SELECT OrderID, CustID, orderdate
FROM Sales.Orders
where MONTH(OrderDate) = 1;
-- return no records as we do not have any orders in January

-- Step 3: Use WHERE to filter results
-- WHERE clause fails when referencing expression by alias
-- NOTE THIS WILL CAUSE AN ERROR - Invalid column name 'ordermonth'

SELECT OrderID, CustID, orderdate, MONTH(OrderDate) AS ordermonth
FROM Sales.Orders
where Ordermonth = 6;

-- Step 4: Use WHERE to filter results
-- Simple WHERE clause
SELECT Address, City, Region, country
FROM Sales.Customers
WHERE country = 'UK';

-- Step 5: Use WHERE to filter results
-- Filter by date
SELECT OrderID, OrderDate
FROM Sales.Orders
WHERE OrderDate > '2000-01-01';

-- Step 6: Use WHERE to filter results
-- Use of OR to check for multiple search values
SELECT Address, City, Region, country
FROM Sales.Customers
WHERE country = 'UK' or country = 'Canada';

-- Step 7: Use WHERE to filter results
-- Use IN operator to evaluate from a list
SELECT Address, City, Region, country
FROM Sales.Customers
WHERE country IN ('UK', 'Canada');

-- Step 8: Use WHERE to filter results
-- Use NOT operator with IN to provide an exclusion list
SELECT Address, City, Region, country
FROM Sales.Customers
WHERE country NOT IN ('UK', 'Canada');

-- Step 9: Use WHERE to filter results
-- Use logical operators to search within a range of dates
SELECT OrderID, RequiredDate
FROM Sales.Orders
WHERE RequiredDate >= '20080601' AND OrderDate <= '20080801';
-- 13 rows returned

-- Step 10: Use WHERE to filter results
-- Use BETWEEN operator to search within a range of dates
SELECT OrderID, RequiredDate
FROM Sales.Orders
WHERE RequiredDate BETWEEN '20080601' AND '20080801';

-- Step 11: Revert the changes made to date columns
UPDATE Sales.Orders
SET OrderDate = '2008-06-01', 
	ShippedDate = '2008-06-08';