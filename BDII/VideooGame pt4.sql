use dbVideoGame;

INSERT INTO TipoLocal (Descricao_TipoLocal) VALUES ('Residencial');
INSERT INTO TipoLocal (Descricao_TipoLocal) VALUES ('Comercial');
INSERT INTO TipoLocal (Descricao_TipoLocal) VALUES ('Pessoal');

INSERT INTO Jogos (Nome_Jogo, Descricao_Jogo, Genero_Jogo, Produtora_Jogo) 
VALUES ('Snoopy', 'Jogo de ação com cachorro, fases', 'Ação', 'Top Games Kids');
INSERT INTO Jogos (Nome_Jogo, Descricao_Jogo, Genero_Jogo, Produtora_Jogo) 
VALUES ('Super Mario', '', 'Ação', 'Top Games Kids');
INSERT INTO Jogos (Nome_Jogo, Descricao_Jogo, Genero_Jogo, Produtora_Jogo) 
VALUES ('Copa do Mundo 2010 - Africa do Sul', 'Competição futebolística', 'Futebol', 'Top Games Kids');
INSERT INTO Jogos (Nome_Jogo, Descricao_Jogo, Genero_Jogo, Produtora_Jogo) 
VALUES ('FIFA', 'Simulador do EA Sports', 'Futebol', 'Top Games Kids');
INSERT INTO Jogos (Nome_Jogo, Descricao_Jogo, Genero_Jogo, Produtora_Jogo) 
VALUES ('Homem Aranha', 'Versão TEEN', 'Ação', 'Top Games Kids');
INSERT INTO Jogos (Nome_Jogo, Descricao_Jogo, Genero_Jogo, Produtora_Jogo) 
VALUES ('LetsLearn', 'Jogo para praticar inglês', 'Educativo', 'Top Games Kids');
INSERT INTO Jogos (Nome_Jogo, Descricao_Jogo, Genero_Jogo, Produtora_Jogo) 
VALUES ('Capitão América', '', 'Ação', 'Top Games Kids');

INSERT INTO VideoGame (Modelo_VideoGame, NS_VideoGame) 
VALUES ('XBOX360', 'XB91054125');
INSERT INTO VideoGame (Modelo_VideoGame, NS_VideoGame) 
VALUES ('Playstation 3Slim', 'SO85E5689');
INSERT INTO VideoGame (Modelo_VideoGame, NS_VideoGame) 
VALUES ('Sony PSP', 'SOF582189');
INSERT INTO VideoGame (Modelo_VideoGame, NS_VideoGame) 
VALUES ('Sony PS Vita Wi-Fi Bundle', 'SOG782290');
INSERT INTO VideoGame (Modelo_VideoGame, NS_VideoGame) 
VALUES ('PlayStation 2 Slim', 'SO5A0999');
INSERT INTO VideoGame (Modelo_VideoGame, NS_VideoGame) 
VALUES ('Nintendo Wii', 'NINFF0051486');

INSERT INTO TipoPessoa (Descricao_TipoPessoa) VALUES ('Cliente');
INSERT INTO TipoPessoa (Descricao_TipoPessoa) VALUES ('Funcionário');

INSERT INTO Pessoal (TipoPessoa_idTipoPessoa, Nome_Pessoa, RG_Pessoa, CPF_Pessoa) 
VALUES (2, 'Alexandre Araújo', '3597848-9', '35765898777');
INSERT INTO Pessoal (TipoPessoa_idTipoPessoa, Nome_Pessoa, RG_Pessoa, CPF_Pessoa) 
VALUES (2, 'Giomar de Oliveira', '2657945-8', '26597520944');
INSERT INTO Pessoal (TipoPessoa_idTipoPessoa, Nome_Pessoa, RG_Pessoa, CPF_Pessoa) 
VALUES (1, 'Bruno Correa', '4875204-0', '35987489601');
INSERT INTO Pessoal (TipoPessoa_idTipoPessoa, Nome_Pessoa, RG_Pessoa, CPF_Pessoa) 
VALUES (1, 'Jonathan Almeida', '3978459-9', '39874548407');
INSERT INTO Pessoal (TipoPessoa_idTipoPessoa, Nome_Pessoa, RG_Pessoa, CPF_Pessoa) 
VALUES (2, 'Ricardo Lopes', '4587457-1', '29874587915');

INSERT INTO Cliente (Pessoa_idPessoa, Pai_Cliente, Mae_Cliente, Nick_Cliente, Senha_Cliente) 
VALUES (3, '', '', 'bcorrea', '159874');
INSERT INTO Cliente (Pessoa_idPessoa, Pai_Cliente, Mae_Cliente, Nick_Cliente, Senha_Cliente) 
VALUES (4, '', '', 'jalmeida', '854789');

INSERT INTO Funcionario (Pessoa_idPessoa, Sexo, Idade) 
VALUES (1, 'M', 22);
INSERT INTO Funcionario (Pessoa_idPessoa, Sexo, Idade) 
VALUES (2, 'M', 19);
INSERT INTO Funcionario (Pessoa_idPessoa, Sexo, Idade) 
VALUES (5, 'F', 19);

INSERT INTO Contato (TipoLocal_idTipoLocal, Pessoa_idPessoa, Telefone_Contato, Mail_Contato) 
VALUES (3, 1, '1156662008', 'aaraujo@ig.com.br');
INSERT INTO Contato (TipoLocal_idTipoLocal, Pessoa_idPessoa, Telefone_Contato, Mail_Contato) 
VALUES (1, 1, '1156691587', 'alearaujo@uol.com.br');
INSERT INTO Contato (TipoLocal_idTipoLocal, Pessoa_idPessoa, Telefone_Contato, Mail_Contato) 
VALUES (3, 2, '1156698877', 'goliveira@terra.com.br');
INSERT INTO Contato (TipoLocal_idTipoLocal, Pessoa_idPessoa, Telefone_Contato, Mail_Contato) 
VALUES (3, 3, '11998770028', 'bcorrea@ig.com.br');
INSERT INTO Contato (TipoLocal_idTipoLocal, Pessoa_idPessoa, Telefone_Contato, Mail_Contato) 
VALUES (3, 4, '11998887900', 'jalmeida@bol.com.br');
INSERT INTO Contato (TipoLocal_idTipoLocal, Pessoa_idPessoa, Telefone_Contato, Mail_Contato) 
VALUES (3, 5, '1156637895', 'rlopes@hotmail.com.br');

INSERT INTO Endereco (TipoLocal_idTipoLocal, Pessoa_idPessoa, Logradouro_Endereco, Numero_Endereco, Complemento_Endereco, Bairro_Endereco, CEP_Endereco, Cidade_Endereco, Estado_Endereco) 
VALUES (3, 1, 'Rua Demonte Risco', 220, '', 'Interlagos', '04814-578', 'São Paulo', 'SP');
INSERT INTO Endereco (TipoLocal_idTipoLocal, Pessoa_idPessoa, Logradouro_Endereco, Numero_Endereco, Complemento_Endereco, Bairro_Endereco, CEP_Endereco, Cidade_Endereco, Estado_Endereco) 
VALUES (3, 2, 'Rua Nascimento de Moraes', 51, '', 'Grajaú', '04922-510', 'São Paulo', 'SP');
INSERT INTO Endereco (TipoLocal_idTipoLocal, Pessoa_idPessoa, Logradouro_Endereco, Numero_Endereco, Complemento_Endereco, Bairro_Endereco, CEP_Endereco, Cidade_Endereco, Estado_Endereco) 
VALUES (3, 3, 'Praça Montes Claros', 15, 'A', 'Progresso', '04914-000', 'São Paulo', 'SP');
INSERT INTO Endereco (TipoLocal_idTipoLocal, Pessoa_idPessoa, Logradouro_Endereco, Numero_Endereco, Complemento_Endereco, Bairro_Endereco, CEP_Endereco, Cidade_Endereco, Estado_Endereco) 
VALUES (3, 4, 'Av. Primavera', 1010, '', 'Primavera', '04010-100', 'São Paulo', 'SP');
INSERT INTO Endereco (TipoLocal_idTipoLocal, Pessoa_idPessoa, Logradouro_Endereco, Numero_Endereco, Complemento_Endereco, Bairro_Endereco, CEP_Endereco, Cidade_Endereco, Estado_Endereco) 
VALUES (3, 5, 'Rua Marinez', 2, '', 'Orion', '04878-879', 'São Paulo', 'SP');

INSERT INTO Aluguel (Funcionario_idFuncionario, VideoGame_idVideoGame, Cliente_idCliente, Jogos_idJogos, Valor_Aluguel, Data_Aluguel) 
VALUES (3, 6, 1, 3, '17.86', '20-01-2004');
INSERT INTO Aluguel (Funcionario_idFuncionario, VideoGame_idVideoGame, Cliente_idCliente, Jogos_idJogos, Valor_Aluguel, Data_Aluguel) 
VALUES (3, 6, 1, 3, '17.86', '09-01-2013');
INSERT INTO Aluguel (Funcionario_idFuncionario, VideoGame_idVideoGame, Cliente_idCliente, Jogos_idJogos, Valor_Aluguel, Data_Aluguel) 
VALUES (3, 6, 1, 3, '17.86', '04-01-2013');
INSERT INTO Aluguel (Funcionario_idFuncionario, VideoGame_idVideoGame, Cliente_idCliente, Jogos_idJogos, Valor_Aluguel, Data_Aluguel) 
VALUES (1, 1, 2, 1, '19.5', '03-03-2013');