CREATE DATABASE dbProjetoMuvi; 
USE dbProjetoMuvi;


CREATE TABLE tbGestor(
        idGestor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        passwordGestor VARCHAR(16),
        emailGestor  VARCHAR(60),
	cpfGestor CHAR(11)
        --Foreign telefoneGestor
);
CREATE TABLE tbTelGestor(
        idTelefone INT NOT NULL NOT NULL PRIMARY KEY ,   
        numeroPessoalTelefone CHAR(14),
        numeroEmpresarialTelefone CHAR(14),
        numeroFixo CHAR(13)
);

CREATE TABLE tbShopping(
        idShopping INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        cnpjShopping CHAR(11)
        -- Foreign key para conectar com a localização
        -- Foreign key para conectar com o gestor
);

CREATE TABLE tbSetor(
        idSetor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        nomeSetor VARCHAR(40),
        quantidadeSetores INT

        -- Foreign key para conectar com tbSensorShopping      
);

CREATE TABLE tbEnderecoShopping(
        idEnderecoShopping INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        numeroShopping INT, -- Local
        logradouroShopping VARCHAR(40),
        bairroShopping VARCHAR(40),
        cidadeShopping VARCHAR(40),
        estadoShopping VARCHAR(40)
);

CREATE TABLE tbSensorShopping(
        idSensor INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
        modeloSensor  VARCHAR(40),
        quantidadePessoasSensor INT
);

CREATE TABLE tbQtdSetor(
        idQtdSetor INT NOT NULL PRIMARY KEY  AUTO_INCREMENT
        -- FOREIGN no idSetor
        -- FOREIGN no quantidadesSensores
        -- FOREIGN no quantidadePessoasSensor
);
