module.exports = app => {
    var multer = require('multer');
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

        var upload = multer({ dest: 'uploads/images/' })

    app.route('/upload')
        .post(upload.single('image'), produto.sendFile);

    app.route('/uploads/images/:path')
        .get(produto.obterImagem);
};
