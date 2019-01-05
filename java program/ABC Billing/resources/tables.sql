create table product(product_code NUMBER PRIMARY KEY,product_name VARCHAR(20),product_category VARCHAR(20
  2  ),product_description VARCHAR(30),product_price NUMBER);


SQL> insert into product values(1001,'iPhone','Electroincs','Smart Phone',35000);

1 row created.

SQL> insert into product values(1002,'LEDTV','Electroincs','TV',45000);

1 row created.

SQL> insert into product values(1003,'Teddy','Toys','Soft toy',800);

1 row created.

SQL> insert into product values(1004,'Pencil','Statinory','A pack of 12 pencils',800);

1 row created.

create table sales(sales_id NUMBER,product_code NUMBER REFERENCES product(product_code),quantity NUMBER,sales_date DATE,line_total NUMBER);