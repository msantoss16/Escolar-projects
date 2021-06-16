module.exports = () => {
    const Produto = require('../models/produto');
    const controller = {};

    controller.obterProdutos = async (req, res) => {
        const produtos = await Produto.findAll();
        return res.status(200).send(produtos);
    };

    controller.obterProduto = async (req, res) => {
        const produto = await Produto.findByPk(req.params.codigo);
        return res.status(200).send(produto);
    };

    controller.criarProduto = async (req, res) => {
        try {
            let {nome, quantidade, preco, descricao, imagem} = req.body;
            const resultadoCreate = await Produto.create({
                nome,
                quantidade,
                preco,
                descricao,
                imagem
            });
            if (resultadoCreate) {
                return res.status(200).send(resultadoCreate);
            } else {
                return res.sendStatus(401);
            }
        } catch (err) {
            console.log(err);
            return res.sendStatus(401);
        }
    };

    controller.atualizarProduto = async (req, res) => {
        let {nome, quantidade, preco, descricao, imagem} = req.body;
        const produto = await Produto.findByPk(req.params.codigo);
        produto.nome = nome;
        produto.quantidade = quantidade;
        produto.preco = preco;
        produto.descricao = descricao;
        produto.imagem = imagem;
        try {
            const resultadoSave = await produto.save();
            return res.status(200).send(resultadoSave);
        } catch (err) {
            console.log(err);
            return res.sendStatus(400);
        };
    };

    controller.deletarProduto = async (req, res) => {
        const produto = await Produto.findByPk(req.params.codigo);
        produto.destroy();
        return res.sendStatus(200);
    };

    return controller;
};