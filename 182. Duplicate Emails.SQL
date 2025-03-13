SELECT DISTINCT email "Email"
FROM Person p 
WHERE EXISTS (SELECT email FROM Person p2 WHERE p2.email = p.email AND p2.id != p.id);


SELECT email "Email"
FROM Person
GROUP BY Email
HAVING COUNT(*) > 1;