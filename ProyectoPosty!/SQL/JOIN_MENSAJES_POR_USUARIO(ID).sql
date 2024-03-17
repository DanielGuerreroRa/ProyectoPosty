Select m.id_mensaje,m.contenido,m.f_creacion,m.h_creacion,m.url_fotos,u.nombre_usuario,d.nombre_usuario 
from mensajes m 
inner join usuarios u
on u.id_usuario= m.usuario_origen_id
inner join usuarios d
on d.id_usuario= m.usuario_destino_id
where usuario_origen_id= 1
