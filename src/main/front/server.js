const express = require('express');
const app = express();

app.use(express.static(__dirname)); // Serve os arquivos estáticos da pasta atual

const port = process.env.PORT || 3000; // Porta em que o servidor será executado

app.listen(port, () => {
    console.log(`Servidor está rodando na porta ${port}`);
});
