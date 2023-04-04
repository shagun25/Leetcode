# Write your MySQL query statement below

# select MAX(salary) as  SecondHighestSalary from Employee where salary not in (select MAX(salary) from Employee);

SELECT IFNULL((select DISTINCT salary from Employee ORDER BY salary DESC LIMIT 1,1),null) as SecondHighestSalary;