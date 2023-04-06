# Write your MySQL query statement below


#Common table expressions (CTEs)

#1. Identify the first login date for each player.
#2. Identify the number of players who logged in the day after their first login date.
#3. Divide the number of players identified in step 2 by the number of players identified in step 1 and round the result to two decimal places.

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
 
 
