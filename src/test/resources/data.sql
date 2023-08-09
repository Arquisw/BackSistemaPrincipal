insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_USUARIO',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_ASOCIACION',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_ADMINISTRADOR',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_POSTULADO',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_SELECCIONADO',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_DIRECTOR_PROYECTO',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_PARTE_INTERESADA',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_TEAM_MEMBER',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_INGENIERIA',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_ARQUITECTURA',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_ANALISTA',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_TEAM_LEADER',true,true,true,true);
insert into rol (id, nombre,leer,escribir,actualizar,eliminar) values (nextval('rol_code_seq'), 'ROLE_PATROCINADOR',true,true,true,true);

insert into estado (id, nombre) values (nextval('estado_code_seq'), 'En Espera');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'Aprobado');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'En Desarrollo');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'Finalizado');

insert into tipo_consultoria (id, nombre) values (nextval('tipo_consultoria_code_seq'), 'Ingenieria de Requisitos');
insert into tipo_consultoria (id, nombre) values (nextval('tipo_consultoria_code_seq'), 'SQA');
insert into tipo_consultoria (id, nombre) values (nextval('tipo_consultoria_code_seq'), 'SQC');

insert into persona (id, apellidos, correo, nombre) values (2, 'Marulete', 'marulete@gmail.com', 'eduardo');
insert into persona (id, apellidos, correo, nombre) values (30, 'valencia', 'juan@gmail.com', 'juan');
insert into persona (id, apellidos, correo, nombre) values (3, 'valencia', 'juan1@gmail.com', 'juan');
insert into persona (id, apellidos, correo, nombre) values (4, 'valencia', 'juandiego@gmail.com', 'juand');
insert into persona (id, apellidos, correo, nombre) values (8, 'valencia', 'juanDiego@gmail.com', 'juand');

insert into usuario (id, clave, correo) values (2, '123456789Aa', 'marulete@gmail.com');
insert into usuario (id, clave, correo) values (30, '123456789Aa1', 'juan@gmail.com');
insert into usuario (id, clave, correo) values (4, '12356789Aa1', 'juandiego@gmail.com');
insert into usuario (id, clave, correo) values (8, '12356789Aa1', 'juanDiego@gmail.com');

INSERT INTO public.rol_usuario (id, rol) VALUES(10, 1);
INSERT INTO public.rol_usuario (id, rol) VALUES(11, 2);
INSERT INTO public.rol_usuario (id, rol) VALUES(12, 3);
INSERT INTO public.rol_usuario (id, rol) VALUES(13, 4);


insert into asociacion(id,nit,nombre,numero_contacto,usuario) values (2,'12345678-2','Uco','3124536578',2);
insert into asociacion(id,nit,nombre,numero_contacto,usuario) values (3,'12345678-3','Universidad','31245365798',3);
insert into asociacion(id,nit,nombre,numero_contacto,usuario) values (4,'12345618-3','Universidad Catolica','31245365798',4);

insert into estado_necesidad (id, estado) values (9, 1);
insert into estado_proyecto (id, estado) values (9, 3);
insert into proyecto (id, descripcion, nombre, estado) values (2, 'Red Social', 'Facebook', 9);
insert into tipo_consultoria_proyecto (id, tipo_consultoria, proyecto) values (10, 1, 2);
insert into necesidad (id, asociacion, estado, proyecto) values (2, 3, 9, 2);

insert into requerimiento_archivo (id, necesidad, ruta) values (1, 2, 'http://www.direccion.org/ejemplo/item.html');

insert into estado_necesidad (id, estado) values (8, 2);
insert into estado_proyecto (id, estado) values (8, 3);
insert into proyecto (id, descripcion, nombre, estado) values (3, 'PC', 'Computador', 8);
insert into tipo_consultoria_proyecto (id, tipo_consultoria, proyecto) values (11, 1, 3);
insert into necesidad (id, asociacion, estado, proyecto) values (3, 4, 8, 3);
insert into requerimiento_archivo (id, necesidad, ruta) values (2, 3, 'http://www.direccion.org/ejemplo/item.html');

insert into hoja_de_vida(id,ruta,usuario) values(2,'http://www.direccion.org/ejemploCV/item.html',2);

insert into postulacion(id,fecha,proyecto,seleccionado,usuario)values(3,'12/07/2022',1,true, 2);
insert into postulacion(id,fecha,proyecto,seleccionado,usuario)values(2,'12/07/2022',1,true, 1);
insert into seleccion(id,fecha,proyecto,usuario)values (2,'14/07/2022',2,3);

insert into contrato(id,ruta,necesidad)values (2,'http://www.direccion.org/ejemploCV/item.html',3);


