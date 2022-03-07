-- Script prova Banco de Dados 
CREATE DATABASE dbRestaurante; 
USE dbRestaurante;

CREATE TABLE tbRestaurante(
	idRest INT PRIMARY KEY  AUTO_INCREMENT, 
	nomeRest VARCHAR(50),
	bairroRest VARCHAR(35), 
	tipoRest VARCHAR(30)
	);
INSERT INTO tbRestaurante VALUES
		 (null, "Joaquin Churras","Guaianazes",
		 "Churrascaria"),

		(null, "Gustavo Churras", "Itaquera", 
		"Churrascaria"), 

		(null, "MeiTemaki", "Jardim São Paulo",
		"Comida Japonesa"), 
		
		(null, "Casa da Esfiha", "Guaianazes",
		"Comida Arabe"), 

		(null, "Carosella", "Paulista", "Italiana");
				
ALTER TABLE tbRestaurante MODIFY nomeRest VARCHAR(60);

SELECT * FROM tbRestaurante; 
SELECT nomeRest, tipoRest FROM tbRestaurante; 
SELECT * FROM tbRestaurante WHERE bairroRest = 
"Guaianazes"; 
SELECT * FROM tbRestaurante WHERE tipoRest = 
"Churrascaria";
 SELECT * FROM tbRestaurante ORDER BY nomeRest 
;
 SELECT * FROM tbRestaurante ORDER BY nomeRest DESC ;
 SELECT * FROM tbRestaurante WHERE nomeRest LIKE "c%";
 SELECT * FROM tbRestaurante WHERE bairroRest LIKE "%s";
 SELECT * FROM tbRestaurante WHERE tipoRest LIKE "_h%" ; 
SELECT * FROM tbRestaurante WHERE nomeRest LIKE "%l_";
 UPDATE tbRestaurante SET bairroRest = "Consolação" WHERE 
idRest = 5; 
DELETE FROM tbRestaurante WHERE idRest = 5; 


-- QUESTAO 5 

ALTER TABLE tbRestaurante ADD donoRest VARCHAR(40);  

UPDATE tbRestaurante SET donoRest = "Paola Carosella" WHERE 
idRest IN (1,4) ;

UPDATE tbRestaurante SET donoRest = "Gustavo Souza" WHERE 
idRest =2 ;

UPDATE tbRestaurante SET donoRest = "Thiago Taneguchi" WHERE
idRest =3 ; 

DROP DATABASE dbRestaurante;
