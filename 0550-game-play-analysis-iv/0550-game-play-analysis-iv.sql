# Write your MySQL query statement below
With cte as
(select player_id, MIN(event_date) as first_login_date
 from Activity
 group by player_id),
 
 cte2 as
 (select *,DATE_ADD(first_login_date, Interval 1 Day) as next_date
  from cte)
  
 select 
     Round((select COUNT(Distinct player_id)
          from Activity
          where (player_id,event_date) in 
          (select player_id,next_date from cte2)
         )/(select COUNT(Distinct player_id) from Activity),2) 
    as fraction
 
 
