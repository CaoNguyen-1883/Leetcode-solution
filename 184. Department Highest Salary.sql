SELECT d.name Department, e.name Employee, e.salary
FROM Employee e JOIN Department d ON e.departmentId = d.id
WHERE e.salary = (SELECT MAX(salary) FROM Employee WHERE departmentId = e.departmentId);