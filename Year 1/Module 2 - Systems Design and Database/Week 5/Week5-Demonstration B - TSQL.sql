-- TSQL-Mod03 - 03 - Querying Tables with SELECT
-- Author: Mansha Nawaz TU
-- MSDN SQL Server Documentatin: Select with Distinct
-- https://docs.microsoft.com/en-us/sql/dmx/select-distinct-from-model-dmx?view=sql-server-ver15

-- TSQL-Mod03 - Demonstration B - Use the TSQL database 

-- Step 1a: Connect to the TSQL database
-- The USE statement is not currently compatible with SQL Azure databases.
-- Instead, select TSQL from the Available Databases list

-- Step 1b: Try to execute the bellow statement
USE TSQL;
GO

-- Step 2: Include duplicate rows
-- Select and execute the following query to show duplicate rows 
-- returned from the Production.Products table. You should see 77 rows.
SELECT categoryid 
FROM Production.Products;


-- Step 3: Filtering out duplicate rows
-- Select and execute the following query to show duplicate rows 
-- filtered from the Production.Products table. You should see 8 rows.
SELECT DISTINCT categoryid 
FROM Production.Products;

SELECT DISTINCT supplierID 
FROM Production.Products;

