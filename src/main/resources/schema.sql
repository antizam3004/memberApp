create table member (
id int auto_increment,
first_name varchar(30) not null,
last_name varchar(30) not null,
address varchar(255) not null,
city varchar (80) not null,
telephone varchar (20) not null,
birth_Date date not null,
primary key(id)
);

create table membership(
id int auto_increment,
amount bigint not null,
description varchar (255),
date_Paid date not null,
is_Paid boolean not null,
member_id int not null,
primary key (id),
foreign key(member_id) references member(id)
);

