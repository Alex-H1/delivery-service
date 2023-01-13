select first_name, last_name, status_id 
from staff
left join orders
on staff.employee_id = orders.delivery_employee_id;

select orders.order_id, orders.customer_id, status_name
from orders
inner join statuses 
on statuses.status_id = orders.status_id;

select staff.first_name 
from staff
right join orders
on staff.employee_id = orders.delivery_employee_id;

select *
from companies
left join customers
on companies.company_id = customers.company_id;

select *
from orders
right join staff
on orders.delivery_employee_id = staff.employee_id;