CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below
        with find_rank(salary, r) as
        (
            select salary,
            dense_rank() over(order by salary desc) as r
            from Employee
        )
        select ifnull((select distinct salary 
            from find_rank
            where r=N ),null) as "getNthHighestSalary(@N)"
        from dual

  );
END