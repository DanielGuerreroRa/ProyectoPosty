SELECT id_publicacion,descripcion
FROM publicaciones p
INNER JOIN usuarios u ON  p.id_usuario = u.id_usuario
WHERE p.id_usuario = 1;

-- remplazar id_usario con ? en un futuro

SELECT * FROM usuarios;