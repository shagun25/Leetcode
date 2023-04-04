# Write your MySQL query statement below
select event_day as day, emp_id, Sum(out_time-in_time) as total_time from Employees GROUP BY emp_id,event_day ;