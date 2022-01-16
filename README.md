# Controle de Finanças 

  

Projeto para Controle de Finanças com o conceito de uma REST API, desenvolvida utilizando Spring Boot, Spring Data JPA, Swagger com banco de dados MySQL. Este projeto faz parte e um desafio da Pub Future onde foco é testar os conhecimentos em back-end.  

  

## Ferramentas para o Desenvolvimento 

  

1. IDE Eclipse 

  

2. Spring Initializr 

  

3. MySql WorkBenck 

  

4. Postman 

  

## Frameworks e bibliotecas utilizadas 

  

1. Spring Boot 

  

2. Spring Data JPA 

  

3. Swagger 

  

**Testes Unitário** 

  

4. JUnit 

5. Mockito


## Requerimentos 

  

1. Maven 

  

2. Java 

  

3. Banco de dados Mysql 

  
  

## Configuração 

  

**1. Clonar a aplicação** 

  

```bash 

git clone https://github.com/Jbisatto/desafiopubfuture.git 

``` 

**2. Executar o projeto no Maven** 

  

Dentro da pasta principal do projeto abra um terminal de comando e execute os seguintes comandos: 

```bash 

mvnw install 

``` 

Após a instalação das dependências execute o comando:   

  

```bash 

java -jar target/desafiopubfut-0.0.1-SNAPSHOT.jar 

``` 

  

**Banco de dados** 

  

**3. Utilize o script MySQL contido no arquivo _data.sql_ para criar e popular o banco de dados** 

  

  `src/main/resources/data.sql` 

   

**4. Configuração de login do MySQL:** 

  

+ abrir `src/main/resources/application.properties` 

  

+ altere `spring.datasource.username` e `spring.datasource.password`  de acordo com a instalação do seu MySQL 

  

  

## Funcionalidade 

  

### Receitas 

  

*  Cadastrar receitas 

*  Editar receitas 

  

*  Remover receitas 

  

*  Listar receitas 

  >*  Filtro por período (dataInicial – dataFinal) 

  >*  Filtro por tipo de receita 

  

*  Listar total de receitas 

  

### Despesas 

  

* Cadastrar despesas 

  

*  Editar despesas 

  

*  Remover despesas 

  

*  Listar despesas 

  >*  Filtro por período (dataInicial – dataFinal) 

  >*  Filtro por tipo de despesa 

  

*  Listar total de despesas 

  

### Contas 

*  Cadastrar conta 

*  Editar conta 

*  Remover conta 

*  Listar contas 

*  Transferir saldo entre contas 

*  Listar saldo total 

  

## Documentação 

No projeto foi utilizado uma ferramenta OpenAPI. Quando a aplicação estiver rodando insira o seguinte endereço no browser: 

```bash 

http://localhost:8080/pubFuture.html 

``` 

![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/telaPrincipal.png) 

![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/telaPrincipal3.png) 

![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/telaPrincipal2.png) 

  

## Modelagem de dados 

![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/ModelagemDADOS.png) 

## Testes unitários 

![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/TesteUnitario.png)