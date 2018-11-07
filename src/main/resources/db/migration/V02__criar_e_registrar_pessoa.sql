CREATE TABLE PESSOA (
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
ativo TINYINT(1) NOT NULL,
logradouro VARCHAR(50),
numero VARCHAR(4),
complemento VARCHAR(25),
bairro VARCHAR(50),
cep VARCHAR(8),
cidade VARCHAR(50),
estado VARCHAR(2)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO PESSOA (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ('José',1,'Rua dos Santos','219','','Jd. Santo Antônio','06542000','São José dos Campos','SP');
INSERT INTO PESSOA (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) values ('Maria',0,'Rua dos Santos','351','','Vila Nova','06542100','Osasco','SP');
INSERT INTO PESSOA (nome,ativo) values ('Kenshin Himura',1);
INSERT INTO PESSOA (nome,ativo) values ('Satoshi Ozono',1);
INSERT INTO PESSOA (nome,ativo) values ('Eichiro Oda',1);
INSERT INTO PESSOA (nome,ativo) values ('Akira Toriyama',1);
INSERT INTO PESSOA (nome,ativo) values ('James Holigan',0);
INSERT INTO PESSOA (nome,ativo) values ('Larissa da Silva',0);
INSERT INTO PESSOA (nome,ativo) values ('Gabriel Leite',0);
INSERT INTO PESSOA (nome,ativo) values ('Marcio Guerreiro',1);