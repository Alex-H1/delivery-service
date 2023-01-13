insert into company_types(company_types)
values("retail");

insert into companies(company_name, company_type_id)
values("Walmart", 20);

insert into customers(first_name, last_name)
values("John", "Johnson");

insert into addresses(address, postal_code)
values("123 seseme street", 94354);

insert into cities(city_name)
values("Scranton");

insert into countries(country_name)
values("Unites States");

insert package_types(package_type)
values("office");

insert into packages(tracking_number, package_type_id)
values("1254334", 1);

insert into statuses(status_name)
values("Shipped");

insert into job_title(job_title)
values("Delivery Person");

insert into staff(first_name, last_name, job_title_id)
values("John", "Doe", 1);

insert into orders(customer_id, package_id, status_id, delivery_employee_id)
values(1,1,1,1);

insert into job_title(job_title)
values("cashier");

insert into staff(first_name, last_name, job_title_id)
values ("Jack", "Ham", 2);

insert into staff(first_name, last_name, job_title_id)
values("Brenda", "Boss", 2);

insert into customers(first_name, last_name)
values("Jenny", "Ocean");

insert into statuses(status_name)
values("delivered");

insert into customers(first_name, last_name)
values("Janice", "Macintosh");

insert into staff(first_name, last_name)
values("Jeff", "Stall");

insert into countries(country_name)
values("Canada");

insert into address_types(address_type)
values("Residential");

insert into companies(company_name, company_type_id)
values("Kohls", 21);

insert into company_types(company_types)
values("Electronics");

insert into companies(company_name, company_type_id)
values("Radio Shack", 23);

insert into package_types(package_type)
values("Truck");

insert into packages(package_type_id)
values(2);

insert into orders(customer_id, package_id, status_id, delivery_employee_id)
values(2, 2, 3, 1);
