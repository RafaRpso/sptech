CREATE DATABASE bdRevista;
USE bdRevista;

CREATE TABLE tbRevista( 
	idRevista INT PRIMARY KEY AUTO_INCREMENT,
    nomeRevista VARCHAR(40),
    categoriaRevista VARCHAR(40)
);

INSERT INTO tbRevista VALUES(null, "Vogue", null),
							(null, "Elle", null), 
							(null, "Veja", null),
                            (null, "Abril", null); 
                            
SELECT * FROM tbRevista; 
UPDATE tbRevista SET categoriaRevista="Moda"  WHERE idRevista IN (1,2);
UPDATE tbRevista SET categoriaRevista="Noticia"  WHERE idRevista=3;
UPDATE tbRevista SET categoriaRevista="Notícia"  WHERE idRevista=4;

INSERT INTO tbRevista VALUES(null, "Maquiavelli", "Pop"), 
							(null, "Anime xis", "Entreterimento"),
                            (null, "GameWorld", "Jogos"); 

SELECT * FROM tbRevista;
DESC tbRevista;
ALTER TABLE tbRevista MODIFY categoriaRevista VARCHAR(60);
DESC tbRevista;
ALTER TABLE tbRevista RENAME COLUMN nomeRevista TO nomeRevista2;
DESC tbRevista;
ALTER TABLE tbRevista MODIFY periodicidadeRevista VARCHAR(15);
UPDATE tbRevista SET periodicidadeRevista = 10 WHERE idRevista IN (1,2,3); -- Anos
UPDATE tbRevista SET periodicidadeRevista = 3 WHERE idRevista IN (4,5,6);  -- Anos
UPDATE tbRevista SET periodicidadeRevista = 6 WHERE idRevista IN (7,8,9,10);
SELECT * FROM tbRevista;

INSERT INTO tbRevista VALUES(null, "Capricho","Moda",4);

ALTER TABLE tbRevista DROP COLUMN periodicidadeRevista; 


CREATE TABLE tbEditora(
	idEditora INT PRIMARY KEY AUTO_INCREMENT,
    nomeEditora VARCHAR(40),
    dataEditora DATE
    ); 
ALTER TABLE tbEditora AUTO_INCREMENT=1000;
INSERT INTO tbEditora VALUES(null, "Eclesiae", "2004-07-23"),
							(null, "Santa Cruz", "2006-09-24"),
                            (null, "Editora Vozes", "2012-11-10");
SELECT * FROM tbEditora;
                            