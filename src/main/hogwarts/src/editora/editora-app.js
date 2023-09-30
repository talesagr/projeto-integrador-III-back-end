import React, { Component } from 'react';
import axios from 'axios';
import './editora.css'; // Importe seu arquivo CSS aqui

class Editora extends Component {
  constructor() {
    super();
    this.state = {
      editora: '',
      ultimoID: null,
      editoras: [],
    };
  }

  componentDidMount() {
    const apiUrl = 'http://localhost:8080/api/editora';

    axios.get(apiUrl + '/ultimoID')
      .then((response) => {
        const ultimoID = response.data;
        console.log(ultimoID);

        if (ultimoID !== null) {
          this.setState({ editora: `Editora ${ultimoID + 1}`, ultimoID });
        }

        this.atualizarListaEditoras();
      })
      .catch((error) => {
        console.error('Erro ao obter o último ID:', error);
      });
  }

  handleEditoraChange(event) {
    this.setState({ editora: event.target.value });
  }

  cadastrarEditora() {
    const { editora, ultimoID } = this.state;
    const apiUrl = 'http://localhost:8080/api/editora';
    const descricaoEditora = editora.trim();

    if (descricaoEditora === '') {
      alert('Por favor, insira a descrição da editora.');
      return;
    }

    const novaEditora = {
      id: ultimoID,
      descricao: descricaoEditora,
    };

    axios.post(apiUrl, novaEditora)
      .then((response) => {
        console.log('Dados da resposta:', response.data);
        this.setState({ editora: '' });
        this.atualizarListaEditoras();
      })
      .catch((error) => {
        console.error('Deu xablau:', error);
      });
  }

  atualizarListaEditoras() {
    const apiUrl = 'http://localhost:8080/api/editora';

    axios.get(apiUrl)
      .then((response) => {
        console.log('Dados da resposta:', response.data);
        this.setState({ editoras: response.data });
      })
      .catch((error) => {
        console.error('Deu xablau:', error);
      });
  }

  render() {
    return (
      <div>
        <header className="header">
          <div>
            <img className="headerIcon" src="imagens/2730324_colour_feather_harry_potter_quill_icon 1.png" alt="Ícone do cabeçalho" />
          </div>
          <h1 className="bannerEscrita">Biblioteca Hogwarts</h1>
          <div className="sidebar" id="sidebar">
            <div className="toggle-btn" onClick={this.toggleSidebar}>
              <img src="imagens/134216_menu_lines_hamburger_icon - Copia 1.png" alt="Abrir/Fechar" />
            </div>
            <ul className="menuList">
              <div>
                <li><a className="menuItens" href="#">Cadastrar</a></li>
              </div>
              <li><a className="menuItens" href="#">Retiradas ou Devoluções</a></li>
              <li><a className="menuItens" href="#">Consultas</a></li>
            </ul>
          </div>
        </header>
        <div className="main-container">
          <div className="left-section">
            <div className="form-container">
              <div className="textdiv">Nova Editora</div>
              <div className="inputedit">
                Editora
                <input
                  id="editoraInput"
                  className="texteditora"
                  type="text"
                  value={this.state.editora}
                  onChange={(event) => this.handleEditoraChange(event)}
                />
              </div>
              <div className="buttondiv">
                <button className="buttonedit" onClick={() => this.cadastrarEditora()}>
                  Cadastrar
                </button>
              </div>
            </div>
          </div>
          <div className="right-section">
            <div className="scrollable-content">
              <h2>Editoras</h2>
              <table>
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                  </tr>
                </thead>
                <tbody>
                  {this.state.editoras.map((item) => (
                    <tr key={item.editoraoid}>
                      <td>{item.editoraoid}</td>
                      <td>{item.descricao}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Editora;
