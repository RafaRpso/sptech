CREATE DATABASE dbAtleta;
USE dbAtleta;
CREATE TABLE Atleta(
idAtleta INT PRIMARY KEY, 
nomeAtleta VARCHAR(40),
modalidadeAtleta VARCHAR(40),
qtdMedalhaAtleta INT,
fkIdPais INT,
FOREIGN KEY (fkIdPais) REFERENCES tbPais(idPais)
);
CREATE TABLE tbPais(
	idPais INT PRIMARY KEY AUTO_INCREMENT,
    nomePais VARCHAR(40) NOT NULL,
    capitalPais VARCHAR(40) NOT NULL
);
ALTER TABLE Atleta ADD fkPais INT;

INSERT tbPais VALUES(null, 'Congo','Brazzavile'),
					(null,'Japão','Tokyo'),
                    (null,'Alemanha','Berlim'),
                    (null,'Brasil','Brasília');

INSERT  INTO Atleta VALUES(1,"Simone Biles", "Ginástica Olímpica", 2,1),
						  (2,"Naomi Osaka", "Tênis", 4,2),
						  (3,"Paulo Dybalas", "Futebol", 2,2),
						  (4,"Ali Krieger", "Futebol", 1,3),
						  (5,"Alex Morgan", "Futebol", 5,4),
						  (6,"Lionel Messi", "Futebol", 6,2),
						  (7,"Lewis Hamilton", "Piloto", 3,3);
-- SELECTS
SELECT * FROM Atleta, tbPais WHERE fkIdPais=idPais;
-- Japão
SELECT * FROM Atleta, tbPais WHERE fkIdPais=idPais AND idPais=2;


SELECT * FROM Atleta;
SELECT nomeAtleta, qtdMedalhaAtleta FROM Atleta;
SELECT modalidadeAtleta, nomeAtleta FROM Atleta;
SELECT * FROM Atleta WHERE modalidadeAtleta = "Futebol";
SELECT * FROM Atleta WHERE qtdMedalhaAtleta >= 3;
SELECT * FROM Atleta WHERE idAtleta <= 3;
SELECT nomeAtleta FROM Atleta WHERE modalidadeAtleta = "Tênis";
SELECT * FROM Atleta WHERE idAtleta BETWEEN 2 AND 5;
SELECT * FROM Atleta WHERE idAtleta <> 5; 
SELECT * FROM Atleta ORDER BY modalidadeAtleta;
SELECT * FROM Atleta ORDER BY  qtdMedalhaAtleta DESC; 
SELECT * FROM Atleta WHERE nomeAtleta LIKE "%a%";
SELECT * FROM Atleta WHERE nomeAtleta LIKE "a%";
SELECT * FROM Atleta WHERE nomeAtleta LIKE "%n";
SELECT * FROM Atleta WHERE nomeAtleta LIKE "%o_";
UPDATE Atleta SET qtdMedalhaAtleta =3 WHERE idAtleta =3 ; 
UPDATE Atleta SET qtdMedalhaAtleta = 2, nomeAtleta = "Ali Kriegger" WHERE idAtleta = 4; 
DELETE FROM Atleta WHERE idAtleta=7;
DROP TABLE Atleta