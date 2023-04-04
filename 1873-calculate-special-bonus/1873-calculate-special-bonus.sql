# Write your MySQL query statement below
SELECT employee_id, 
CASE
      WHEN employee_id %2 <> 0 AND name NOT LIKE 'M%' then salary
      else 0
end
as bonus
FROM Employees
ORDER BY employee_id;

