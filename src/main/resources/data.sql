--DROP table IF EXISTS empleados;

create table empleados(
	id int auto_increment,
	nombre varchar(255),
	apellido varchar(255),
	trabajo varchar(100),
	salario int);

insert into empleados (nombre, apellido, trabajo,salario)values('Jose', 'Cnstan','programmer', 40000);
insert into empleados (nombre, apellido,trabajo,salario)values('Juan', 'Constn','graphic designer', 50000);
insert into empleados (nombre, apellido,trabajo,salario)values('Pedro', 'Consan','programmer', 40000);
insert into empleados (nombre, apellido,trabajo,salario)values('Pedro', 'Cnstan','tester', 41500);
insert into empleados (nombre, apellido,trabajo,salario)values('Jonatan', 'Cont','UX Designer', 39999);