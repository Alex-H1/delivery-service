select count(*) 
as number_of_companies 
from companies;

select max(companies.company_id) 
as max_number_of_companies
from companies;

select avg(company_types.company_types_id) 
as average_number_of_types
from company_types;

select sum(customers.customer_id) 
as number_of_customers
from customers;

select min(job_title.job_title_id) 
as min_number_of_job_title
from job_title;

select count(companies.company_id)
as amount_of_companies
from companies;

select max(staff.employee_id)
as max_amount_of_employees
from staff;

select count(companies.company_id)
from companies
where companies.company_id > 16; 

select count(job_title.job_title_id)
from job_title
group by job_title
having count(job_title.job_title_id) > 1;

select order_id
from orders
group by(order_id)
having sum(amount) > 5.0;