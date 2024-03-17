-- INSERT USUARIOS
INSERT INTO usuarios (id_usuario,nombre, apellido ,nombre_usuario, contrasena,correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (1, 'jhon','Cena', 'jhon_cenaa' ,'contrasena1', 'usuario1@example.com', 'Pregunta1', CURRENT_DATE, CURRENT_TIME);

INSERT INTO usuarios (id_usuario, nombre_usuario,nombre, apellido, contrasena,correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (2, 'pablito123','pablito','clavo un clavito', 'contrasena2','usuario2@example.com', 'Pregunta2', CURRENT_DATE, CURRENT_TIME);

INSERT INTO usuarios (id_usuario, nombre_usuario, nombre, apellido, contrasena, correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (3, 'Elric', 'Elrica','tula', 'contrasena3', 'usuario3@example.com', 'Pregunta3', CURRENT_DATE, CURRENT_TIME);

INSERT INTO usuarios (id_usuario, nombre_usuario, nombre, apellido ,contrasena,correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (4, 'MA_BOY','ALL CAPS','MA BOYS', 'contrasena4',  'usuario4@example.com', 'Pregunta4', CURRENT_DATE, CURRENT_TIME);

INSERT INTO usuarios (id_usuario, nombre_usuario,nombre, apellido ,contrasena, correo, pregunta_secreta, f_creacion, h_creacion)
VALUES (5, 'ROSA','ROSA','MELANO' ,'contrasena5', 'usuario5@example.com', 'Pregunta5', CURRENT_DATE, CURRENT_TIME);
-- INSERT PERFILES
INSERT INTO perfil (id_perfil,descripcion,nombre,apellido,foto_perfil,num_publicaciones,num_seguidores,num_siguiendo,id_usuario)
VALUES(1,'','jhon','Cena','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,1),
(2,'','pablito','clavo un clavito','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,2),
(3,'','Elrica','tula','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,3),
(4,'','ALL CAPS','MA BOYS','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,4),
(5,'','ROSA','MELANO','https://t4.ftcdn.net/jpg/03/49/49/79/360_F_349497933_Ly4im8BDmHLaLzgyKg2f2yZOvJjBtlw5.webp',0,0,0,5);

-- INSERT MENSAJES
INSERT INTO mensajes (id_mensaje,contenido,f_creacion,h_creacion,url_fotos,usuario_destino_id,usuario_origen_id)
VALUES(1,'Bienvenido a Posty!',CURRENT_DATE,CURRENT_TIME,'',1,2),
(2,'Esta es una red social creada con Angular',CURRENT_DATE,CURRENT_TIME,'',2,1),
(3,'El backend fue hecho con Spring boot!',CURRENT_DATE,CURRENT_TIME,'',2,3);

-- INSERT FOLLOWERS
INSERT INTO seguidores (id_usuario_seguido,id_usuario_seguidor)
VALUES (1,2),(1,3),(1,4),(1,5),(2,1);
