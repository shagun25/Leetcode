# Write your MySQL query statement below
select 
    u.user_id AS buyer_id, u.join_date, IFNULL(Count(o.order_date),0) as orders_in_2019 
from 
    Users u LEFT JOIN Orders o 
ON 
    u.user_id = o.buyer_id AND year(o.order_date)='2019' 
    GROUP BY u.user_id;

