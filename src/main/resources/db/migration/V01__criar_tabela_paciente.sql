CREATE TABLE paciente(
	cpf BIGINT PRIMARY KEY,
	rg BIGINT,
	cns BIGINT,
	nome VARCHAR(255),
	endereco VARCHAR(255),
	numero_casa INTEGER,
	bairro VARCHAR(255),
	telefone_residencial VARCHAR(50),
	telefone_celular VARCHAR(50),
	data_nascimento DATE
);