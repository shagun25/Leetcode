# Write your MySQL query statement below
select name from SalesPerson where sales_id not in (
    select sales_id 
    from 
        ORDERS JOIN Company 
    ON (Orders.com_id=Company.com_id AND Company.name='RED')
);