insert into rol (id, nombre) values (1, 'ROLE_USUARIO');
insert into rol (id, nombre) values (2, 'ROLE_ASOCIACION');
insert into rol (id, nombre) values (3, 'ROLE_ADMINISTRADOR');
insert into rol (id, nombre) values (4, 'ROLE_POSTULADO');
insert into rol (id, nombre) values (5, 'ROLE_SELECCIONADO');
insert into rol (id, nombre) values (6, 'ROLE_DIRECTOR_PROYECTO');
insert into rol (id, nombre) values (7, 'ROLE_PARTE_INTERESADA');
insert into rol (id, nombre) values (8, 'ROLE_TEAM_MEMBER');
insert into rol (id, nombre) values (9, 'ROLE_INGENIERIA');
insert into rol (id, nombre) values (10, 'ROLE_ARQUITECTURA');
insert into rol (id, nombre) values (11, 'ROLE_ANALISTA');
insert into rol (id, nombre) values (12, 'ROLE_TEAM_LEADER');
insert into rol (id, nombre) values (13, 'ROLE_PATROCINADOR');

insert into estado (id, nombre) values (1, 'En Espera');
insert into estado (id, nombre) values (2, 'Aprobado');
insert into estado (id, nombre) values (3, 'En Desarrollo');
insert into estado (id, nombre) values (4, 'Finalizado');

insert into tipoconsultoria (id, nombre) values (1, 'Ingenieria de Requisitos');
insert into tipoconsultoria (id, nombre) values (2, 'SQA');
insert into tipoconsultoria (id, nombre) values (3, 'SQC');

insert into persona (id, apellidos, correo, nombre) values (2, 'Marulete', 'marulete@gmail.com', 'eduardo');
insert into usuario (id, clave, correo) values (2, '123456789Aa', 'marulete@gmail.com');
insert into asociacion(id,nit,nombre,numero_contacto,usuario) values (2,'12345678-2','Uco','3124536578',2);

insert into estadonecesidad (id, estado) values (1, 1);
insert into estadoproyecto (id, estado) values (1, 1);
insert into proyecto (id, descripcion, nombre, estado) values (1, 'Red Social', 'Facebook', 1);
insert into tipoconsultoriaproyecto (id, tipoconsultoria, proyecto) values (1, 2, 1);
insert into necesidad (id, asociacion, estado, proyecto) values (1, 1, 1, 1);
insert into requerimientoarchivo (id, necesidad, ruta_archivo) values (1, 1, 'http://www.direccion.org/ejemplo/item.html');


