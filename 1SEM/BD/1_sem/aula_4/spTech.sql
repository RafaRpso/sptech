CREATE DATABASE spTechAlunos;
USE sptechAlunos

CREATE TABLE tbCurso(
        idCurso INT PRIMARY KEY AUTO_INCREMENT,
        nomeCurso CHAR(3),
        coordenadorCurso VARCHAR(40)
) AUTO_INCREMENT=100;

CREATE TABLE tbAluno(
        idAluno INT PRIMARY KEY AUTO_INCREMENT,
        nomeAluno VARCHAR(40),
        bairroAluno VARCHAR(30),
        fkCurso INT,
        FOREIGN KEY(fkCurso) REFERENCES tbCurso(idCurso)
)AUTO_INCREMENT=50000;

INSERT INTO tbCurso VALUES(null,"CCO", "Marise"),
                        (null, "SIS","Alex"),
                        (null, "ADS","Gerson");

INSERT INTO tbAluno VALUES(null, "Marco Antônio", "Grajaú", 100),
                        (null, "Rafael Raposo", "Guaianazes", 100),
                        (null, "Agda Taneguchi", "Paulista", 100),
                        (null, "Hugo Hanashiro", "Itaquera", 101);

CREATE TABLE tbProfessores( 
	idProfessor INT PRIMARY KEY AUTO_INCREMENT 
	nomeProfessor VARCHAR(40), 
	disciplinaProfessor CHAR(3),
	fkCurso INT,
	FOREIGN KEY fkCurso REFERENCES tbCurso(idCurso)

);

INSERT INTO tbProfessor(null, 'Frizza','Algoritmo'),
			(null, 'Célia Taniwachi', 'Banco de Dados'),
			(null, 'Rafael Petry', 'Tecnologia da informação');



SELECT tbProfessores.* 

SELECT * FROM tbAluno -- Puxa os valores da Fk também xd
SELECT * FROM tbAluno, tbCurso WHERE fkCurso=idCurso; -- Puxa os dados dos cursos APENAS quando ambos são iguais
SELECT * FROM tbAluno, tbCurso -- Sem where, acontece de puxar 3 vezes (:, uma pra cada curso
SELECT * FROM tbAluno, tbCurso WHERE fkCurso=idCurso AND fkCurso=100;

SELECT tbAluno.*, nomeCurso?coordenadorCurso FROM tbAluno, tbCurso WHERE fkCurso=idCurso;
