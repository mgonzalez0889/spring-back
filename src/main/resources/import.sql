/* Creamos algunos usuarios con sus roles */
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES('mijail', '$2a$10$DzI8Pjs1y6UaJEuVMkwGz.0XZOtpo9solhZuB57ujgZObDCpq908a', 1, 'Mijail', 'Gonzalez', 'develop@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES('admin', '$2a$10$jdTdqSZ66HPIBdVVpbrf0uIswR94Wv7S217nOcn6aTQP9iOQ81wTC', 1, 'Rulfo', 'Hal', 'rhal@gmail.com');

INSERT INTO roles (nombre) VALUES('ROLE_USER');
INSERT INTO roles (nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES(1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES(2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES(2, 1);

/* Populate tabla regiones */
INSERT INTO regiones (id, nombre) VALUES(1, 'Sudamerica');
INSERT INTO regiones (id, nombre) VALUES(2, 'Centroamerica');
INSERT INTO regiones (id, nombre) VALUES(3, 'Norteamerica');
INSERT INTO regiones (id, nombre) VALUES(4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES(5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES(6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES(7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES(8, 'Antartida');


/* Populate tabla clientes */
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1, 'Andr�s', 'Guzm�n', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(2, 'Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(5, 'Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(8, 'Jade', 'Doe', 'jane.doe@gmail.com', '2018-10-10');

/*Populate tabla Productos*/
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple Ipad Mini', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/*Algunas facturas*/
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

