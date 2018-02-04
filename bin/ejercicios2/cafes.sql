drop database if exists mercado;

create database mercado;

use mercado; 

create table if not exists CAFES (
	 CAF_NOMBRE varchar(50) not null, 
	 PROV_ID integer not null,
	 PRECIO real not null,
	 VENTAS integer not null,
	 TOTAL integer not null,
	 constraint isbn_pk primary key (CAF_NOMBRE))
	 
insert into CAFES values ('Colombian',35,3.99,100,200);
