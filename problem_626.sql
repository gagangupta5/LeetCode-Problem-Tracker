select id
     , if(id%2=0
         , lag(student,1,student) over (order by id)
         , lead(student,1,student) over (order by id)
        ) as student
from seat
order by id;