INSERT INTO VENDEDOR (codigo_vendedor, nome_vendedor, salario_fixo, faixa_comissao) values
 (209, 'José', 1.800.00, 'c' ),
 (111, 'Carlos', 2.490.00, 'a' ),
 (11, 'João', 2.780.00, 'c' ),
 (240, 'Antônio', 9.500.00, 'c' ),
 (720, 'Felipe', 4.600.00, 'a' ),
 (213, 'Jonas', 870.00, 'a' ),
 (101, 'João', 2.300.00, 'c' ),
 (310, 'Josias', 2.650.00, 'b' ),
 (250, 'Maurício', 2.930.00, 'b' )

 select * from VENDEDOR;

 INSERT INTO PEDIDO (num_pedido, prazo_entrega, codigo_cliente, codigo_vendedor) values
 (121, 20, 410, 209),
 (97,  20, 720, 101),
 (101, 15, 720, 101),
 (137, 20, 720, 720),
 (148, 20, 720, 101),
 (189, 15, 870, 213),
 (104, 30, 110, 101),
 (203, 30, 830, 250),
 (98, 20, 410, 209),
 (143, 30, 20, 111),
 (105, 15, 180, 240),
 (111, 20, 260, 240),
 (103, 20, 260, 11),
 (91, 20, 260, 11),
 (138, 20, 260, 11),
 (108, 15, 290, 310),
 (119, 30, 390, 250),
 (127, 10, 410, 11)

 select * from PEDIDO;

INSERT INTO ITEM_DO_PEDIDO (num_pedido, codigo_produto, quantidade_decimal) values
(121, 25, 10),
(121, 31, 35),
(97,  77, 20),
(101, 31, 9),
(101, 78, 18),
(101, 13, 5),
(98,  77, 5),
(148, 45, 8),
(148, 31, 7),
(148, 77, 3),
(148, 25, 10),
(148, 78, 30),
(104, 53, 32),
(203, 31, 6),
(189, 78, 45),
(143, 31, 20),
(143, 78, 10),
(105, 78, 10),
(111, 25, 10),
(111, 78, 70),
(103, 53, 37),
(91,  77, 40),
(138,  22, 10),
(138,  77, 35),
(138,  53, 18),
(108,  13, 17),
(119,  77, 40),
(119,  13, 6),
(119,  22, 10),
(119,  53, 43),
(137,  13, 8)

select * from ITEM_DO_PEDIDO;

INSERT INTO PRODUTO (codigo_produto, unidade, descricao_produto, val_unit) values
(25, 'Kg', 'Queijo', 0.97),
(31, 'BAR', 'Chocolate', 0.87),
(78, 'L', 'Vinho', 0.97),
(22, 'M', 'Linho', 0.11),
(30, 'SAC', 'açúcar', 0.30),
(53, 'M', 'Linha', 1.80),
(13, 'G', 'Ouro', 6.18),
(45, 'M', 'Madeira', 0.25),
(87, 'M', 'Cano', 1.97),
(77, 'M', 'Pepel', 1.05)

select * from PRODUTO;

INSERT INTO CLIENTE (codigo_cliente, nome_cliente, endereco, cidade, cep, uf, cnpj, ie) values
(720, 'Ana', 'Rua 17 n. 19', 'Niterói', 24358310, 'RJ', '12113231/001-34', 2134),
(870, 'Flávio', 'Av. Pres. Vargas 10', 'São Paulo', 24212310, 'SP', '12113231/001-34', 2134),
(110, 'Jorge', 'Rua Caiapo 13', 'Curitiba', 24432310, 'PR', '12113231/001-34', 2134),
(222, 'Lúcia', 'Rua Itabira 123 Loja 9', 'Belo Horizonte', 44328310, 'MG', '12113231/001-34', 2134),
(830, 'Maurício', 'Av. Paulista 1236 sl/2145', 'Salvador', 54358310, 'BA', '12113231/001-34', 2134),
(130, 'Edmar', 'Rua da Praia sn/', 'Salvador', 14354310, 'BA', '12113231/001-34', 2134),
(410, 'Rodolfo', 'Largo da Lapa 27 sobrabo', 'Rio de Janeiro', 24358310, 'RJ', '12113231/001-34', 2134),
(20, 'Beth', 'Av. Climério n75', 'São Paulo', 24358530, 'SP', '12113231/001-34', 2134),
(157, 'Paulo', 'Tv. Moraes c/3', 'Londrina', 35358310, 'PR', '12113231/001-34', 2134),
(180, 'Lívio', 'Av. Beira Mar n135', 'Florianópolis', 12358310, 'SC', '12113231/001-34', 2134),
(260, 'Suzana', 'Rua Lopez Mendes 12', 'Niterói', 86358310, 'RJ', '12113231/001-34', 2134),
(290, 'Renato', 'Rua Meireles n123', 'São Paulo', 65358310, 'SP', '12113231/001-34', 2134),
(390, 'Sebastião', 'Rua da Ogreja n10', 'Uberaba', 04358310, 'MG', '12113231/001-34', 2134),
(231, 'Jesé', 'Quadra 3 bl 3 sl 1003', 'Brasília', 12338310, 'DF', '12113231/001-34', 2134)

select * from Cliente;