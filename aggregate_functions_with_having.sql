select order_id
from orders
group by(order_id)
having sum(amount) > 5.0;

select job_title_id
from job_title
group by job_title
having count(job_title.job_title_id) > 1;

select weight
from packages
group by(weight)
having sum(weight) > 15;

select weight
from packages
group by(weight)
having sum(weight) > 15;

select company_types_id
from company_types
group by (company_types_id)
having sum(company_types_id) > 22;
select employee_id

from staff
group by (employee_id)
having max(employee_id) > 1;

select status_id
from statuses
group by (status_id)
having max(status_id) > 1;