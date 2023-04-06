# Write your MySQL query statement below
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

