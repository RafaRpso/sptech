CREATE DATABASE dbAlunos;
USE dbAlunos;
CREATE TABLE tbEmpresaInteresse(
	idEmpresaInteresse INT PRIMARY KEY AUTO_INCREMENT,
    nomeEmpresa VARCHAR(40), 
    representanteEmpresa VARCHAR(40)
) AUTO_INCREMENT=000;

INSERT INTO tbEmpresaInteresse VALUES (null, 'Accenture','Renata'),
										(null, 'Safra','João'),
                                        (null, 'Adelloit','Carlos'),
                                        (null, 'Stefanini','Carlos Duarte');
		

CREATE TABLE tbInstituicaoEnsino(
	idInstituicaoEnsino INT PRIMARY KEY AUTO_INCREMENT, 
    nomeInstituicao VARCHAR(40),
    bairroInstituicao VARCHAR(40)
) AUTO_INCREMENT=100;

INSERT INTO tbInstituicaoEnsino VALUES(null, 'Etec Guaianazes','Guaianazes'),
									(null, 'Colégio Carlos','Paulista'),
                                    (null, 'Instituto Federal de São Paulo','Sé'),
                                    (null, 'Colégio Bittencourt','Ponte Grande');
                                    
CREATE TABLE tbALuno(
	idAluno INT PRIMARY KEY AUTO_INCREMENT,
    nomeAluno VARCHAR(40),
    hobbyAluno VARCHAR(40),
    fkEmpresaInteresse INT,
    fkInstituicaoEnsino INT,
    FOREIGN KEY (fkEmpresaInteresse) REFERENCES tbEmpresaInteresse(idEmpresaInteresse),
    FOREIGN KEY (fkInstituicaoEnsino) REFERENCES tbInstituicaoEnsino(idInstituicaoEnsino)
)AUTO_INCREMENT= 02221000;

INSERT INTO tbALuno VALUES(null,'Rafael Alves','Desenhar',001,100),
							(null,'Marco Antônio',	'Ler mangá',	002, 	101),
                            (null,'Hugo Hanashiro',	'Toca piano',	004 ,	101),
                            (null,'Matheus Gomes',	'Assistir filmes',	004	,100);



SELECT * FROM tbAluno;
SELECT * FROM tbALuno, tbInstituicaoEnsino WHERE fkInstituicaoEnsino=idInstituicaoEnsino;
SELECT * FROM tbALuno, tbEmpresaInteresse WHERE fkEmpresaInteresse=idEmpresaInteresse;
SELECT * FROM tbALuno, tbInstituicaoEnsino, tbEmpresaInteresse WHERE fkEmpresaInteresse=idEmpresaInteresse AND fkInstituicaoEnsino=idInstituicaoEnsino;