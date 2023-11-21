<h1 align="center"> 🚗Leilão apenas tranqueiras🚗 </h1>
<p align="center">
<img alt="Static Badge" src="https://img.shields.io/badge/STATUS-CONCLU%C3%8DDO-green?style=for-the-badge">
</p>
<h2 align="left"> 📝 Descrição </h2>

Este projeto foi desenvolvido na <a href="https://www.usf.edu.br">Universidade São Franscisco</a> durante o 6º semestre de Engenharia da Computção na matéria de Programação Orientada a Objetos lecionada pelo <a href="https://github.com/matiasfilho81">Prof. José Matias Lemes Filho</a>. O projeto tem o intuito de realizar uma aplicação backend utilizando as operações "CRUD". O programa tem o objetivo de permitir o controle de dados dentro de um leilão de carros, permitindo com que a posse e venda de carros seja facilitada e de modo pratico, tendo informações essencias como: modelo, ano, estado e valor.

<br>

<h2 align="left">Como funciona?</h2>

[![Assista ao vídeo](https://miro.medium.com/v2/resize:fit:1400/1*vFiGOTV1S8yz0RTIQteTjw.png)](https://youtu.be/gu3DswypFjA)

<br>

## Tecnologias Utilizadas

- ``Java 11 ``
- ``Sprint Tools 4 ``
- ``Postman  ``

<h2 align="left"> Arquitetura</h2>
<h3>Entidades:</h3> 

- `Carros` 
   - Classe que representa os carros do leilão;
   - Possui os atributos id, modelo, ano, estado e valor
  
<h3>Controladores:</h3> 
<p>Mapeiam as requisições HTTP e definem métodos especificos para GET, POST, PUT e DELETE</p>

<h4>CarrosController:</h4>

   - `GET`
      - Endpoint: `/carros`
      - Exemplo de resposta:
      ```bash
      [
         {
             "id": 1,
             "modelo": "Civic",
             "ano": 2022,
             "estado": "Novo",
             "valor": 80000.00
         }
      ]
      ```

   - `POST`
     - Endpoint: `/carros`
     - Exemplo de entrada:
     ```bash
     [
        {
            "id": 11,
            "modelo": "Corolla",
            "ano": 2020,
            "estado": "Média-monta",
            "valor": 40000.00
        }
     ]
     ```
  
  - `PUT`
      - Endpoint: `/carros/{id}`
      - Exemplo de entrada:
      ```bash
      [
         {
             "id": 5,
             "modelo": "Civic",
             "ano": 2022,
             "estado": "Novo",
             "valor": 10000.00
         }
      ]
      ```

   - `DELETE`
     - Endpoint: `/carros/{id}`

<h3>Repositórios:</h3>

- `CarrosRepository`
<br>

<h2 align="left"> Funcionalidades</h2>

- `Funcionalidade 1` `Cadastro de Carros`: O programa permite o cadastro dos veiculos através do modelo e ano;
- `Funcionalidade 2` `Verificação de ano e valor`: O carros só sera cadastrado mediante a valores e anos compatíveis com o mesmo.


<br>

<h2 align="left"> Acesso ao projeto </h2>

- Clonar o Repositório <br>
  `git clone https://github.com/Souzinhax44/Leilao-de-carros.git`

<br>

<h2 align="left"> Autores </h2>

[<img loading="lazy" src="https://avatars.githubusercontent.com/u/146894035?v=4" width=115><br><sub>Pedro H. de Souza<br>RA: 202102523</sub>](https://github.com/Souzinhax44)

  
