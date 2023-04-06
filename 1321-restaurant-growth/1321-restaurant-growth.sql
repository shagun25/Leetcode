# Write your MySQL query statement below
WITH cte as
(SELECT visited_on, SUM(amount) as total_amount 
FROM Customer 
GROUP BY visited_on),

cte1 as 
(SELECT visited_on, SUM(total_amount) OVER(ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) as amount, ROUND(AVG(total_amount) OVER(ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW),2) as average_amount FROM cte)

SELECT * FROM cte1 WHERE visited_on>=(SELECT visited_on FROM cte1 ORDER BY visited_on LIMIT 1)+6 ORDER BY visited_on;