# Write your MySQL query statement below
UPDATE Salary
set 
    sex = CASE sex
        WHEN 'm' then 'f'
        else 'm'
    END;
