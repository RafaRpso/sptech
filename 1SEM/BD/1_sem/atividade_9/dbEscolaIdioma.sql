CREATE TABLE tbAluno( 
	idAluno INT PRIMARY KEY AUTO_INCREMENT ,
	nomeAluno VARCHAR(45) NOT NULL , 
	bairroAluno VARCHAR(45) NOT NULL  

); 

CREATE TABLE tbCurso(
	idCurso INT PRIMARY KEY AUTO_INCREMENT , 
	nomeCurso VARCHAR(75) NOT NULL , 
	coordenadorCurso VARCHAR(45) NOT NULL  


);

CREATE TABLE tbAlunoCurso( 
	idAluno INT , 
	idCurso INT , 
	FOREIGN KEY (idAluno) REFERENCES tbAluno(idAluno) , 
	FOREIGN KEY (idCurso) REFERENCES tbCurso(idCurso), 
	dataInicioAluno DATE NOT NULL , 
	nivelAlunoCurso CHAR(2) ,
	mediaAlunoCurso DECiMAL (4,2) CHECK (mediaAlunoCurso>=0 AND mediaAlunoCurso<=10) ,	
	PRIMARY KEY (idAluno, idCurso, dataInicioAluno) 

) ; 


INSERT INTO tbAluno VALUES 
(null, 'Maria', 'Saúde') , 
(null, 'João', 'Consolação'); 


INSERT INTO tbCurso VALUES 
(null, 'Espanhol', 'Juan') , 
(null, 'Inglês', 'Beth') ; 

INSERT INTO tbAlunoCurso VALUES 
(1, 2, "2022-02-03","B", 9) , 
(2, 1, "2022-03-23", "I", 6) ;


SELECT * FROM tbAluno ; 
SELECT * FROM tbCurso ; 
SELECT * FROM tbAlunoCurso; 
SELECT * FROM tbAluno , tbCurso, tbAlunoCurso 
	WHERE tbAlunoCurso.idAluno = tbAluno.idAluno AND tbCurso.idCurso = tbAlunoCurso.idCurso AND tbAluno.nomeAluno = "Maria" ;
SELECT sum(mediaAlunoCurso) FROM tbAlunoCurso;
SELECT sum(mediaAlunoCurso) as 'Soma das médias'FROM tbAlunoCurso; 
SELECT round(avg(mediaAlunoCurso),2) AS 'Média das médias' FROM tbAlunoCurso; -- truncate deleta os zeros, round arredonda pro mais próximo 
SELECT truncate(avg(mediaAlunoCurso),2) AS 'Média das médias' FROM tbAlunoCurso; -- truncate deleta os zeros, round arredonda pro mais próxim
SELECT truncate(avg(mediaAlunoCurso),2) AS mediaDasMedias, sum(mediaAlunoCurso) AS somaDasMedias FROM tbAlunoCurso; 
-- EXIBIR 
SELECT max(mediaAlunoCurso) AS mediaAlunoCurso FROM tbAlunoCurso;  -- max
SELECT min(mediaAlunoCurso) AS mediaAlunoCurso FROM tbAlunoCurso;  -- min
SELECT COUNT(mediaAlunoCurso) AS qtdMedia FROM alunoCurso; 
SELECT COUNT(mediaAlunoCurso) AS qtdMedia WHERE mediaAlunoCurso >= 6 ; 
SELECT mediaAlunoCurso FROM tbAlunoCurso; 
SELECT DISTINCT mediaAlunoCurso FROM tbAlunoCurso ;
SELECT COUNT(mediaAlunoCurso) FROM tbAlunoCurso; 
SELECT COUNT(DISTINCT mediaAlunoCurso) FROM tbAlunoCurso; 
SELECT * , mediaAlunoCurso+1 FROM tbAlunoCurso; 
SELECT idCurso, max(MediaAlunoCurso) FROM  tbAlunoCurso GROUP BY tbAlunoCurso.idCurso;:
