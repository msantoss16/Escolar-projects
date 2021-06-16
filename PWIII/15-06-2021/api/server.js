const PORT = process.env.PORT || 5000
(async () => {
    const database = require('./src/config/db');
 
    try {
        const resultado = await database.sync();
        //console.log(resultado);
    } catch (error) {
        console.log(error);
    }
})();

const app = require('./src/config/custom-express')();

app.listen(PORT, () => {
    console.log(`Servidor rodando na porta ${PORT}`);
});

app.get('/', (req, res) => {
    res.send(`
        <html>
            <head>
                <meta charset="utf-8">
            </head>
            <body>
                <h1>Rota padrão</h1>
                <h3>Desenvolvido por Matheus Augusto - 3H</h3>
            </body>
        </html>
    `);
});

