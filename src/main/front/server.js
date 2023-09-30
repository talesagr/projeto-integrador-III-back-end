const express = require('express');
const app = express();
const fs = require("fs");

function readAndServe(path,res){
    fs.readFile(path, function (err, data){
        res.end(data)
    })
}

//app.use(express.static(__dirname)); // Serve os arquivos estáticos da pasta atual
app.get('/:id', function (req,res){
    console.log(req.params);

    if (req.params.id == "main")
        readAndServe("../main/main.html");
    else if (req.params.id == "editora")
        readAndServe("/editora/editora.html")
    else 
    res.end("Invalid Request")
});

const port = process.env.PORT || 3000; // Porta em que o servidor será executado

app.listen(port, () => {
    console.log(`Servidor está rodando na porta ${port}`);
});
