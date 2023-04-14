insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_USUARIO');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_ASOCIACION');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_ADMINISTRADOR');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_POSTULADO');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_SELECCIONADO');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_DIRECTOR_PROYECTO');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_PARTE_INTERESADA');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_TEAM_MEMBER');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_INGENIERIA');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_ARQUITECTURA');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_ANALISTA');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_TEAM_LEADER');
insert into rol (id, nombre) values (nextval('rol_code_seq'), 'ROLE_PATROCINADOR');

insert into estado (id, nombre) values (nextval('estado_code_seq'), 'En Espera');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'Aprobado');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'En Desarrollo');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'Finalizado');

insert into tipoconsultoria (id, nombre) values (nextval('tipoconsultoria_code_seq'), 'Ingenieria de Requisitos');
insert into tipoconsultoria (id, nombre) values (nextval('tipoconsultoria_code_seq'), 'SQA');
insert into tipoconsultoria (id, nombre) values (nextval('tipoconsultoria_code_seq'), 'SQC');

insert into persona (id, apellidos, correo, nombre) values (2, 'Marulete', 'marulete@gmail.com', 'eduardo');
insert into persona (id, apellidos, correo, nombre) values (3, 'valencia', 'juan@gmail.com', 'juan');
insert into persona (id, apellidos, correo, nombre) values (4, 'valencia', 'juandiego@gmail.com', 'juand');
insert into persona (id, apellidos, correo, nombre) values (8, 'valencia', 'juanDiego@gmail.com', 'juand');

insert into usuario (id, clave, correo) values (2, '123456789Aa', 'marulete@gmail.com');
insert into usuario (id, clave, correo) values (3, '123456789Aa1', 'juan@gmail.com');
insert into usuario (id, clave, correo) values (4, '12356789Aa1', 'juandiego@gmail.com');
insert into usuario (id, clave, correo) values (8, '12356789Aa1', 'juanDiego@gmail.com');

insert into asociacion(id,nit,nombre,numero_contacto,usuario) values (2,'12345678-2','Uco','3124536578',2);
insert into asociacion(id,nit,nombre,numero_contacto,usuario) values (3,'12345678-3','Universidad','31245365798',3);
insert into asociacion(id,nit,nombre,numero_contacto,usuario) values (4,'12345618-3','Universidad Catolica','31245365798',4);

insert into estadonecesidad (id, estado) values (9, 1);
insert into estadoproyecto (id, estado) values (9, 3);
insert into proyecto (id, descripcion, nombre, estado) values (2, 'Red Social', 'Facebook', 9);
insert into tipoconsultoriaproyecto (id, tipoconsultoria, proyecto) values (10, 1, 2);
insert into necesidad (id, asociacion, estado, proyecto) values (2, 3, 9, 2);

insert into requerimientoarchivo (id, necesidad, ruta) values (1, 2, 'http://www.direccion.org/ejemplo/item.html');

insert into estadonecesidad (id, estado) values (8, 2);
insert into estadoproyecto (id, estado) values (8, 3);
insert into proyecto (id, descripcion, nombre, estado) values (3, 'PC', 'Computador', 8);
insert into tipoconsultoriaproyecto (id, tipoconsultoria, proyecto) values (11, 1, 3);
insert into necesidad (id, asociacion, estado, proyecto) values (3, 4, 8, 3);
insert into requerimientoarchivo (id, necesidad, ruta) values (2, 3, 'http://www.direccion.org/ejemplo/item.html');

insert into hojadevida(id,ruta,usuario) values(2,'http://www.direccion.org/ejemploCV/item.html',2);

insert into postulacion(id,fecha,proyecto,rol,seleccionado,usuario)values(3,'12/07/2022',1,'ROLE_ANALISTA', false,2);
insert into postulacion(id,fecha,proyecto,rol,seleccionado,usuario)values(2,'13/07/2022',1,'ROLE_ANALISTA', true,3);
insert into seleccion(id,fecha,proyecto,rol,usuario)values (2,'14/07/2022',2,'ROLE_ANALISTA',3);


