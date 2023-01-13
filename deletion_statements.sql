delete from company_types 
where company_types="retail" 
and company_types_id=18 ;

delete from customers
where customer_id= 3;

delete from staff
where employee_id= 8;

delete from statuses
where status_id=2;

delete from countries
where country_name="Canada";

delete from address_types
where address_type="Residential";

delete from companies
where company_name="Radio Shack";

delete from companies
where company_name="Kmart";

delete from orders
where order_id=2
and delivery_employee_id=1;

delete from staff
where employee_id=3
and first_name="Brenda";