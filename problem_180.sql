# Write your MySQL query statement below
with neighbors as
(
    select num as curr
         , lag(num) over (order by id) as prv
         , lead(num) over (order by id) as nxt
         from logs 
)
select distinct curr as ConsecutiveNums
    from neighbors 
    where curr=prv
        and curr=nxt;