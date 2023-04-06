# Write your MySQL query statement below
With cte as
(SELECT *,SUM(weight) OVER(ORDER BY turn ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) as total_weight from Queue)

select person_name
FROM cte
where total_weight<=1000
ORDER BY total_weight DESC 
LIMIT 1;
