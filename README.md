<h1 align="center">
    <img alt="Ecommerce" src="https://github.com/JeffersonLuizCruz/financial/blob/main/src/main/resources/tamplates/ecommerce.png" />
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

> É proposto o desenvolvimento de um Sistema de E-Commerce, que vai informatizar as funções de pedido, pagamento e forma de pagamento: boleto ou cartão.

O sistema deve permitir o cadastro de pelo menos um administrador do sistema. Este terá a
responsabilidade sobre todas as inclusões e alterações que serão feitas na aplicação. O e-commerce deve possibilitar o cadastramento dos clientes além dos dados essenciais para efetuar uma compra. Ao efetuar o pedido, adicionando os itens e quantidade, o cliente poderá optar a forma de pagamento a ser utilizada(Boleto ou Cartão de Crédito e suas parcelas). A compra só será confirmada a partir do momento em que for validada a forma de pagamento.

## Caso de Uso - Registro de um Pedido

### O cliente seleciona um produto para adicionar ao carrinho de compras:
Quando um produto já existente no carrinho é selecionado, a quantidade deste produto no carrinho deve ser incrementada, caso contrário o produto é devolvido ao carrinho com quantidade 1.

### O sistema exibe o carrinho de compras:
As informações do carrinho de compras são: nome, quantidade e preço unitário de cada produto (não será dado desconto), o subtotal de cada item do carrinho, e o valor total do carrinho.

### O sistema informa a confirmação do pedido:
As informações da confirmação do pedido são: número, data e horário do pedido,valor total do pedido,bem como o tipo e estado do pagamento (Pendente). Caso o pagamento seja com boleto, informar a data de vencimento, e caso o pagamento seja com cartão, informar o número de parcelas.


## :page_with_curl: Diagrama de Classe <a name="-diagrama"/></a>
<h1 align="center">
    <img alt="Ecommerce" src="https://github.com/JeffersonLuizCruz/receitadespesa/blob/main/src/uml5.png" />
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



