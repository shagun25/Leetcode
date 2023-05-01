# Write your MySQL query statement below
SELECT ROUND(100*AVG(CASE WHEN order_date=customer_pref_delivery_date THEN 1.00 ELSE 0.00 END),2) as immediate_percentage FROM Delivery where (customer_id,order_date) IN 
(SELECT customer_id,MIN(order_date) FROM Delivery GROUP BY customer_id);

