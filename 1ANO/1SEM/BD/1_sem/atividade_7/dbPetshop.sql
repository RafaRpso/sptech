CREATE DATABASE dbPetshop;
USE dbPetshop;

CREATE TABLE tbAnimal(
	idAnimal INT PRIMARY KEY AUTO_INCREMENT, 
	nomeAnimal VARCHAR(45), 
	tipoAnimal VARCHAR(45) NOT NULL,
	racaAnimal VARCHAR(45) NOT NULL,
	pesoAnimal DECIMAL(10,2) NOT NULL,
	idCliente INT,
	FOREIGN KEY (idCliente) REFERENCES tbCliente(idCliente)
)AUTO_INCREMENT=101;

CREATE TABLE tbTelefone(
	idTelefone INT PRIMARY KEY AUTO_INCREMENT,
	celularTelefone CHAR(11) NOT NULL UNIQUE,
	fixoTelefone CHAR(8) UNIQUE,
	idCliente INT,
	FOREIGN KEY (idCliente) REFERENCES tbCliente(idCliente)
	-- só um telefone por cliente. Evitar cadastros indevidos 	
);

CREATE TABLE tbEndereco(
	idEndereco INT PRIMARY KEY AUTO_INCREMENT,
	estadoEndereco VARCHAR(45),
	cidadeEndereco VARCHAR(45), -- Não sei o quão grande é a linha de petshop
	bairroEndereco VARCHAR(45),
	ruaEndereco VARCHAR(45),
	cepEndereco CHAR(8)
);

CREATE TABLE tbCliente(
        idCliente INT PRIMARY KEY AUTO_INCREMENT,
        nomeCliente VARCHAR(45) NOT NULL,
        idEndereco INT,
        FOREIGN KEY (idEndereco) REFERENCES tbEndereco(idEndereco)
);

INSERT INTO tbAnimal VALUES
	(null,'Bolinha','Cachorro','Pug','16.5',2),
	(null,'Garfield','Gato','Siames','12.5',1),
	(null,'Sangue-frio','Cobra','Cascavel','34.2',3),
	(null,'Sangue-quente','Hamster','Sírio','5.1',3);

INSERT INTO tbTelefone VALUES
	(null,'11982072830','25559284',2),
	(null,'11958021619',null,1),
	(null,'11939821123',null,3);

INSERT INTO tbEndereco VALUES
	(null, 'Minas Gerais','Belo Horizonte','Centro','Rua dos Carijós','30120060'),
	(null, 'São Paulo','Sâo Paulo', 'Vila da Saúde','Rua Pereira Estéfano','04144070'),
	(null,'São Paulo','São Paulo', 'Vila Olímpia','Rua das fiandeiras','04545005'); 

INSERT INTO tbCliente VALUES
	(null,'Heloisa Mirella Sales',2),
	(null,'Betina Brenda',1), 
	(null,'Márcio Diogo',3);

SELECT * FROM tbCliente;
SELECT * FROM tbEndereco;
SELECT * FROM tbTelefone;
SELECT * FROM tbAnimal;
SELECT * FROM tbAnimal WHERE tipoAnimal LIKE 'Cachorro';
SELECT nomeAnimal,pesoAnimal FROM tbAnimal;
ALTER TABLE tbCliente MODIFY nomeCliente VARCHAR(50) NOT NULL;
SELECT * FROM tbAnimal ORDER BY nomeAnimal ;
SELECT * FROM tbCliente,tbEndereco WHERE tbCliente.idEndereco = tbEndereco.idEndereco ORDER BY tbEndereco.bairroEndereco DESC ;
SELECT * FROM tbAnimal WHERE nomeAnimal LIKE 'S%';
SELECT * FROM tbCliente WHERE nomeCliente LIKE '%Brenda%';
UPDATE tbTelefone SET celularTelefone='11975893042' WHERE tbTelefone.idCliente = 2;
SELECT * FROM tbCliente, tbTelefone WHERE tbCliente.idCliente=tbTelefone.idCliente AND tbTelefone.idCliente=2;
SELECT * FROM tbAnimal,tbCliente WHERE tbAnimal.idCliente = tbCliente.idCliente;
SELECT * FROM tbAnimal,tbCliente WHERE tbAnimal.idCliente = tbCliente.idCliente AND tbCliente.nomeCliente LIKE 'Márcio%';
SELECT tbCliente.*, tbAnimal.*, tbTelefone.celularTelefone FROM tbAnimal,tbCliente, tbTelefone WHERE tbAnimal.idCliente = tbCliente.idCliente AND tbTelefone.celularTelefone = '11939821123' AND tbCliente.idCliente = tbTelefone.idCliente;
DELETE FROM tbAnimal WHERE idAnimal=106;

DROP TABLE tbEndereco,tbCliente,tbTelefone,tbAnimal;
