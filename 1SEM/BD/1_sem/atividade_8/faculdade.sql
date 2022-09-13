CREATE DATABASE dbFaculdade;
USE DbFaculdade;

CREATE TABLE tbAluno(
	idAluno INT PRIMARY KEY AUTO_INCREMENT, -- RA
	nomeAluno VARCHAR(45) NOT NULL,
	telefoneAluno CHAR(11) UNIQUE,
	idProjeto INT,
	idRepresentante INT, 
	FOREIGN KEY (idRepresentante) REFERENCES tbAluno(idAluno),
	FOREIGN KEY (idProjeto) REFERENCES tbProjeto(idProjeto)
)auto_increment=1000; 

CREATE TABLE tbProjeto(
	idProjeto INT PRIMARY KEY AUTO_INCREMENT, 
	nomeProjeto VARCHAR(45) NOT NULL,
	descricaoProjeto VARCHAR(500) NOT NULL
);

CREATE TABLE tbAcompanhante(
	idAluno INT,
	idAcompanhante INT, 
	nomeAcompanhante VARCHAR(45), 
	tipoRelacaoAcompanhante VARCHAR(20),
	FOREIGN KEY (idAluno) REFERENCES tbAluno(idAluno),
	PRIMARY KEY (idAluno, idAcompanhante)

); 


INSERT INTO tbProjeto VALUES
		(null,'Estufa de Morangos Silvestres', 'Nós cuidamos de morangos com muito carinho e tecnologia'),
		(null, 'Catador de lixo robótico', 'Nós pegamos latinhas e vendemos automaticamente com robôs!'),
		(null, 'Automatização de agenda de confissão', 'Automatizamos o sistema de confessionário na Catedral da Sé'), 
		(null,'TerPaint','Um paint para desenhar com ASCII via terminal unix, com foco em Gentoo!');

INSERT INTO tbAluno VALUES
		(1,'Agda Taniguchi', '11929210808',1,1),
		(2,'Rafael Alves','11982072830',3,null),
		(3,'Brayan Coelho','11989876176',1,2),
		(4, 'Marco Antônio','11944445555',2,null),
		(5,'Pedro Alberani','11987653210',2,null),
		(6,'Pedro Jesuíno','11987654219',3,null),
		(7,'Ryan Miyazato','11978212044',4,null),
		(8,'Pedro Anastácio','11985443022',4,3);
	
INSERT INTO tbAcompanhante VALUES
		(1,1,'Jorge Taniguchi','Pai'),
		(1,2,'Maria Barros Taniguchi','Mãe'),
		(2,3, 'Lilian Alves Chaves Souza', 'Mãe'),
		(2,4,'Leandro Barros Freitas','Pai'),
		(2,5,'Júlia Ferreira Lopes','Namorado'),
		(4,6,'Vanellope Siqueira César','Tia'),
		(5,7,'Igor Alberani','Pai'),
		(6,8,'Yasmin Jesuíno','Tia'),
		(7,9,'Aiko Miyazato','Tia'),
		(8,10,'Pedro Antônio','Colega');
	
SELECT * FROM tbAcompanhantes;
SELECT * FROM tbAluno;
SELECT * FROM tbProjeto
SELECT * FROM tbAluno WHERE tbProjeto.idProjeto = tbAluno.idProjeto;
SELECT * FROM tbAcompanhante WHERE tbAluno.idALuno = tbAcompanhante.idAluno;
SELECT * FROM tbAluno AS aluno, tbAluno AS representante WHERE aluno.idRepresentante = representante.idAluno;
SELECT * FROM tbAluno,tbProjeto WHERE tbProjeto.nomeProjeto='Automatização de agenda de confissão' AND tbProjeto.idProjeto=tbAluno.idProjeto;
SELECT * FROM tbAluno,tbProjeto,tbAcompanhante WHERE tbAluno.idAluno=tbAcompanhante.idAluno AND tbAluno.idProjeto=tbProjeto.idProjeto ;


