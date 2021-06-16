const express = require('express');
const cors = require('cors');

module.exports = () => {
    const app = express();
    
    app.use((req, res, next) => {
        //Qual site tem permissão de realizar a conexão, no exemplo abaixo está o "*" indicando que qualquer site pode fazer a conexão
        res.header("Access-Control-Allow-Origin", "*");
        //Quais são os métodos que a conexão pode realizar na API
        res.header("Access-Control-Allow-Methods", 'GET,PUT,POST,DELETE');
        app.use(cors());
        next();
    });

    app.use(express.json())
    require('../routes/index')(app);
    return app;
};