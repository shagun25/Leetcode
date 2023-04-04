# Write your MySQL query statement below
select 
    employee_id, 
    CASE when employee_id%2 <> 0 AND name not like 'M%' then salary
         else 0
    END as bonus
FROM Employees
ORDER BY employee_id;