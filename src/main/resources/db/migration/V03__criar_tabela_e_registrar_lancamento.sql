CREATE TABLE lancamento (
	codigo BIGSERIAL PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL,
	data_vencimento DATE NOT NULL,
	data_pagamento DATE,
	complemento VARCHAR(30),
	valor DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(50),
	tipo VARCHAR(20) NOT NULL,
	codigo_categoria BIGSERIAL NOT NULL,
	codigo_pessoa BIGSERIAL NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)
);
