CREATE TABLE IF NOT EXISTS Categoria(
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS Produto(
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) DEFAULT NULL,
	preco NUMERIC(12,2) DEFAULT NULL,
	idcategoria INT(11) DEFAULT NULL
) ENGINE=InnoDB CHARSET=utf8;

ALTER TABLE Produto ADD CONSTRAINT
fk_categoria_produto FOREIGN KEY(idcategoria)
REFERENCES Categoria(id);

INSERT INTO Categoria (nome) VALUES ('Jogos');
INSERT INTO Categoria (nome) VALUES ('Móveis');
INSERT INTO Categoria (nome) VALUES ('Brinquedos');

INSERT INTO Produto (nome, preco, idcategoria) VALUES ('God of War - PS4', '60.59', '1');
INSERT INTO Produto (nome, preco, idcategoria) VALUES ('Sofa Retrátil', '1727.90', '2');
INSERT INTO Produto (nome, preco, idcategoria) VALUES ('Max Steel', '99.99', '3');