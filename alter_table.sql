alter table customers 
add middle_initial varchar(45);

alter table company_types
rename column company_types to company_type_name;

alter table package_types
rename column package_type to package_type_name;

alter table countries 
add state varchar(45);

alter table countries 
drop column state;

