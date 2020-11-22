CREATE TABLE TipoPessoa (
	idTipoPessoa INTEGER,
	Descricao_TipoPessoa VARCHAR(20),
	PRIMARY KEY(idTipoPessoa),
);

CREATE TABLE Pessoa (
	idPessoa INTEGER,
	TipoPessoa_id INTEGER,
	Nome_Pessoa VARCHAR(80),
	RG_Pessoa VARCHAR(10),
	CPF_Pessoa VARCHAR(14),
	PRIMARY KEY(idPessoa),
);

CREATE TABLE TipoLocal (
	idTipoLocal INTEGER,
	Descricao_TipoLocal VARCHAR(30),
	PRIMARY KEY(idTipoLocal),
);

CREATE TABLE Contato (
	idContato INTEGER,
	TipoLocal_id INTEGER,
	Pessoa_id INTEGER,
	Telefone_Contato VARCHAR(13),
	Mail_Contato VARCHAR(30),
	PRIMARY KEY(idContato),
);

CREATE TABLE Endereco (
	idEndereco INTEGER,
	TipoLocal_id INTEGER,
	Pessoa_id INTEGER,
	Logradouro_Endereco VARCHAR(70),
	Numero_Endereco INTEGER,
	Complemento_Endereco VARCHAR(100),
	Bairro_Endereco INTEGER,
	CEP_Endereco VARCHAR(9),
	Cidade_Endereco VARCHAR(30),
	Estado_Endereco CHAR(2),
	PRIMARY KEY(idEndereco),
);

CREATE TABLE Cliente (
	idCliente INTEGER,
	Pessoa_id INTEGER,
	Pai_Cliente VARCHAR(80),
	Mae_Cliente VARCHAR(80),
	Nick_Cliente VARCHAR(12),
	Senha_Cliente VARCHAR(8),
	PRIMARY KEY(idCliente),
);

CREATE TABLE Funcionario (
	idFuncionario INTEGER,
	Pessoa_id INTEGER,
	Sexo CHAR(1),
	Idade INTEGER,
	PRIMARY KEY(idFuncionario),
);

CREATE TABLE Jogos (
	idJogos INTEGER,
	Nome_Jogo VARCHAR(30),
	Descricao_Jogo VARCHAR(120),
	Genero_Jogo VARCHAR(20),
	Produtora_Jogo VARCHAR(40),
	PRIMARY KEY(idJogos),
);

CREATE TABLE VideoGame (
	idVideoGame INTEGER,
	Modelo_VideoGame VARCHAR(20),
	NS_VideoGame VARCHAR(24),
	PRIMARY KEY(idVideoGame),
);

CREATE TABLE Aluguel (
	idAluguel INTEGER,
	Funcionario_id INTEGER,
	VideoGame_id INTEGER,
	Jogos_idJogos INTEGER,
	Valor_Aluguel REAL,
	Data_Aluguel DATE,
	PRIMARY KEY(idAluguel),
);
