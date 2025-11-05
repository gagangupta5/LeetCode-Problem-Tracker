with ids_to_be_retained(id) as
(
    select min(id) as id
        from person
    group by email
)
delete from person
where id not in (select id from ids_to_be_retained);