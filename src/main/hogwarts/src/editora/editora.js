const apiUrl = 'http://localhost:8080/api/editora';
const editoraInput = document.getElementById('editoraInput');
const cadastrarButton = document.querySelector('.buttonedit');
let ultimoID = null;

document.addEventListener('DOMContentLoaded', function () {
    axios.get(apiUrl + '/ultimoID')
        .then(function (response) {

            ultimoID = response.data;
            console.log(ultimoID);

            if (ultimoID !== null) {
                editoraInput.value = `Editora ${ultimoID + 1}`;
            }

            cadastrarButton.addEventListener('click', function () {
                const descricaoEditora = editoraInput.value;

                if (descricaoEditora.trim() === '') {
                    alert('Por favor, insira a descrição da editora.');
                    return;
                }

                const novaEditora = {
                    id : ultimoID,
                    descricao: descricaoEditora
                };

                axios.post(apiUrl, novaEditora)
                    .then(function (response) {

                        console.log('Dados da resposta:', response.data);

                        editoraInput.value = '';

                        atualizarListaEditoras();
                    })
                    .catch(function (error) {
                        console.error('Deu xablau:', error);
                    });
            });

            atualizarListaEditoras();
        })
        .catch(function (error) {
            console.error('Erro ao obter o último ID:', error);
        });

    function atualizarListaEditoras() {
        axios.get(apiUrl)
            .then(function (response) {

                console.log('Dados da resposta:', response.data);

                const table = document.querySelector('.editora-table');

                const tableHTML = `
                    <h2>Editoras</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Descrição</th>
                            </tr>
                        </thead>
                        <tbody>
                            ${response.data.map(item => `
                                <tr>
                                    <td>${item.editoraoid}</td>
                                    <td>${item.descricao}</td>
                                </tr>
                            `).join('')}
                        </tbody>
                    </table>
                `;

                const rightSection = document.querySelector('.right-section');
                rightSection.innerHTML = tableHTML;
            })
            .catch(function (error) {
                console.error('Deu xablau:', error);
            });
    }
});
