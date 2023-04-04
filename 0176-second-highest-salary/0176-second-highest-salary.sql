# Write your MySQL query statement below
select MAX(salary) as  SecondHighestSalary from Employee where salary not in (select MAX(salary) from Employee);