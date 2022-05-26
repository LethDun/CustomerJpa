create table customer (customer_id integer not null auto_increment, customer_email varchar(255), customer_name varchar(255), primary key (customer_id)) engine=InnoDB;
create table customer_detail (customer_id integer not null, customer_address varchar(255), customer_age integer, primary key (customer_id)) engine=InnoDB;
create table order (order_id integer not null auto_increment, order_date varchar(255), order_name varchar(255), customer_id integer, primary key (order_id)) engine=InnoDB;
alter table order add constraint FKb8tboo4d95mh8gavvovwbb7vg foreign key (customer_id) references customer (customer_id);
