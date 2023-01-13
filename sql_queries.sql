/*insert statements*/

INSERT INTO company_types(company_types)
VALUES("retail");

INSERT INTO companies(company_name, company_type_id)
values("Walmart", 20);

INSERT INTO customers(first_name, last_name)
VALUES("John", "Johnson");

INSERT INTO addresses(address, postal_code)
VALUES("123 seseme street", 94354);

INSERT INTO cities(city_name)
VALUES("Scranton");

INSERT INTO countries(country_name)
VALUES("Unites States");

INSERT INTO package_types(package_type)
VALUES("office");

INSERT INTO packages(tracking_number, package_type_id)
VALUES("1254334", 1);

INSERT INTO statuses(status_name)
VALUES("Shipped");

INSERT INTO job_title(job_title)
VALUES("Delivery Person");

/*update statements*/

UPDATE customers
SET address_id=2, company_id= 16
WHERE costumer_id=1;

UPDATE cities
SET country_id=1
WHERE city_id=1;

UPDATE orders
SET amount=20.94
WHERE order_id=1;

UPDATE customers
SET phone_number="(231)546-6543"
WHERE costumer_id=1;

UPDATE staff
SET job_title_id=3
WHERE employee_id= 3;

UPDATE customers
SET first_name="Jenn"
WHERE customer_id=2;

UPDATE orders
SET status_id=2
WHERE order_id=1;

UPDATE customers
SET phone_number="(435)678-4375"
WHERE customer_id=2;

UPDATE orders
SET status_id=3
WHERE order_id=1;

UPDATE staff
SET last_name="Jill"
WHERE employee_id=3;

/* delete statements */

DELETE FROM company_types 
WHERE company_types="retail" 
AND company_types_id=18 ;

DELETE FROM customers
WHERE customer_id= 3;

DELETE FROM staff
WHERE employee_id= 8;

DELETE FROM statuses
WHERE status_id=2;

DELETE FROM countries
WHERE country_name="Canada";

DELETE FROM address_types
WHERE address_type="Residential";

DELETE FROM companies
WHERE company_name="Radio Shack";

DELETE FROM companies
WHERE company_name="Kmart";

DELETE FROM orders
WHERE order_id=2
AND delivery_employee_id=1;

DELETE FROM staff
WHERE employee_id=3
AND first_name="Brenda";

/* joins */

SELECT first_name, last_name, status_id 
FROM staff
LEFT JOIN orders
ON staff.employee_id = orders.delivery_employee_id;

SELECT orders.order_id, orders.customer_id, status_name
FROM orders
INNER JOIN statuses 
on statuses.status_id = orders.status_id;

SELECT first_name, order_id 
FROM staff
RIGHT JOIN orders
ON staff.employee_id = orders.delivery_employee_id;

SELECT *
FROM companies
LEFT JOIN customers
ON companies.company_id = customers.company_id;

SELECT *
FROM orders
RIGHT JOIN staff
ON orders.delivery_employee_id = staff.employee_id;

/* aggregate functions*/

SELECT COUNT(*) 
AS number_of_companies 
FROM companies;

SELECT MAX(company_id) 
AS max_number_of_companies
FROM companies;

SELECT AVG(company_types_id) 
AS average_number_of_types
FROM company_types;

SELECT sum(customer_id) 
AS number_of_customers
FROM customers;

SELECT MIN(job_title_id) 
AS min_number_of_job_title
FROM job_title;

SELECT COUNT(company_id)
AS amount_of_companies
FROM companies;

SELECT MAX(employee_id)
AS max_amount_of_employees
FROM staff;

SELECT COUNT(companies.company_id)
AS company_count
FROM companies;

/* aggregate functions with having */


SELECT order_id
FROM orders
GROUP BY(order_id)
HAVING sum(amount) > 5.0;

SELECT job_title_id
FROM job_title
GROUP BY job_title
HAVING SUM(job_title_id) > 1;

SELECT weight
FROM packages
GROUP BY(weight)
HAVING sum(weight) > 15;

SELECT weight
FROM packages
GROUP BY(weight)
HAVING sum(weight) > 15;

SELECT company_types_id
FROM company_types
GROUP BY(company_types_id)
HAVING sum(company_types_id) > 22;

SELECT employee_id
FROM staff
GROUP BY(employee_id)
HAVING max(employee_id) > 1;

SELECT status_id
FROM statuses
GROUP BY(status_id)
HAVING max(status_id) > 1;

