
(SELECT 
     u.name as results 
 FROM 
     Users u, MovieRating m 
 WHERE 
     u.user_id=m.user_id 
 GROUP BY
     m.user_id 
 ORDER BY 
     COUNT(rating) desc,name asc LIMIT 1)

UNION ALL

(SELECT 
     mv.title as results 
 FROM 
     MovieRating m, Movies mv 
 WHERE 
     m.movie_id=mv.movie_id 
     AND YEAR(m.created_at)='2020' 
     AND MONTH(m.created_at)=2 
 GROUP BY 
     m.movie_id 
 ORDER BY 
     ROUND(avg(m.rating),1) desc,mv.title asc LIMIT 1);