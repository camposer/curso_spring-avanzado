DROP TABLE ordenador;
DROP TABLE persona;

CREATE TABLE persona(
	id INT 
		NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	fechaNacimiento DATE,
	PRIMARY KEY (id)
);

CREATE TABLE ordenador(
	id INT 
		NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	persona_id INT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	serial VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (persona_id) REFERENCES persona(id)
);

INSERT INTO persona(nombre, apellido, fechaNacimiento) 
VALUES('Juan', 'Pérez', '1980-01-01');
INSERT INTO persona(nombre, apellido, fechaNacimiento) 
VALUES('Pedro', 'González', '1986-02-02');
INSERT INTO persona(nombre, apellido, fechaNacimiento) 
VALUES('María', 'García', '1990-03-03');

INSERT INTO ordenador(persona_id, nombre, serial)
VALUES(1, 'Ordenador #1', '123');
INSERT INTO ordenador(persona_id, nombre, serial)
VALUES(1, 'Ordenador #2', '456');
INSERT INTO ordenador(persona_id, nombre, serial)
VALUES(2, 'Ordenador #3', '789');
INSERT INTO ordenador(persona_id, nombre, serial)
VALUES(3, 'Ordenador #4', '012');