# Write your MySQL query statement below

# select MAX(salary) as  SecondHighestSalary from Employee where salary not in (select MAX(salary) from Employee);

# SELECT IFNULL((select DISTINCT salary from Employee ORDER BY salary DESC LIMIT 1,1),null) as SecondHighestSalary;

select IFNULL((select Distinct e1.salary from Employee e1 where 1 = (
    select COUNT(Distinct e2.salary) from Employee e2 where e2.salary>e1.salary
)),null) as SecondHighestSalary;