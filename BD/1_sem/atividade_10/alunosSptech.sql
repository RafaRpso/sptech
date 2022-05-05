CREATE DATABASE dbSptech ; 
USE dbSptech ; 


-- cada aluno cursa mais de uma disciplina 
-- cada disciplina é cursada por maiss deu m aluno 

CREATE TABLE tbAluno(
	idAlunoRa INT PRIMARY KEY AUTO_INCREMENT, 
	nomeAluno VARCHAR(45) NOT NULL, 
	bairroAluno VARCHAR(45) 
) ; 

CREATE TABLE tbDisciplina(
	idDisciplina INT PRIMARY KEY AUTO_INCREMENT, 
	nomeDisciplina VARCHAR(45) NOT NULL  
) ; 

-- associativa
CREATE TABLE tbAlunoDisciplina(
		idDisciplina INT , 
		idAlunoRa INT ,
		mediaAlunoDisciplina INT , 
		quantidadeFaltas INT , 
		PRIMARY KEY (idDisciplina, idAlunoRa) , 
		FOREIGN KEY (idAlunoRa) REFERENCES tbAluno(idAlunoRa),
		FOREIGN KEY (idDisciplina) REFERENCES tbDisciplina(idDisciplina)
);

INSERT INTO tbAluno VALUES 
(null, "Matheus Barizon Caus", "Vila Matilde") , 
(null, "Alessandra do Carmo Baccin", "Vila Matilde") , 
(null, "Gabriel Vannuchi", "Vila Matilde" ) ,
(null, "Ricardo Texeira", "Avenida Paulista" ) ,
(null, "Brayan de Aquino Coelho", "Luz" ) ; 

INSERT INTO tbDisciplina VALUES 
(null, "Ciência da Computação"),
(null, "Sistemas da informação") , 
(null, "Análise de sistemas") , 
(null, "Matemática para Sistemas Operacionais") ; 
-- disciplina, aluno, media, falta
INSERT INTO tbAlunoDisciplina VALUES
(1,1,8,42),
(1,2,9,25),
(2,3,4,12), 
(3,4,10,1), 
(4,5,10,0) ; 


SELECT * FROM tbAluno ; 
SELECT * FROM tbDisciplina ; 
SELECT * FROM tbAlunoDisciplina


SELECT * FROM tbAlunoDisciplina, tbAluno, tbDisciplina WHERE tbAlunoDisciplina.idAlunoRa=tbAluno.idAlunoRa AND tbAlunoDisciplina.idDisciplina=tbDisciplina.idDisciplina ; 

SELECT * FROM tbAlunoDisciplina, tbAluno, tbDisciplina WHERE tbAlunoDisciplina.idAlunoRa=tbAluno.idAlunoRa AND tbAlunoDisciplina.idDisciplina=1 ; 

SELECT sum(mediaAlunoDisciplina) FROM tbAlunoDisciplina ; 

SELECT avg(mediaAlunoDisciplina) FROM tbAlunoDisciplina ; 

SELECT count(mediaAlunoDisciplina) FROM tbAlunoDisciplina WHERE quantidadeFaltas>20 ; 

SELECT max(mediaAlunoDisciplina), min(mediaAlunoDisciplina) FROM tbAlunoDisciplina, tbDisciplina,tbAluno WHERE tbAlunoDisciplina.idDisciplina=tbDisciplina.idDisciplina GROUP BY tbDisciplina.idDisciplina;

SELECT max(mediaAlunoDisciplina),min(mediaAlunoDisciplina) FROM tbAlunoDisciplina, tbAluno, tbDisciplina WHERE tbAlunoDisciplina.idAlunoRa=tbAluno.idAlunoRa GROUP BY tbAlunoDisciplina.idAlunoRa;

SELECT max(quantidadeFaltas), min(quantidadeFaltas) FROM tbAlunoDisciplina GROUP BY tbAlunoDisciplina.idDisciplina ; 

SELECT max(quantidadeFaltas), min(quantidadeFaltas) FROM tbAlunoDisciplina GROUP BY tbAlunoDisciplina.idAlunoRa ; 

SELECT mediaAlunoDisciplina FROM tbAlunoDisciplina ; 

SELECT DISTINCT(mediaAlunoDisciplina) FROM tbAlunoDisciplina  ; 

SELECT COUNT(mediaAlunoDisciplina) FROM tbAlunoDisciplina ; 

SELECT DISTINCT(COUNT(mediaAlunoDisciplina))FROM tbAlunoDisciplina ; 
