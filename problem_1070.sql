# Write your MySQL query statement below
with first_year_per_product(product_id,first_year) as
(
    select product_id,
        min(year) as first_year
    from sales
    group by product_id
)
select s.product_id,
    f.first_year,
    s.quantity,
    s.price
    from sales s
    inner join first_year_per_product f
            on f.product_id=s.product_id
where f.first_year=s.year;