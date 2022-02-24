CREATE DATABASE AtletaBD;
USE AtletaBD;
CREATE TABLE Atleta(
idAtleta INT PRIMARY KEY, 
nomeAtleta VARCHAR(40),
modalidadeAtleta VARCHAR(40),
qtdMedalhaAtleta INT
);

INSERT  INTO Atleta VALUES(1,"Simone Biles", "Ginástica Olímpica", 2),
						  (2,"Naomi Osaka", "Tênis", 4),
						  (3,"Paulo Dybalas", "Futebol", 2),
						  (4,"Ali Krieger", "Futebol", 1),
						  (5,"Alex Morgan", "Futebol", 5),
						  (6,"Lionel Messi", "Futebol", 6),
						  (7,"Lewis Hamilton", "Piloto", 3);
-- SELECTS
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
SELECT * FROM Atleta WHERE nomeAtleta LIKE "%a";
SELECT * FROM Atleta WHERE nomeAtleta LIKE "a%";
SELECT * FROM Atleta WHERE nomeAtleta LIKE "%n";
SELECT * FROM Atleta WHERE nomeAtleta LIKE "%o_";
UPDATE Atleta SET qtdMedalhaAtleta =3 WHERE idAtleta =3 ; 
UPDATE Atleta SET qtdMedalhaAtleta = 2, nomeAtleta = "Ali Kriegger" WHERE idAtleta = 4; 
DELETE FROM Atleta WHERE idAtleta=7;
DROP TABLE Atleta
				