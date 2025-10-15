# Write your MySQL query statement below
-- select email as Email from (select email,count(email) as c from Person group by email) as P where c>1;

#Approach 2

select email as Email
from Person group by email
having count(email)>1;