-- Week - 08 - Working with SQL Server Data
-- Author: Mansha Nawaz/Dr Yar Muhammad
-- MSDN SQL Server Documentation
-- https://docs.microsoft.com/en-us/sql/t-sql/statements/collations?view=sql-server-ver15

-- Demonstration B - collation in a query

-- Step 1: Connect to the TSQL database or execute the bellow statement
USE TSQL;
GO


-- Step 2: Use collation in a query
SELECT CustId, contactName, contacttitle 
FROM Sales.Customers
WHERE contacttitle COLLATE Latin1_General_CS_AS = N'Owner';


-- Step 3a: Use a case sensitive collation in a query
SELECT CustId, contactName, contacttitle 
FROM Sales.Customers
WHERE contacttitle COLLATE Latin1_General_CS_AS = N'owner';
-- NOTE: this will return no results du to bieng case sensitive 

-- Step 3b:
SELECT CustId, contactName, contacttitle 
FROM Sales.Customers
WHERE contacttitle COLLATE Latin1_General_CS_AS = N'Owner';
-- NOTE: the change in this query from the previous query is the case of the search term

-- Step 4: Using the CONCAT function to join strings
SELECT CustId, contactName, address, city, postalcode, 
CONCAT(address, N', ' + city, N' ', postalcode) AS FullAddress
FROM Sales.Customers;

-- Step 5: Use concatenation with + (plus) in a query
SELECT CustId, contactName, address, city, postalcode, 
(address + N' ' + city + N' ' + postalcode) AS FullAddress
FROM Sales.Customers;

-- Step 6: Use string functions in a query
-- FORMAT
DECLARE @m money = 120.595
SELECT @m AS unformatted_value, 
FORMAT(@m,'C','zh-cn') AS zh_cn_currency,
FORMAT(@m,'C','en-us') AS en_us_currency,
FORMAT(@m,'C','de-de') AS de_de_currency,
FORMAT(@m,'C','en-uk') AS en_uk_currency;
-- end FORMAT example

SELECT SUBSTRING('Microsoft SQL Server',11,3) AS Result;
SELECT LEFT('Microsoft SQL Server',9) AS left_example, RIGHT('Microsoft SQL Server',6) as right_example;

SELECT LEN('Microsoft SQL Server     ') AS [LEN];
SELECT DATALENGTH('Microsoft SQL Server     ') AS [DATALENGTH];

SELECT CHARINDEX('SQL','Microsoft SQL Server') AS Result;

SELECT REPLACE('Learning about T-SQL string functions','T-SQL','Transact-SQL') AS Result;

SELECT UPPER('Microsoft SQL Server') AS UP, LOWER('Microsoft SQL Server') AS LOW;

-- Step 7: Use the LIKE predicate in a query - the % (percent) character
-- contactname begining with be
SELECT contactname, city, postalcode
FROM Sales.Customers
WHERE City LIKE N'Be%'

-- Step 8: Use the LIKE predicate in a query - the % (percent) character
-- contactname containing ja
SELECT contactname, city, postalcode
FROM Sales.Customers
WHERE Contactname LIKE N'%ja%'