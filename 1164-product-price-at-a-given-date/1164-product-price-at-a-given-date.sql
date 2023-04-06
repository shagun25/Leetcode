# Write your MySQL query statement below

# 1. Group the table with the product_id field and find the first changed date over 2019-08-16 by using MIN aggregation function on HAVING clause.

# 2. Set the price table as 10.
SELECT
  product_id,
  10 AS price
FROM
  Products
 group by product_id
 HAVING
  MIN(change_date) > '2019-08-16'
  
  
UNION ALL


SELECT
  product_id,
  new_price AS price
FROM
  Products
WHERE
  (product_id, change_date) IN
(select 
    product_id,
    MAX(change_date) 
from Products 
where change_date<='2019-08-16' 
group by product_id)

#3. Group the table with the product_id again, and find the product_id field and the last changed date until 2019-08-16.
#4. Find the last changed new_price field with the last changed date.

# 5. Union the two tables by using UNION ALL.


