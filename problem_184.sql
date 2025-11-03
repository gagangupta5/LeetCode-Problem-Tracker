# Write your MySQL query statement below
with find_max_salary(dept_id, max_salary) as
(
    select departmentId as dept_id,
        max(salary) as max_salary
        from employee
        group by departmentId
)
select  d.name as Department,
    e.name as Employee,
    e.salary as Salary
    from employee e
    inner join find_max_salary f
            on (departmentId=f.dept_id and 
            e.salary=f.max_salary)
    inner join department d
        on (departmentId=d.id);
