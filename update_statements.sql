update customers
set address_id=2, company_id= 16
where costumer_id=1;

update cities
set country_id=1
where city_id=1;

update orders
set amount=20.94
where order_id=1;

update customers
set phone_number="(231)546-6543"
where costumer_id=1;

update staff
set job_title_id=3
where employee_id= 3;

update customers
set first_name="Jenn"
where customer_id=2;

update orders
set status_id=2
where order_id=1;

update customers
set phone_number="(435)678-4375"
where customer_id=2;

update orders
set status_id=3
where order_id=1;

update staff
set last_name="Jill"
where employee_id=3;
