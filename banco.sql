CREATE DATABASE db_projetointegrador;

CREATE TABLE usuario(
    id          	SERIAL PRIMARY KEY,
    nome        	VARCHAR(50) NOT NULL,
    login       	VARCHAR(15) NOT NULL,
    senha       		VARCHAR(32) NOT NULL
);

CREATE TABLE bem(
	id 				SERIAL PRIMARY KEY,
	nome 			VARCHAR(60) NOT NULL,
	dt_adiquicao 	DATE NOT NULL,
	valor_compra 	FLOAT NOT NULL,
	turno 			INT NOT NULL,
	vida_util 		FLOAT NOT NULL,
	dt_venda 		DATE,
	valor_venda 	FLOAT,
	usado 			FLOAT,
	valor_residual 	FLOAT,
	id_usuario  	INT NOT NULL REFERENCES usuario(id)
);