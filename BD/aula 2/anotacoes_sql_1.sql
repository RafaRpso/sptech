-- Isso é um comentário
-- Criação de um Banco de Dados
CREATE DATABASE aluno_cco; 
USE aluno_cco; 

-- Criação de uma tabela 
CREATE TABLE Aluno( 
	ra INT PRIMARY KEY, -- Veja 'especificações' caso tenha dúvida em cada parte
	nome VARCHAR(40),  -- VARCHAR, INT, ETC; Todos esses são metadados, ou seja, dados que definem outros dados
    bairro VARCHAR(40)
);
-- Exibição dos dados da TABELA, ou seja, mostrar os valores CONTIDOS dentro da tabela

INSERT INTO Aluno VALUES
						(02221030,'João Vitor Taneguchi','Rua Nipônica Brasileira');
SELECT * FROM Aluno;
SELECT ra FROM ALUNO;
SELECT ra, nome,bairro FROM ALUNO; 

-- Where é como uma condição 'Se', ou seja: Se 'nome for igual a João Vitor Sales', então faça SELECT * FROM Aluno  
SELECT * from Aluno WHERE ra = 0221024; -- Seleciona todos os campos onde ra é igual a 0221024
SELECT * from Aluno WHERE ra <> 0221024; -- Seleciona todos os campos onde o ra é diferente de 0221024
SELECT * from Aluno WHERE ra >= 0221024; -- Seleciona todos os campos onde o ra é maior ou igual a 0221024
SELECT * from Aluno WHERE ra <= 0221024; -- Seleciona todos os campos onde o ra é menor ou igual a 0221024
SELECT * from Aluno WHERE ra != 0221024; -- Não recomendado, use <>
SELECT * from Aluno WHERE ra = 0221024; -- Seleciona todos os campos onde o ra é igual a 0221024
SELECT * from Aluno WHERE ra >= 0221024 and ra <=  0221036; -- Seleciona todos os campos onde o valor maior ou igual e menor ou igual
SELECT * FROM Aluno WHERE nome = 'João Vitor Sales'; -- Seleciona todos os campos onde todos os valores onde nome é 'João Vitor Sales'
SELECT * FROM Aluno WHERE bairro like 'jd%';  -- Seleciona todos os campos onde o bairro é 'jardim'
SELECT * FROM Aluno WHERE bairro like '_a%'; -- Seleciona todos os alunos onde a segunda letra do nome é a letra A
SELECT * FROM Aluno WHERE bairro like '___d%'; -- Seleciona todos os alunos onde a terceira letra do nome é a letra D
SELECT * FROM Aluno WHERE bairro like '___d%'; -- Seleciona todos os alunos onde a terceira letra do nome é a letra D
--  ......................
SELECT * FROM Aluno WHERE ra BETWEEN  0221003 AND 02221027; 
