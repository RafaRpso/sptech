CREATE DATABASE dbProjetoMuvi; 
USE dbProjetoMuvi;

CREATE TABLE tbGestor(
        idGestor INTRIMARY KEY AUTO_INCREMENT,
        senhaGestor VARCHAR(16) NOT NULL , 
        emailGestor  VARCHAR(60) NOT NULL,
	cpfGestor CHAR(11) NOT NULL
        --Foreign telefoneGestor
);
CREATE TABLE tbTelGestor(
        idTelefone INT PRIMARY KEY ,   
        numeroPessoalTelefone CHAR(14),
        numeroEmpresarialTelefone CHAR(14) NOT NULL,
        numeroFixoTelefone CHAR(13)
);
CREATE TABLE tbShopping(
        idShopping INT PRIMARY KEY AUTO_INCREMENT,
        cnpjShopping CHAR(11) NOT NULL
        -- Foreign key para conectar com a localização
        -- Foreign key para conectar com o gestor
);
CREATE TABLE tbEnderecoShopping(
        idEnderecoShopping INT PRIMARY KEY AUTO_INCREMENT,
        numeroShopping INT, -- Local
        logradouroShopping VARCHAR(40),
        bairroShopping VARCHAR(40),
        cidadeShopping VARCHAR(40),
        estadoShopping VARCHAR(40)
        cepShopping VARCHAR(15) NOT NULL
);
CREATE TABLE tbSetor(
        idSetor INT PRIMARY KEY AUTO_INCREMENT,
        nomeSetor VARCHAR(40),
        quantidadeSetores INT 
        -- Foreign key para conectar com tbSensorShopping      
);
CREATE TABLE tbSensorShopping(
        idSensor INT  PRIMARY KEY  AUTO_INCREMENT,
        modeloSensor  VARCHAR(40) NOT NULL, 
        numeroSerieSensor VARCHAR(40) NOT NULL,
        quantidadePessoasSensor INT
);

