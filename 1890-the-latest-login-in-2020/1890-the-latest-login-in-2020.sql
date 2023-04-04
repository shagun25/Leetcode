# Write your MySQL query statement below
select user_id, MAX(time_stamp) as last_stamp From logins where year(time_stamp)='2020' group by user_id;