
use cliente;
drop table if exists Cliente;
create table Cliente (
Id int NOT NULL AUTO_INCREMENT,
Nombre varchar(250) DEFAUlT NULL,
Apellido varchar(250) DEFAUlT NULL,
Direccion varchar(250) DEFAUlT NULL,
DNI int DEFAULT NULL,
Fecha date DEFAULT NULL,
PRIMARY KEY (id)
);

insert into Cliente(Nombre, Apellido, Direccion, DNI, Fecha) values("Juan", "Lopez", "Calle Calle 23", 11111111, "2020-07-20");
insert into Cliente(Nombre, Apellido, Direccion, DNI, Fecha) values("Marta", "Perez", "Calle Pita 22", 22222222, "2020-11-20");
insert into Cliente(Nombre, Apellido, Direccion, DNI, Fecha) values("Juan", "Lopez", "Calle Calle 23", 33333333, "2020-09-15");

