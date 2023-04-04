CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      select distinct e1.salary from Employee e1 where (N-1)=(select count(distinct e2.salary) from employee e2 where e2.salary>e1.salary)
  );
END