CREATE DATABASE N2QUARKUS;

USE N2QUARKUS;

CREATE TABLE Produto (
                codigo_produto BIGINT IDENTITY NOT NULL,
                nome VARCHAR(80) NOT NULL,
                categoria VARCHAR(80) NOT NULL,
                ean VARCHAR(13) NOT NULL,
                data_validade DATE NOT NULL,
                CONSTRAINT codigo_produto PRIMARY KEY (codigo_produto)
)

INSERT INTO Produto (nome, categoria, ean, data_validade) VALUES ('PÃO', 'ALIMENTO', '1234567891234', '2023-08-12');

SELECT * FROM PRODUTO;

CREATE TABLE Orcamento (
                codigo_orcamento BIGINT IDENTITY NOT NULL,
                dt DATE NOT NULL,
                data_validade DATE NOT NULL,
                valor DECIMAL(7,2) NOT NULL,
                CONSTRAINT codigo_orcamento PRIMARY KEY (codigo_orcamento)
)

CREATE TABLE Pedido (
                codigo_pedido BIGINT IDENTITY NOT NULL,
                codigo_orcamento BIGINT NOT NULL,
                data_emissao DATE NOT NULL,
                cliente VARCHAR(100) NOT NULL,
                CONSTRAINT codiigo_pedido PRIMARY KEY (codigo_pedido, codigo_orcamento)
)

ALTER TABLE Pedido ADD CONSTRAINT Orcamento_codigo_pedido_fk
FOREIGN KEY (codigo_orcamento)
REFERENCES Orcamento (codigo_orcamento)
ON DELETE NO ACTION
ON UPDATE NO ACTION


INSERT INTO Orcamento (dt, data_validade, valor) VALUES ('2023-06-09', '2024-06-09', 1000.00)
INSERT INTO Orcamento (dt, data_validade, valor) VALUES ('2023-07-01', '2025-07-01', 1000.00)
INSERT INTO Orcamento (dt, data_validade, valor) VALUES ('2023-08-01', '2024-06-09', 2000.00)



INSERT INTO Pedido (codigo_orcamento, data_emissao, cliente) VALUES (1,'2023-06-09', 'Cesar' )
INSERT INTO Pedido (codigo_orcamento, data_emissao, cliente) VALUES (2,'2023-06-09', 'Jorge' )

