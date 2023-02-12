-- TSQL-Mod03 - 03 - Querying Tables with SELECT
-- Author: Mansha Nawaz TU
-- Demonstration A - Use the AdventureWorksLT2019 database 


-- Step 1a: Connect to the AdventureWorksLT database
-- The USE statement is not currently compatible with SQL Azure databases.
-- Instead, select TSQL from the Available Databases list

-- Step 1b: Try to execute the bellow statement
USE TSQL;
GO

-- Step 2: Simple SELECT query
-- Select and execute the following query to retrieve all columns, 
-- all rows from SalesLT.ProductCategory table
SELECT *
FROM Production.Categories;



-- Step 3: Simple SELECT query
-- Select and execute the following query to retrieve all columns, 
-- all rows from Production.Categories table without using *
SELECT CategoryID, CategoryName, Description
FROM Production.Categories;


-- Step 4: Simple SELECT query
-- Select and execute the following query to retrieve only ProductID, 
-- ProductName, UnitPrice columns from the Production.Products table
SELECT ProductID, ProductName, UnitPrice, supplierid, categoryid
FROM Production.Products;
  

-- Step 5: Simple SELECT query
-- Select and execute the following query to retrieve only Title, FirstName,
-- LastName, CompanyName, EmailAddress columns from the SalesLT.customer table
SELECT custid, companyname, contactName, city, phone
FROM Sales.customers;


-- Step 6: Simple SELECT query with calculated column
-- Select and execute the following query to manipulate columns from Production.Products table. 
-- Note the lack of name for the new calculated column.
SELECT ProductID, productName, unitPrice, (unitPrice * 1.1) 
FROM Production.Products;
-- same example with a with a new column name
SELECT ProductID, productName, unitPrice, (unitPrice * 1.1) as NewListPrice
FROM Production.Products;


-- Step 7: Simple SELECT query with calculated column
-- Select and execute the following query to manipulate columns from the Sales.OrderDetails table. 
-- Note the lack of name for the new calculated column.
SELECT OrderID, ProductID, UnitPrice, Qty, (UnitPrice * Qty)
FROM Sales.OrderDetails;
-- with a new column name [sub-total]
SELECT OrderID, ProductID, UnitPrice, Qty, (UnitPrice * Qty) AS [sub-total] 
FROM Sales.OrderDetails;