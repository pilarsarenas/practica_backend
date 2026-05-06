-- Inserción de datos de genero
INSERT INTO `genero` (`nombre`) VALUES ('Hombre'), ('Mujer');

-- Inserción de puestos de trabajo
INSERT INTO `puesto_de_trabajo` (`nombre`) VALUES 
('Programador'),
('Analista Programador'),
('Jefe de Proyecto'),
('Director de Sistemas');

-- Inserción de usuarios
INSERT INTO `usuario` (
    `contrasena`, 
    `fecha_hora_creacion`, 
    `fecha_nacimiento`, 
    `hora_desayuno`, 
    `nick_usuario`, 
    `nombre`, 
    `primer_apellido`, 
    `segundo_apellido`, 
    `genero_id`, 
    `puesto_de_trabajo_id`
) VALUES (
    '1234', 
    '2024-06-01 10:00:00', 
    '1990-01-01', 
    '08:00:00', 
    'jdoe', 
    'John', 
    'Doe', 
    NULL, 
    1, 
    1
);

-- Inserción de direcciones
INSERT INTO `direccion` (
    `direccion_principal`, 
    `nombre_calle`, 
    `numero_calle`, 
    `usuario_id`
) VALUES 
(1, 'Calle Mayor', 1, 1),
(0, 'Calle Menor', 2, 1);