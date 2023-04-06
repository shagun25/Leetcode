# Write your MySQL query statement below
select name from Employee e JOIN
(select managerId 
 from Employee 
 group by managerId having COUNT(managerId)>=5) as T ON e.id=T.managerId;