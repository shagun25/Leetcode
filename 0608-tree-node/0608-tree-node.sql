# Write your MySQL query statement below
SELECT 
    id, 'Root' as Type 
FROM 
    tree 
where 
    p_id is null
UNION

SELECT 
    id, 'Inner' as Type 
FROM 
    tree 
where 
    id in(
        SELECT 
            p_id
        FROM 
            tree 
        where 
            p_id is not null
    ) AND p_id is not null
    
UNION

SELECT 
    id, 'Leaf' as Type 
FROM 
    tree 
where 
    id not in(
        SELECT 
            p_id
        FROM 
            tree 
        where 
            p_id is not null
    ) AND p_id is not null
    

;
    



