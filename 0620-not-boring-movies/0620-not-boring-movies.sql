# Write your MySQL query statement below
select 
    id, movie, description, rating 
from 
    Cinema 
where 
    mod(id,2) = 1 AND description !='boring' ORDER BY rating DESC;