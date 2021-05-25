CREATE DATABASE  apicrudphp;

USE  apicrudphp;

CREATE TABLE IF NOT EXISTS tbFuncionarios (
codigo int NOT NULL AUTO_INCREMENT,
nome varchar(255) NOT NULL,
email varchar(50),
cargo varchar(255) NOT NULL,
data_entrada datetime NOT NULL,
PRIMARY KEY (codigo)
);

INSERT INTO tbFuncionarios (nome,email,cargo,data_entrada) VALUES
('João Antonio', 'joao.antonio@gmail.com', 'Programador', '2020-06-01 02:12:30'),
('David Costa', 'david.costa@yahoo.com', 'Designer', '2019-03-03 01:20:10'),
('Marcio Miranda', 'marcio.miranda@gmail.com', 'Administrador', '2018-09-20 03:10:25'),
('Anderson Lira', 'andreson.lira@yahoo.com', 'Gerente financeiro', '2018-04-11 04:11:12'),
('Matheus Jesus', 'matheus.jesus@gmail.com', 'Chefe de segurança', '2019-01-04 05:20:30'),
('Alan Turin', 'alan.turin@hotmail.com', 'Suporte técnico', '2020-01-10 06:40:10'),
('Joyce Melissa', 'joyce.melissa@yahoo.com', 'Gerente de planejamento', '2019-05-02 02:20:30'),
('Andre Gonçalves', 'andre.goncalves@yahoo.com', 'Engenheiro de software', '2018-01-04 05:15:35'),
('Alexandre Tornado', 'alexandre.tornado@hotmail.com', 'Analista de sistemas', '2019-01-02 02:20:30'),
('Joel da Silva', 'joel.silva@hotmail.com', 'Ciêntista da computação', '2020-02-01 06:22:50');