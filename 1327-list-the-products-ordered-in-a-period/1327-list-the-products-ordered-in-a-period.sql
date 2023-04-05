# Write your MySQL query statement below
select p.product_name, sum(o.unit) as unit
from Products p inner join (select *
from Orders
where Year(order_date)=2020 and
Month(order_date) = 2
) as o
on p.product_id = o.product_id
group by p.product_id
having sum(o.unit) >=100
