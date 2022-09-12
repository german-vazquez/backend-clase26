drop table if exists domicilios;
drop table if exists pacientes;
drop table if exists odontologos;

create table domicilios (id int auto_increment primary key, calle varchar(100) not null, numero int not null, localidad varchar(100) not null, provincia varchar(100) not null);
create table pacientes (id int auto_increment primary key, apellido varchar (100) not null, nombre varchar(100) not null, email varchar(100) not null, dni int not null, fecha date not null, domicilio_id int not null);
create table odontologos (id int auto_increment primary key, apellido varchar (100) not null, nombre varchar(100) not null, matricula varchar(50) not null);

insert into domicilios (calle, numero, localidad, provincia) values ('av.siempreviva',3342,'springfield', 'oregon');

insert into odontologos (apellido, nombre, matricula) values ('fulanito', 'cosme', 2280);

insert into pacientes(apellido, nombre, email, dni, fecha, domicilio_id) values ('simpson', 'homero', 'mrx@gmail.com', 11080000, '2022-08-25', 1);