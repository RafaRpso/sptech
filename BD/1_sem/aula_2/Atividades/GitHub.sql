CREATE DATABASE Musica; 
USE Musica;

CREATE TABLE Musica( -- Criar tabela com os dados
idMusica INT PRIMARY KEY, 
tituloMusica VARCHAR(40),
artistaMusica VARCHAR(40),
generoMusica VARCHAR(40)
);

-- Inserts
INSERT INTO Musica VALUES(1,"Jukkai", "Akina Nakamori", "J-pop"),
						(2,"Desire", "Akina Nakamori", "J-pop"),
                        (3,"Tiro ao Álvaro", "Adoniran Barbosa", "MPB"),
                        (4,"João e Maria", "Chico Buarque", "MPB"),
                        (5,"O Mundo é um moinho", "Cartola", "Samba"),
                        (6,"Dies Irae", "Wolfgang Amadeus Mozart", "Clássica"),
                        (7,"Glórias ao Brasil", "Nuno Roland", "MPB");

-- Select
SELECT * FROM Musica; 
SELECT tituloMusica, artistaMusica FROM Musica; 
SELECT generoMusica, artistaMusica FROM Musica;
SELECT * FROM Musica WHERE generoMusica= "MPB";
SELECT * FROM Musica WHERE artistaMusica = "Akina Nakamori";
SELECT tituloMusica FROM Musica WHERE generoMusica = "MPB";
SELECT tituloMusica, generoMusica FROM Musica WHERE artistaMusica = "Cartola";
SELECT * FROM Musica WHERE idMusica BETWEEN 2 AND 5;
SELECT * FROM Musica WHERE idMusica<5;
SELECT * FROM Musica WHERE idMusica>2;
SELECT * FROM Musica WHERE idMusica <> 2 AND idMusica <> 7;
SELECT * FROM Musica ORDER BY tituloMusica;
SELECT * FROM Musica ORDER BY artistaMusica DESC; 
SELECT * FROM Musica WHERE tituloMusica LIKE "J%";
SELECT * FROM Musica WHERE artistaMusica LIKE "%A";
SELECT * FROM Musica WHERE generoMusica LIKE "_P%"; -- SEGUNDO TRAS
SELECT * FROM Musica WHERE tituloMusica LIKE "%R_"; -- PENULTIMO FRENTE

-- Updates
UPDATE Musica SET generoMusica = "MPB" WHERE idMusica = 5; -- Alterando Cartola de Samba para MPB
UPDATE Musica SET generoMusica = "J-POP 90s",artistaMusica = "Akinna Nakamori" WHERE idMusica = 1 || idMusica = 2; -- Alterando de "Akina Nakamori" para "Akinna Nakamori" e de "J-pop" para "J-pop 90s"

-- Excluir uma musica (6,"Dies Irae", "Wolfgang Amadeus Mozart", "Clássica"),
DELETE FROM Musica WHERE idMusica=6;

-- Deletar tabela
DROP TABLE Musica; 

-- Deletar database
DROP DATABASE Musica; 