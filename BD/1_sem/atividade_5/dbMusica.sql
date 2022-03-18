CREATE DATABASE dbMusica; 
USE dbMusica;
CREATE TABLE tbAlbum(
	idAlbum INT PRIMARY KEY AUTO_INCREMENT, 
    nomeAlbum VARCHAR(40) NOT NULL,
    gravadoraAlbum VARCHAR(40)
); 
INSERT INTO tbAlbum VALUES(null,'As melhores dos anos 80','Dream Records'),
						(null, 'As melhores japonesas','Nipon Records'),
                        (null, 'Patriotismo','Gravadora Bandeirantes');
                        
CREATE TABLE tbMusica( -- Criar tabela com os dados
idMusica INT PRIMARY KEY, 
tituloMusica VARCHAR(40),
artistaMusica VARCHAR(40),
generoMusica VARCHAR(40),
idAlbum INT,
FOREIGN KEY (idAlbum) REFERENCES tbAlbum(idAlbum)
);

-- Inserts
INSERT INTO tbMusica VALUES(1,"Jukkai", "Akina Nakamori", "J-pop",2),
						(2,"Desire", "Akina Nakamori", "J-pop",2),
                        (3,"Tiro ao Álvaro", "Adoniran Barbosa", "MPB",1),
                        (4,"João e Maria", "Chico Buarque", "MPB",1),
                        (5,"O Mundo é um moinho", "Cartola", "Samba",3),
                        (6,"Dies Irae", "Wolfgang Amadeus Mozart", "Clássica",1),
                        (7,"Glórias ao Brasil", "Nuno Roland", "MPB",3);

-- Select
SELECT * FROM tbMusica, tbAlbum WHERE tbAlbum.idAlbum = tbMusica.idAlbum;
SELECT * FROM tbMusica, tbAlbum WHERE tbAlbum.idAlbum = tbMusica.idAlbum AND tbAlbum.idAlbum=2; -- As melhores japonesas
SELECT * FROM tbMusica, tbAlbum WHERE tbAlbum.idAlbum = tbMusica.idAlbum AND tbAlbum.gravadoraAlbum='Nipon Records';


SELECT * FROM tbMusica; 
SELECT tituloMusica, artistaMusica FROM tbMusica; 
SELECT generoMusica, artistaMusica FROM tbMusica;
SELECT * FROM tbMusica WHERE generoMusica= "MPB";
SELECT * FROM tbMusica WHERE artistaMusica = "Akina Nakamori";
SELECT tituloMusica FROM tbMusica WHERE generoMusica = "MPB";
SELECT tituloMusica, generoMusica FROM tbMusica WHERE artistaMusica = "Cartola";
SELECT * FROM tbMusica WHERE idMusica BETWEEN 2 AND 5;
SELECT * FROM tbMusica WHERE idMusica<5;
SELECT * FROM tbMusica WHERE idMusica>2;
SELECT * FROM tbMusica WHERE idMusica <> 2 AND idMusica <> 7;
SELECT * FROM tbMusica ORDER BY tituloMusica;
SELECT * FROM tbMusica ORDER BY artistaMusica DESC; 
SELECT * FROM tbMusica WHERE tituloMusica LIKE "J%";
SELECT * FROM tbMusica WHERE artistaMusica LIKE "%A";
SELECT * FROM tbMusica WHERE generoMusica LIKE "_P%"; -- SEGUNDO TRAS
SELECT * FROM tbMusica WHERE tituloMusica LIKE "%R_"; -- PENULTIMO FRENTE

-- Updates
UPDATE tbMusica SET generoMusica = "MPB" WHERE idMusica = 5; -- Alterando Cartola de Samba para MPB
UPDATE tbMusica SET generoMusica = "J-POP 90s",artistaMusica = "Akinna Nakamori" WHERE idMusica = 1 || idMusica = 2; -- Alterando de "Akina Nakamori" para "Akinna Nakamori" e de "J-pop" para "J-pop 90s"

-- Excluir uma musica (6,"Dies Irae", "Wolfgang Amadeus Mozart", "Clássica"),
DELETE FROM tbMusica WHERE idMusica=6;

-- Deletar tabela
DROP TABLE tbMusica; 

-- Deletar database
DROP DATABASE tbMusica; 