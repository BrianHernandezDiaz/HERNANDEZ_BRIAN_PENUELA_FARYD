DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS(ID LONG AUTO_INCREMENT PRIMARY KEY, NUMERO_MATRICULA INT, NOMBRE VARCHAR(50) NOT NULL, APELLIDO VARCHAR(50) NOT NULL);

INSERT INTO ODONTOLOGOS(NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (123, "FARYD", "PENHUELA");
INSERT INTO ODONTOLOGOS(NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (321, "BRIAN", "HERNANDEZ");