-- Systems Design and Databases (CIS1018-N)
-- TSQL Tutorial 5 - Using DML to modify Data
-- Author: Mansha Nawaz TU/Dr Yar Muhammad

-- TSQL Tutorial 5: Cleanup - solution

USE tempdb
GO

DROP TABLE IF EXISTS dbo.PotentialCustomers
GO

DROP TABLE IF EXISTS Sales.Customers
GO

DROP TABLE IF EXISTS HR.employees
GO

DROP SCHEMA  IF EXISTS Hr
GO

DROP SCHEMA  IF EXISTS Sales
GO