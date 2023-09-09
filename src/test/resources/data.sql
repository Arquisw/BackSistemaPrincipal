insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_USUARIO');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_ASOCIACION');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_ADMINISTRADOR');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_POSTULADO');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_SELECCIONADO');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_DIRECTOR_PROYECTO');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), false, false, false, true, 'ROLE_PARTE_INTERESADA');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_EQUIPO_DESARROLLO');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_INGENIERIA');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_ARQUITECTURA');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), false, false, false, true, 'ROLE_ANALISTA');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), true, true, true, true, 'ROLE_LIDER_DE_EQUIPO');
insert into rol (id, actualizar, eliminar, escribir, leer, nombre) values (nextval('rol_code_seq'), false, false, false, true, 'ROLE_PATROCINADOR');

insert into rol_proyecto (id, nombre) values (nextval('rol_proyecto_code_seq'), 'ROLE_DIRECTOR_PROYECTO');
insert into rol_proyecto (id, nombre) values (nextval('rol_proyecto_code_seq'), 'ROLE_PARTE_INTERESADA');
insert into rol_proyecto (id, nombre) values (nextval('rol_proyecto_code_seq'), 'ROLE_EQUIPO_DESARROLLO');
insert into rol_proyecto (id, nombre) values (nextval('rol_proyecto_code_seq'), 'ROLE_INGENIERIA');
insert into rol_proyecto (id, nombre) values (nextval('rol_proyecto_code_seq'), 'ROLE_ARQUITECTURA');
insert into rol_proyecto (id, nombre) values (nextval('rol_proyecto_code_seq'), 'ROLE_ANALISTA');
insert into rol_proyecto (id, nombre) values (nextval('rol_proyecto_code_seq'), 'ROLE_LIDER_DE_EQUIPO');
insert into rol_proyecto (id, nombre) values (nextval('rol_proyecto_code_seq'), 'ROLE_PATROCINADOR');

insert into estado (id, nombre) values (nextval('estado_code_seq'), 'En Espera');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'Aprobado');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'Negociado');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'Rechazado');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'En Proceso');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'En Desarrollo');
insert into estado (id, nombre) values (nextval('estado_code_seq'), 'Finalizado');

insert into tipo_consultoria (id, nombre) values (nextval('tipo_consultoria_code_seq'), 'Ingenieria de Requisitos');
insert into tipo_consultoria (id, nombre) values (nextval('tipo_consultoria_code_seq'), 'SQA');
insert into tipo_consultoria (id, nombre) values (nextval('tipo_consultoria_code_seq'), 'SQC');