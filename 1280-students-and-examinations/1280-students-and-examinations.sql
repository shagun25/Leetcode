# Write your MySQL query statement below
With cte as
(SELECT stu.student_id, stu.student_name, sub.subject_name 
FROM Students stu CROSS JOIN Subjects sub),

cte1 as
(SELECT student_id, subject_name, COUNT(subject_name) as count
 From Examinations 
 GROUP BY student_id, subject_name
)

SELECT cte.student_id, cte.student_name, cte.subject_name, CASE WHEN count is null then 0 
ELSE count
END as attended_exams
FROM cte LEFT JOIN cte1
ON cte.student_id=cte1.student_id AND cte.subject_name= cte1.subject_name
ORDER BY student_id, subject_name;