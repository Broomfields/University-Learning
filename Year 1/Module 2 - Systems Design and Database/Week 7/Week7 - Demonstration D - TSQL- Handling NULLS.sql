-- Week - 07 - Sorting and Filtering Data
-- Author: Mansha Nawaz/Dr Yar Muhammad 

-- Demonstration D - Handling NULLS

-- Step 1: Connect to the AdventureWorksLT2019 database
USE TSQL;
GO

--  Step 2: Returning results including NULL
-- NULL handling examples
-- Show the presence of NULL in the MiddleName column
-- and ORDER BY sorting NULL together and first
SELECT CustId, ContactTitle, ContactName, companyname, Region
FROM Sales.Customers
ORDER BY ContactName;

--  Step 3: Handling NULLs
-- This query eliminates NULLs in region
SELECT CustId, ContactTitle, ContactName, companyname, Region
FROM Sales.Customers
WHERE region <> N'A.'
ORDER BY ContactName; 
-- The "N" prefix stands for National Language in the SQL-92 standard, 
-- you may see it in old TSQL and must be uppercase. 
-- If you do not prefix a Unicode string constant with N, 
-- SQL Server will convert it to the non-Unicode code page of the
-- current database before it uses the string.
-- it is of no relevence but you may come across the convention in Industry


--  Step 4:  Handling NULLs
-- This query selects top 10 and also eliminates NULLs in region
SELECT top 10 CustId, ContactTitle, ContactName, companyname, Region
FROM Sales.Customers
WHERE region <> N'A.'
ORDER BY ContactName; 

--  Step 5:  Handling NULLs
-- Show how testing for NULL with an equality will
-- return an empty result set
-- might be misinterpreted as an absence of NULLs
SELECT CustId, ContactTitle, ContactName, companyname, Region
FROM Sales.Customers
WHERE region = N'A.'
ORDER BY ContactName; 

--  Step 6:  Handling NULLs
-- This query explicitly includes only NULLs
SELECT CustId, ContactTitle, ContactName, companyname, Region
FROM Sales.Customers
WHERE region is null 
ORDER BY ContactName; 

--  Step 7:  Handling NULLs
-- This query explicitly excludes NULLs
SELECT CustId, ContactTitle, ContactName, companyname, Region
FROM Sales.Customers
WHERE region IS NOT NULL  
ORDER BY ContactName; 