# Write your MySQL query statement below
select 
    d.name as 'Department',
    e.name as 'Employee',
    e.salary as 'Salary'
FROM 
    Employee e JOIN Department d 
ON e.departmentId = d.id 
where e.Salary IN(
    select * FROM (  
        SELECT
            DISTINCT Salary
        FROM
            Employee
        where departmentId = d.id 
        ORDER BY Salary DESC LIMIT 1
    ) as T
);


