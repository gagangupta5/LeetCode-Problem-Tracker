# Write your MySQL query statement below
select name as Customers 
    from Customers left join Orders
    on Customers.id=customerId
    where customerid is null;