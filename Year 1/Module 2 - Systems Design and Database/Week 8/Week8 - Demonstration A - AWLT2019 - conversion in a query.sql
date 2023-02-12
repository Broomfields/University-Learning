-- Week - 08 - Working with SQL Server Data
-- Author: Mansha Nawaz/Dr Yar Muhammad

-- Demonstration A - Conversion in a Query

-- Step 1: 
-- Switch the query window to use your copy of the AdventureWorksLT2019 database
-- Or execute the bellow statement
USE AdventureWorksLT2019;
GO

-- Step 2: Use implicit conversion in a query
-- Demonstrate implicit conversion from the lower type (varchar)
-- to the higher (int)
SELECT 1 + '2' AS result;

-- Step 3: Use implicit conversion in a query
-- Demonstrate implicit conversion from the lower type (varchar) 
-- to the higher (int)
-- NOTE: THIS WILL FAIL

SELECT 1 + 'abc' AS result;

-- Step 4: Use explicit conversion in a query

SELECT CAST(1 AS VARCHAR(10)) + 'abc' AS result;