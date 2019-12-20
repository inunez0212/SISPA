-- Drop table

-- DROP TABLE public.catalogo;

CREATE TABLE public.catalogo (
	id varchar(5) NOT NULL,
	nombrecatalogo varchar(100) NULL,
	valorcatalogo varchar(10) NULL,
	catalogorelacionado varchar(5) NULL,
	estado varchar(1) NULL,
	CONSTRAINT catalogo_pkey PRIMARY KEY (id),
	CONSTRAINT catalogo_catalogorelacionado_fkey FOREIGN KEY (catalogorelacionado) REFERENCES catalogo(id)
);

-- Drop table

-- DROP TABLE public.propietario;

CREATE TABLE public.propietario (
	id serial NOT NULL,
	cedula varchar(13) NULL,
	nombre varchar(100) NULL,
	apellido varchar(100) NULL,
	email varchar(100) NULL,
	telefono1 varchar(13) NULL,
	estado varchar(1) NULL,
	CONSTRAINT propietario_cedula_key UNIQUE (cedula),
	CONSTRAINT propietario_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.departamento;

CREATE TABLE public.departamento (
	id serial NOT NULL,
	idpropietario int4 NULL,
	bloque varchar(100) NULL,
	numero varchar(100) NULL,
	telefono varchar(13) NULL,
	estado varchar(1) NULL,
	CONSTRAINT departamento_pkey PRIMARY KEY (id),
	CONSTRAINT departamento_idpropietario_fkey FOREIGN KEY (idpropietario) REFERENCES propietario(id)
);

-- Drop table

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario (
	id serial NOT NULL,
	cedula varchar(13) NULL,
	nombre varchar(100) NULL,
	apellido varchar(100) NULL,
	cargo varchar(100) NULL,
	direccion varchar(300) NULL,
	telefono1 varchar(13) NULL,
	telefono2 varchar(13) NULL,
	tipousuario varchar(5) NULL,
	estado varchar(1) NULL,
	CONSTRAINT usuario_cedula_key UNIQUE (cedula),
	CONSTRAINT usuario_pkey PRIMARY KEY (id),
	CONSTRAINT usuario_tipousuario_fkey FOREIGN KEY (tipousuario) REFERENCES catalogo(id)
);

-- Drop table

-- DROP TABLE public.alicuota;

CREATE TABLE public.alicuota (
	id serial NOT NULL,
	iddepartamento int4 NULL,
	usuario varchar(100) NULL,
	mes varchar(15) NULL,
	anio varchar(15) NULL,
	valoralicuota decimal(10,3) NULL,
	valorpagado numeric(10,3) NULL,
	telefono1 varchar(13) NULL,
	estado varchar(1) NULL,
	fechapago timestamp,  
	CONSTRAINT alicuota_pkey PRIMARY KEY (id),
	CONSTRAINT alicuota_iddepartamento_fkey FOREIGN KEY (iddepartamento) REFERENCES departamento(id)
);


create table cliente(
id serial primary key,
cedula  varchar(13) unique,
nombre varchar (100),
apellido varchar(100),
email varchar(100),
direccion varchar (100),
telefono varchar(100),
estado varchar(1) NULL
);

CREATE TABLE factura(
	id serial primary key,
	idcliente integer references cliente(id),
	idusuario integer references usuario(id),
	fecha timestamp,
	totalSinImpuestos numeric(10,3),
	totalConImpuestos numeric(10,3),
	estado varchar(1) NULL
);

create table detalleFactura(
	id serial primary key,
	idFactura integer references factura(id),
	idArticulo integer references articulo (id),
	precioSinImpuestos numeric(10,3),
	precioConImpuestos numeric(10,3), 
	ganancia numeric(10,3),
	estado varchar(1) NULL
);
