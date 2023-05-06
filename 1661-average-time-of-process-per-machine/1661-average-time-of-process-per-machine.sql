# Write your MySQL query statement below
select machine_id, ROUND(AVG(case 
                             WHEN activity_type = 'end' THEN timestamp
                             WHEN activity_type = 'start' THEN -timestamp
                             End)*2,3) as processing_time 
                             
 from Activity group by machine_id;