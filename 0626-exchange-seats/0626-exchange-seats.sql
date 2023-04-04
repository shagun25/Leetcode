# Write your MySQL query statement below
select 
    (CASE 
         when MOD(id,2)=1 AND counts <> id then id+1
         when MOD(id,2)=1 AND counts = id then id
         else id-1
    END) as id, student
From Seat, (
    select COUNT(*) as counts from Seat
) as seat_count
order by id;