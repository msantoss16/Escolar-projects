CREATE TABLE TipoPessoa (
	idTipoPessoa INT NOT NULL IDENTITY,
	Descricao_TipoPessoa VARCHAR(20),
	PRIMARY KEY(idTipoPessoa),
);

CREATE TABLE Pessoa (
	idPessoa INT NOT NULL IDENTITY,
	TipoPessoa_id INT NOT NULL,
	Nome_Pessoa VARCHAR(80) NOT NULL,
	RG_Pessoa VARCHAR(10) NOT NULL UNIQUE,
	CPF_Pessoa VARCHAR(14) NOT NULL UNIQUE,
	PRIMARY KEY(idPessoa),
);

CREATE TABLE TipoLocal (
	idTipoLocal INT NOT NULL IDENTITY,
	Descricao_TipoLocal VARCHAR(30),
	PRIMARY KEY(idTipoLocal),
);

CREATE TABLE Contato (
	idContato INT NOT NULL IDENTITY,
	TipoLocal_id INT NOT NULL,
	Pessoa_id INT NOT NULL IDENTITY,
	Telefone_Contato VARCHAR(13) NOT NULL,
	Mail_Contato VARCHAR(30),
	PRIMARY KEY(idContato),
);

CREATE TABLE Endereco (
	idEndereco INT NOT NULL IDENTITY,
	TipoLocal_id INT NOT NULL,
	Pessoa_id INT NOT NULL,
	Logradouro_Endereco VARCHAR(70) NOT NULL,
	Numero_Endereco INT NOT NULL,
	Complemento_Endereco VARCHAR(100),
	Bairro_Endereco INT NOT NULL,
	CEP_Endereco VARCHAR(9) NOT NULL,
	Cidade_Endereco VARCHAR(30) NOT NULL,
	Estado_Endereco CHAR(2)NOT NULL,
	PRIMARY KEY(idEndereco),
);

CREATE TABLE Cliente (
	idCliente INT NOT NULL IDENTITY,
	Pessoa_id INT NOT NULL,
	Pai_Cliente VARCHAR(80),
	Mae_Cliente VARCHAR(80) NOT NULL,
	Nick_Cliente VARCHAR(12) UNIQUE NOT NULL,
	Senha_Cliente VARCHAR(8) NOT NULL,
	PRIMARY KEY(idCliente),
);

CREATE TABLE Funcionario (
	idFuncionario INT NOT NULL IDENTITY,
	Pessoa_id INT NOT NULL,
	Sexo CHAR(1) NOT NULL,
	Idade INT NOT NULL,
	PRIMARY KEY(idFuncionario),
);

CREATE TABLE Jogos (
	idJogos INT NOT NULL IDENTITY,
	Nome_Jogo VARCHAR(30) NOT NULL,
	Descricao_Jogo VARCHAR(120),
	Genero_Jogo VARCHAR(20) NOT NULL,
	Produtora_Jogo VARCHAR(40) NOT NULL,
	PRIMARY KEY(idJogos),
);

CREATE TABLE VideoGame (
	idVideoGame INT NOT NULL IDENTITY,
	Modelo_VideoGame VARCHAR(20) NOT NULL,
	NS_VideoGame VARCHAR(24) NOT NULL,
	PRIMARY KEY(idVideoGame),
);

CREATE TABLE Aluguel (
	idAluguel INT NOT NULL IDENTITY,
	Funcionario_id INT NOT NULL,
	VideoGame_id INT NOT NULL,
	Jogos_idJogos INT NOT NULL,
	Valor_Aluguel REAL NOT NULL,
	Data_Aluguel DATE NOT NULL,
	PRIMARY KEY(idAluguel),
);
