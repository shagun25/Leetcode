# Write your MySQL query statement below
select 
    d.name as 'Department',
    e.name as 'Employee',
    e.salary as 'Salary'
FROM 
    Employee e JOIN Department d 
ON e.departmentId = d.id 
where (e.DepartmentId , e.Salary) 
IN
    (   SELECT
            DepartmentId, MAX(Salary)
        FROM
            Employee
        GROUP BY DepartmentId
    )
;
