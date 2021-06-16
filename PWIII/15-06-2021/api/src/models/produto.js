const database = require('../config/db');
 
const Produto = database.define('produto', {
    codigo: {
        type: database.Sequelize.INTEGER,
        autoIncrement: true,
        allowNull: false,
        primaryKey: true
    },
    nome: {
        type: database.Sequelize.STRING,
        allowNull: false
    },
    quantidade: {
        type: database.Sequelize.INTEGER,
        defaultValue: 1
    },
    preco: {
        type: database.Sequelize.DOUBLE
    },
    descricao: database.Sequelize.STRING,
    imagem: database.Sequelize.STRING,
})
 
module.exports = Produto;