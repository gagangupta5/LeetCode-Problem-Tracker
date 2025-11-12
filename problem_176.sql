with find_rank(salary, r) as
(
    select salary,
    dense_rank() over(order by salary desc) as r
    from Employee
)
select ifnull((select salary 
    from find_rank
    where r=2 
    limit 1 offset 0),null) as SecondHighestSalary
from dual;