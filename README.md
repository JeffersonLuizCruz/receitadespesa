<h1 align="center">
    <img alt="Ecommerce" src="https://github.com/JeffersonLuizCruz/receitadespesa/blob/main/src/logo2.png" />
</h1>

<h3 align="center">
  REST API E-Commerce - BackEnd - Spring Boot
</h3>

<p align="center">Exemplo de um Sistema E-Commerce</p>

![GitHub repo size](https://img.shields.io/github/repo-size/JeffersonLuizCruz/financial)  ![Packagist License](https://img.shields.io/packagist/l/JeffersonLuizCruz/financial)  ![GitHub top language](https://img.shields.io/github/languages/top/JeffersonLuizCruz/financial)  ![GitHub language count](https://img.shields.io/github/languages/count/JeffersonLuizCruz/financial?label=Linguagem%20de%20Programa%C3%A7%C3%A3o)  ![GitHub followers](https://img.shields.io/github/followers/JeffersonLuizCruz?style=social)

<p align="center">
  <a href="#-sobre">Sobre o projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-diagrama">Diagrama de Classe</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-links">Links</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-contato">Contato</a>
</p>

## :page_with_curl: Sobre o projeto <a name="-sobre"/></a>

> Esse projeto consiste na criação de um núcleo base de uma aplicação de Controle Financeiro.

O sistema faz o registro do lançamento gasto ou da receita, com sua respectiva data do pagamento e data do vencimento. Na parte de lançamento ainda é possível inserir uma descrição e uma observação para o valor a ser lançado. Apenas o administrador é capaz de fazer qualquer alteração no sistema enquanto os usuários comuns têm acesso apenas de leitura. É obrigatório eu fazer um lançamento escolher qual categoria esse lançamento faz parte.


## :page_with_curl: Diagrama de Classe <a name="-diagrama"/></a>
<h1 align="center">
    <img alt="Ecommerce" src="https://github.com/JeffersonLuizCruz/financial/blob/main/src/main/resources/tamplates/Classe%20UML3.png" />
</h1>

## Tecnologia:
- [x] Java 11<br>
- [x] Spring Boot 2.4.4<br>
- [x] Spring Data - JPA/Hibernate<br>
- [x] Banco de Dados PostgreSQL<br>
- [ ] Spring Secutity - OAuth 2<br>
- [ ] Front-end Angular

## Construção do Projeto:
- [x] Criação de Interface Service (garantir baixo acoplamento)<br>
- [x] CRUD (ORM Hibernate - Ambiente de teste)<br>
- [x] DTO (Aplicação DTO na camada de Controller)
- [x] Exception Personalizado(Bad_Request; Not Found ...)
- [x] Consulta e Busca Paginada
- [ ] Autenticação e Autorização (JWT)



