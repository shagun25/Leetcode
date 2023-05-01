# Write your MySQL query statement below

select id, count(*) as num from(
select requester_id id from RequestAccepted
union all 
    select accepter_id id from RequestAccepted) t
group by id
order by num desc limit 1 