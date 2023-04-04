# Write your MySQL query statement below
select lastName, firstName, city, state from Person p LEFT JOIN Address a ON p.personId=a.personId;