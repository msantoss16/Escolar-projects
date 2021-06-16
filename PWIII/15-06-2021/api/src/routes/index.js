module.exports = app => {
    const produto = require('../controllers/produto')();

    app.route('/produtos')
        .get(produto.obterProdutos);

    app.route('/produtos/:codigo')
        .get(produto.obterProduto);

    app.route('/produtos')
        .post(produto.criarProduto);

    app.route('/produtos/:codigo')
        .put(produto.atualizarProduto);

    app.route('/produtos/:codigo')
        .delete(produto.deletarProduto);
};
