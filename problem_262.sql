-- Approach 1
with unbanned_users(id, request_at, status) as
(
    select id,
        request_at,
        status
        from trips t
        inner join Users c
                on (t.client_id=c.users_id and c.role='client' and c.banned='No')
        inner join Users d
                on (t.driver_id=d.users_id and d.role='driver' and d.banned='No')
)
select request_at as Day,
    round(sum(if(status='completed',0,1))/count(*),2) as 'Cancellation Rate'
    from unbanned_users
    where request_at between "2013-10-01" and "2013-10-03"
group by request_at;


-- Approach 2
select
    t.request_at AS Day,
    ROUND(SUM(IF(t.status <> 'completed', 1, 0)) / COUNT(*), 2) AS 'Cancellation Rate'
from Trips t
where 
    t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
    AND t.client_id not in (
        SELECT users_id FROM Users WHERE banned = 'Yes'
    )
    and t.driver_id NOT IN (
        select users_id FROM Users WHERE banned = 'Yes'
    )
GROUP BY t.request_at;