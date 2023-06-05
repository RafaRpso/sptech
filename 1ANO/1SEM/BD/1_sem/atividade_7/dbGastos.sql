CREATE DATABASE dbGastos;
USE dbGastos;


CREATE TABLE tbUsuario(
        idUsuario INT PRIMARY KEY AUTO_INCREMENT,
        nomeUsuario VARCHAR(45) NOT NULL,
        dataNastoUsuario DATE NOT NULL,
        profissaoUsuario VARCHAR(45) NOT NULL-- Não é notnull, porque a pessoa pode estar desempregada => Perguntar para professora
        
);
CREATE TABLE tbGastos(
	idGastos INT PRIMARY KEY AUTO_INCREMENT,
	dataGasto DATETIME NOT NULL,
	valorGasto DECIMAL(10,2) NOT NULL,
	descricaoGasto VARCHAR(300) NOT NULL,
	idUsuario INT,
	FOREIGN KEY (idUsuario) REFERENCES tbUsuario(idUsuario)
); 

CREATE TABLE tbIdioma(
        idIdioma INT PRIMARY KEY AUTO_INCREMENT,
        nomeIdioma VARCHAR(45) NOT NULL,  
        paisIdioma VARCHAR(45), -- Para diferenciar o PTBR/PT, ou o Inglês britanico e o americano, etc,)         
	idUsuario INT,
        FOREIGN KEY (idUsuario) REFERENCES tbUsuario(idUsuario)
); 
-- Uma pessoa pode falar mais de um idioma 

INSERT INTO tbUsuario VALUES
		(null, 'Daniel Tomás Pires', '1976-11-23', 'Engenheiro'),
		(null, 'Giovania Tânia Moraes', '1999-9-21','Maquiadora'),
		(null,'Júlia Ferreira dos Santos', '2007-9-11','Desempregada'),
		(null,'Gustavo Antônio Moraes','2003-12-6','Analista de Sistemas');

INSERT INTO tbGastos VALUES
		(null,'2022-03-30','400.32','Comprei uma memória ram a mais',4),
		(null,'2022-01-11','20000.31','Comprei um anel da Tiffany para meu casamento',1),
		(null,'2022-03-12','50.99','Lanchei com meu namorado no McDonalds',2),
		(null,'2022-04-12','12.99','Comprei um lanche na estação',3);
		
INSERT INTO tbIdioma VALUES
		(null,'Espanhol',null,3),
		(null,'Inglês','Inglaterra',2),
		(null,'Inglês','Inglaterra',3),
		(null,'Latim Vulgar',null,1),
		(null,'Japonês',null,4);

SELECT * FROM tbIdioma;
SELECT * FROM tbGastos;
SELECT * FROM tbUsuario;
SELECT tbUsuario.*, tbGastos.dataGasto FROM tbUsuario, tbGastos WHERE tbGastos.dataGasto LIKE '%03%' AND tbGastos.idUsuario=tbUsuario.idUsuario;
SELECT * FROM tbGastos ORDER BY dataGasto DESC;
SELECT * FROM tbUsuario,tbGastos WHERE tbUsuario.idUsuario=tbGastos.idUsuario;
SELECT * FROM tbUsuario,tbGastos WHERE tbUsuario.idUsuario=tbGastos.idUsuario AND tbGastos.dataGasto = '2022-01-11';




UPDATE tbUsuario SET nomeUsuario='Jorge Soares da Silva' WHERE idUsuario=1;
UPDATE tbIdioma SET nomeIdioma='Esperanto' WHERE idIdioma=4;
DELETE FROM tbUsuario WHERE idUsuario=3;
