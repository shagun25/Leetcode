# Write your MySQL query statement below
SELECT customer_id 
from Customer 
group by customer_id 
having COUNT(Distinct product_key) = (select COUNT(product_key) from Product);