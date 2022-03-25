CREATE DATABASE dbCarroDono;
USE dbCarroDono;

-- CRIACAO TABELA

CREATE TABLE tbCliente(
	idCliente INT PRIMARY KEY AUTO_INCREMENT,
	nomeCliente VARCHAR(45) NOT NULL, 
	dataNastoCliente DATE NOT NULL, 
	salarioCliente INT 
); 

CREATE TABLE tbCarro(
	idCarro INT PRIMARY KEY AUTO_INCREMENT,
	modeloCarro VARCHAR(45) NOT NULL,
	marcaCarro VARCHAR(45) NOT NULL,
	placaCarro CHAR(7) NOT NULL,
	dataCarro DATE NOT NULL,
	idCliente INT,
	FOREIGN KEY (idCliente) REFERENCES tbCliente(idCliente)
);

-- INSERTS

INSERT INTO tbCliente VALUES(null,'José Pereira', '2001-01-01' ,1999.13), -- coleciona fiat
			(null,'João Souza', '1997-12-10', 12000.13), 
			(null,'William Minerva', '1968-11-12', 600); 

INSERT INTO tbCarro VALUES(null, 'Uno','Fiat','BJHR921', '2004-12-11',1),
			(null, 'Fiesta','Fiat','NJOP091', '2009-6-10',1),
			(null, 'Palio','Fiat','MKQI840', '2012-6-9',1),
			(null, 'Civic','Honda','FWIQ192', '2020-5-22',2),
			(null, 'Cruze Sport','Chevrolet','PNHI987', '2022-10-22',2),
			(null, 'Partner','Peugeout','PMHI878', '2008-4-11',3);

-- SELECTS

SELECT * FROM tbCarro; 
SELECT * FROM tbCliente;
SELECT * FROM tbCliente ORDER BY dataNastoCliente;
SELECT * FROM tbCarro ORDER BY dataCarro DESC;
SELECT * FROM tbCarro WHERE placaCarro LIKE '_%7';
SELECT * FROM tbCarro WHERE marcaCarro LIKE 'Fiat';
desc tbCliente;
ALTER TABLE tbCarro MODIFY modeloCarro VARCHAR(50) NOT NULL;
UPDATE tbCliente SET salarioCliente=30000.99 WHERE IdCliente=3;
SELECT * FROM tbCarro,tbCliente WHERE tbCliente.idCliente=tbCarro.idCliente;
SELECT * FROM tbCarro,tbCliente WHERE tbCliente.nomeCliente LIKE 'João Souza' AND tbCliente.idCliente=tbCarro.idCliente;
SELECT * FROM tbCarro,tbCliente WHERE tbCarro.placaCarro LIKE 'P_%' AND tbCliente.idCliente=tbCarro.idCliente;
DROP TABLE TbCliente;
DROP TABLE tbCarro;
DROP DATABASE dbCarroDono;
