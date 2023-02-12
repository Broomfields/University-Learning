-- get the date

--The time zone offset is not included for CURRENT_TIMESTAMP ( but I get the same values for both )
select CURRENT_TIMESTAMP, getdate(), GETUTCDATE()

create table tblMember
(
  id int identity,
  name varchar(100),
  DOB varchar(50)
)

insert into tblMember values('Fred', '1969/02/17'), ('Bill', '1971/07/04'), ('Bob', '1973/09/15'), ('Sarah', 'The first Monday in 1982')
insert into tblMember values('Robert', '05/14/1995'), ('Hank', '13/05/2001'), ('Laura', 'Feb 17 1969'), ('Emma', 'Not telling')


-- Checking for invalid values in SS2012

select id, name, dob from tblMember where try_parse(DOB as date) is null

-- checking in SS2008
select id, name, dob from tblMember where isdate(DOB) = 0

-- invalid values break this completely
select  CONVERT(nvarchar(30), DOB, 109) from tblMember

-- This will work, but it won't format the dates
select DOB,  CONVERT(nvarchar(30), DOB, 109) from tblMember where isdate(DOB) = 1

-- this works
select DOB,  CONVERT(nvarchar(30), convert(datetime,DOB), 109) from tblMember where isdate(DOB) = 1


Alter Table tblMember Add Birthday date

-- error
update tblMember set Birthday = DOB

-- works
update tblMember set Birthday = try_parse(DOB as date)

-- works for SS < 2012
update tblMember set Birthday = convert(date,DOB) where isdate(dob)

select * from tblMember

-- breaks
select datepart(dw, dob) from tblMember

select datepart(dw, dob) from tblMember where isdate(dob) = 1

-- day of week
select datepart(dw, birthday) from tblMember

-- day of year
select datepart(dy, birthday) from tblMember

-- days since birth
select datediff(dd, birthday, getdate()) from tblMember

-- age
select datediff(yy, birthday, getdate()) from tblMember

-- month name
select datename(mm, current_timestamp)

-- custom format
select convert(char(4), year(birthday)) + '->' +
case when month(birthday) < 10 then '0' else '' end +
 convert(char(2), month(birthday)) + '->' +
 case when month(birthday) < 10 then '0' else '' end +
 convert(char(2), day(birthday)) from tblMember

-- easier in SS2012
select format(birthday, 'YYYY->MM->dd') from tblMember

-- selecting based on birthday

select * from tblMember where dob = 'Feb 17 1969'

select * from tblMember where birthday = 'Feb 17 1969'


select * from tblMember order by dob desc

select * from tblMember order by birthday desc

-- turning datetime in to date or time
declare @now datetime = getdate()
declare @nowDate date = convert(date, @now)
declare @nowTime time = convert(time, @now)

select @now, @nowDate, @nowTime

declare @now datetime = getdate()
declare @nowTime time = convert(time, @now)
set @now = convert(datetime, @nowTime)
select @now

-- operations with date times
-- a whole block of code below relies on these values, it may be easier to copy this first block in to a new file and copy across things as you test them
declare @now datetime = getdate()
declare @then datetime = dateadd(dd, 45, @now)
set @then = dateadd(minute, 164, @then)
select @now, @then

declare @nowDate date = convert(date, @now)
declare @nowTime time = convert(time, @now)
declare @thenDate date = convert(date, @then)
declare @thenTime time = convert(time, @then)

-- + assumes that 1900 is the baseline year, it counts as 'zero'.
select @then + @now
select @then - @now

-- This is the only reasonable use I can see of using these sort of operators
select convert(time, (@then - @now))

-- if the result was > 24 hours, the result would be just the time component, not an actual time span
select convert(time, (convert(datetime, '2012/02/01 12:00:00') - convert(datetime, '2012/01/01 06:30:00')))

-- both date and time are invalid for both subtraction and addition
--select @thenDate + @nowDate
--select @thenTime + @nowTime
--select @thenDate - @nowDate
--select @thenTime - @nowTime

-- Use CTRL-K, CTRL-C to comment the block above so it does not try to run.  CTRL-K, CTRL-U will uncomment

-- datediff is more useful anyhow, as you can get just the info you're after
select datediff(dd, @nowdate, @thendate)
select datediff(mm, @nowdate, @thendate)

-- this also works with datetimes
select datediff(day, @now, @then)
select datediff(mm, @now, @then)

-- A combination of dates and datetimes is fine
select datediff(dd, @now, @thenDate)
select datediff(mm, @nowDate, @then)

select datediff(minute, @nowTime, @thenTime)

-- this returns -59988960, because if one has a date and the other does not, 1900/1/1 is assumed and that skews the result
select datediff(minute, @now, @thenTime)

-- Other combinations create their own issues, using just a date, assumes a time of 00:00:00
select datediff(minute, @nowDate, @thenDate)
select datediff(minute, @now, @thenDate)


-- SS2012 create date types from parts

select datefromparts(2012, 12, 1)

select DATETIMEFROMPARTS(2012, 12, 1, 10, 15, 30, 000)

-- the last argument is how many significant chars are in the millisecond part
select DATETIME2FROMPARTS(100, 12, 1, 10, 15, 30, 279, 5)

select SMALLDATETIMEFROMPARTS(1900, 12, 1, 10, 15)

-- Againt, the milliseconds have a variable # of chars
select TIMEFROMPARTS(12,30,15,1, 2)

SELECT DATETIMEOFFSETFROMPARTS ( 2010, 12, 31, 14, 23, 23, 0, 12, 0, 7 )

-- gets the last day of the month
select EOMONTH(getdate())

-- gets the last day of last month
select EOMONTH(getdate(), -1)

-- the number of the first day of the week ( defaults to 7, sunday )
select @@DATEFIRST

-- Show how this works
SET DATEFIRST 7;
declare @now datetime
set @now = getdate()

-- this will tell you what day of the week today currently is
SELECT @Now as  SelectDate
    ,DATEPART(dw, @Now) AS DayOfWeek;

-- This will tell you the day of the week, if Wednesday was the first day of the week.
SET DATEFIRST 3;
-- Because Wednesday is now considered the first day of the week,
-- DATEPART now shows that 1999-1-1 (a Friday) is the third day of the 
-- week. The following DATEPART function should return a value of 3.
SELECT CAST(@Now AS datetime2) AS SelectDate
    ,DATEPART(dw, @Now) AS DayOfWeek;
GO

-- So, this is how you should do operations that involve the first day of the week:

declare @firstDay int =  @@DATEFIRST

SET DATEFIRST 7;

-- Now do something

SET DATEFIRST @firstDay

