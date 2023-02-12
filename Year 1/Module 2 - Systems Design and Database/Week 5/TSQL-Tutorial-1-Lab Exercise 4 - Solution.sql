---------------------------------------------------------------------
-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 1: Writing Simple SELECT Statements
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 1: Exercise 5
---------------------------------------------------------------------
USE TSQL;
GO

-- Scenario: Your company has a long list of products and the members of the marketing department would like to have product category information in their reports. They have supplied you with a document containing the following mapping between the product category IDs and their names:
--	Categoryid	categoryname
--	1		Beverages
--	2		Condiments
--	3		Confections
--	4		Dairy Products
--	5		Grains/Cereals
--	6		Meat/Poultry
--	7		Produce
--	8		Seafood
-- They have an active marketing campaign for categorid (1, 7, 8), and would like to include product category information in their reports. 
-- Learn more about SQL Case Expression: https://www.w3schools.com/sql/sql_case.asp 
-- •	Write a SELECT statement that Using a Simple CASE Expression from the Production.Products table.
---------------------------------------------------------------------

SELECT p.categoryid, p.productname,
		CASE 
			WHEN p.categoryid = 1 THEN 'Beverages'
			WHEN p.categoryid = 2 THEN 'Condiments'
			WHEN p.categoryid = 3 THEN 'Confections'
			WHEN p.categoryid = 4 THEN 'Dairy Products'
			WHEN p.categoryid = 5 THEN 'Grains/Cereals'
			WHEN p.categoryid = 6 THEN 'Meat/Poultry'
			WHEN p.categoryid = 7 THEN 'Produce'
			WHEN p.categoryid = 8 THEN 'Seafood'
			ELSE 'Other'
		END AS categoryname,
		CASE	
			WHEN p.categoryid IN (1, 7, 8) THEN 'Campaign Products'
			ELSE 'Non-Campaign Products' 
		END AS iscampaign
FROM Production.Products AS p;


-- Below are basic tasks to understand step by step above task
---------------------------------------------------------------------
-- Task 1
-- Write a SELECT statement to display the categoryid and productname columns from the Production.Products table.
---------------------------------------------------------------------

SELECT p.categoryid, p.productname
FROM Production.Products AS p;

---------------------------------------------------------------------
-- Task 2
-- Enhance the SELECT statement in task 1 by adding a CASE expression that generates a result column named categoryname. The new column should hold the translation of the category ID to its respective category name, based on the mapping table supplied earlier. Use the value “Other” for any category IDs not found in the mapping table.
---------------------------------------------------------------------

SELECT p.categoryid, p.productname,
		CASE 
			WHEN p.categoryid = 1 THEN 'Beverages'
			WHEN p.categoryid = 2 THEN 'Condiments'
			WHEN p.categoryid = 3 THEN 'Confections'
			WHEN p.categoryid = 4 THEN 'Dairy Products'
			WHEN p.categoryid = 5 THEN 'Grains/Cereals'
			WHEN p.categoryid = 6 THEN 'Meat/Poultry'
			WHEN p.categoryid = 7 THEN 'Produce'
			WHEN p.categoryid = 8 THEN 'Seafood'
			ELSE 'Other'
		END AS categoryname
FROM Production.Products AS p;