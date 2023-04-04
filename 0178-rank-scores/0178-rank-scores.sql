# Write your MySQL query statement below
select score, DENSE_RANK() over ( ORDER BY score DESC) as 'rank' from Scores;