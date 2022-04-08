CREATE DATABASE dbPraticaJogador;
USE dbPraticaJogador;

CREATE TABLE tbTime(
	idTime INT PRIMARY KEY AUTO_INCREMENT,
	nomeTime VARCHAR(45) NOT NULL,
	nomeTecnico VARCHAR(45) NOT NULL,
	dataFormacaoTime DATE
);

CREATE TABLE tbJogador(
	idJogador INT PRIMARY KEY AUTO_INCREMENT, 
	nomeJogador VARCHAR(45) NOT NULL, 
	posicaoJogador VARCHAR(15) NOT NULL, 
	salarioJogador DECIMAL(10,2) CHECK(salarioJogador>0),
	idTime INT, 
	idConselheiro INT,
	FOREIGN KEY (idTime) REFERENCES tbTime(idTime),
	FOREIGN KEY (idConselheiro) REFERENCES tbJogador(idJogador)
);

CREATE TABLE tbSeguidor(
	idSeguidor INT,
	nomeSeguidor VARCHAR(45) NOT NULL, 
	nickSeguidor VARCHAR(45),
	sexoSeguidor CHAR(1) CHECK(sexoSeguidor='m' OR sexoSeguidor='f'),
	idJogador INT,
        FOREIGN KEY (idJogador) REFERENCES tbJogador(idJogador), 
        PRIMARY KEY(idJogador,idSeguidor)
); 

INSERT INTO tbTime VALUES
(NULL, 'Corinthians Itaquera','João Vitor Sales','1932-03-21'),
(NULL, 'São Paulo','Ryan Miyazato','1921-03-21'),
(NULL, 'Grêmio','Pedro Alberani','1910-11-20');

INSERT INTO tbJogador VALUES
(1,'Rafael Raposo','Goleiro','3000.00',1,1),
(2,'Guilherme Almeida','Atacante','6000.00',2,NULL),
(3,'Brayan Coelho','Atacante','12000.00',1,NULL),
(4, 'Gustavo Antônio','Guarda-redes','4500.00',2,2),
(5,'Victor Hugo','Defesa','5500.00',3,NULL);

INSERT INTO tbSeguidor VALUES
(1,'João Vitor Sales','pιneapplenтт_','m',1),
(2,'Agda Taniguchi','adjasente','f',2),
(3,'Marco Antônio','Shapeshifter38','m',1),
(4,'Pedro Anastácio','FROZONE_Ice','m',3),
(5,'Ryan Miyazato','miya','m',4);

SELECT * FROM tbTime;
SELECT * FROM tbJogador;
SELECT * FROM tbSeguidor;
SELECT nomeTime,nomeTecnico FROM tbTime WHERE  nomeTime LIKE 'C%';
SELECT * FROM tbJogador ORDER BY posicaoJogador DESC;
SELECT * FROM tbJogador WHERE posicaoJogador='Atacante';
SELECT * FROM tbTime WHERE nomeTecnico LIKE '%t_';
SELECT * FROM tbTime ORDER BY nomeTecnico;
SELECT * FROM tbTime ORDER BY dataFormacaoTime DESC;
UPDATE tbJogador SET posicaoJogador='Reserva' WHERE idJogador=3;
SELECT * FROM tbTime,tbJogador WHERE tbJogador.idTime=tbTime.idTime;
SELECT * FROM tbJogador AS jogador, tbJogador AS conselheiro WHERE jogador.idJogador=conselheiro.idJogador;
SELECT * FROM tbTime,tbJogador AS jogador, tbJogador AS conselheiro WHERE jogador.idJogador=conselheiro.idjogador AND jogador.idTime=tbTime.idTime;
SELECT * FROM tbTime,tbJogador AS jogador, tbJogador AS conselheiro WHERE jogador.idJogador=conselheiro.idJogador AND jogador.idTime=tbTime.idTime AND jogador.nomeJogador='Guilherme Almeida';
SELECT * FROM tbJogador, tbSeguidor WHERE tbSeguidor.idJogador=tbJogador.idJogador;
SELECT * FROM tbJogador, tbSeguidor, tbJogador AS jogador, tbJogador AS
 conselheiro WHERE nomeJogador='Brayan Coelho' AND conselheiro.idJogador=jogador.idJogador;
 SELECT * FROM tbJogador, tbSeguidor, tbJogador AS jogador, tbJogador AS  conselheiro WHERE jogador.nomeJogador='Brayan Coelho' AND conselheiro.idJogador=jogador.idJogador AND tbSeguidor.idJogador=tbJogador.idJogador;

DELETE FROM tbJogador WHERE idJogador=5;
DROP TABLE tbSeguidor;
DROP DATABASE dbPraticaJogador

 
