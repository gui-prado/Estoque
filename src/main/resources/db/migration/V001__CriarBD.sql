CREATE TABLE IF NOT EXISTS Categoria(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
) ENGINE=InnoDB CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS Produto(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	preco NUMERIC(12,2) NOT NULL,
	idcategoria INT NOT NULL
) ENGINE=InnoDB CHARSET=UTF8;

ALTER TABLE Produto ADD CONSTRAINT
fk_categoria_produto FOREIGN KEY(idcategoria)
REFERENCES Categoria(id);

INSERT INTO Categoria (nome) VALUES ('Jogos');
INSERT INTO Categoria (nome) VALUES ('Móveis');
INSERT INTO Categoria (nome) VALUES ('Brinquedos');

INSERT INTO Produto (nome, preco, idcategoria) VALUES ('God of War - PS4', '60.59', '1');
INSERT INTO Produto (nome, preco, idcategoria) VALUES ('Sofa Retrátil', '1727.90', '2');
INSERT INTO Produto (nome, preco, idcategoria) VALUES ('Max Steel', '99.99', '3');