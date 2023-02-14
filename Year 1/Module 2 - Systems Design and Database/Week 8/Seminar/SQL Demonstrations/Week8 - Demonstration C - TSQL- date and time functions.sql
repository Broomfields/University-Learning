-- Week - 08 - Working with SQL Server Data
-- Author: Mansha Nawaz/Dr Yar Muhammad

--  Demonstration C - date and time functions

-- important to understand how to obtain different datetime patterns
-- Business Inteligence - Machine Inteligence - Artificial Intellegence 
-- Next Gen Systems: utlise datetime series for analytics & visuals, forecasting and predictive modeling 
-- IoT Devices interactions are datetime stamped - 500 billion IoT devices to come onboard 2030

-- Step 1: Connect to the TSQL database or execute the bellow statement
USE TSQL;
GO

-- Step 2: Display various current date and time functions

SELECT
	GETDATE()			AS [GetDate],
	CURRENT_TIMESTAMP	AS [Current_Timestamp], --for ANSI SQL compatibility
	GETUTCDATE()		AS [GetUTCDate],
	SYSDATETIME()		AS [SYSDateTime],
	SYSUTCDATETIME()	AS [SYSUTCDateTime],
	SYSDATETIMEOFFSET()	AS [SYSDateTimeOffset];
	
-- Step 3: Display various functions which return a portion of a date or time
SELECT DATENAME(weekday,'20210113');
SELECT DAY('20150113') AS [Day], MONTH('20210113') AS [Month],YEAR('20210113') AS [Year];
SELECT DATEPART(WEEKDAY,'20210113');

	
-- Step 4: Display various functions which return a date or time from parts
SELECT DATETIMEFROMPARTS(2021,2,12,8,30,0,0) AS Result; --7 arguments
SELECT DATETIME2FROMPARTS(2021,2,12,8,30,00,0,0) AS Result; -- 8 arguments
SELECT DATEFROMPARTS(2021,2,12) AS Result; -- 3 arguments
SELECT DATETIMEOFFSETFROMPARTS(2021,2,12,8,30,0,0,-7,0,0) AS Result;


-- Step 5: Demonstrate DATEDIFF with  this to show difference in precision:
SELECT DATEDIFF(millisecond, GETDATE(), SYSDATETIME()); 

-- Step 6: Modify datetime with EOMONTH and DATEADD:
SELECT DATEADD(day,2,'20210113');
SELECT EOMONTH('20210113'); --return the end of the month in which this date occurs
SELECT EOMONTH('20210113',2); --return the end of the month two months ahead of the this date

-- Step 7: Use ISDATE to check validity of inputs:
SELECT ISDATE('20150113'); --is valid
SELECT ISDATE('20120230'); --February doesn't have 30 days