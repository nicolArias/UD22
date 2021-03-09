create database cliente;
use cliente;
drop table if exists Cliente;
create table Cliente (
id int(11) NOT NULL AUTO_INCREMENT,
nombre varchar(250) DEFAUlT NULL,
apellido varchar(250) DEFAUlT NULL,
direccion varchar(250) DEFAUlT NULL,
DNI int DEFAULT NULL,
fecha date DEFAULT NULL,
PRIMARY KEY (id)
);

create table Videos (
id int(11) not null auto_increment,
title varchar(250) default null,
director  varchar(250) default null,
cli_id int(11) default null,
primary key (id),
constraint videos_fk foreign key (cli_id) references Cliente (id)
);

insert into Cliente(nombre, apellido, direccion, DNI, fecha) values("Juan", "Lopez", "Calle Calle 23", 11111111, "2020-07-20");
insert into Cliente(nombre, apellido, direccion, DNI, fecha) values("Marta", "Perez", "Calle Pita 22", 22222222, "2020-11-20");
insert into Cliente(nombre, apellido, direccion, DNI, fecha) values("Juan", "Lopez", "Calle Calle 23", 33333333, "2020-09-15");

insert into Videos(title, director, cli_id) values("La vida de Brian", "Monty Python", 1);
insert into Videos(title, director, cli_id) values("Lopez y Vega", "Ryan Reynolds", 1);
insert into Videos(title, director, cli_id) values("Que bello es sobrevivir", "Hilary Clinton", 1);