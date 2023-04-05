# Write your MySQL query statement below
select 
    x,
    y,
    z,
    CASE 
         When x+y>z AND x+z>y AND y+z>x Then "Yes"
         Else "No"
    End as 'triangle'
from triangle;
    