# Controle de Finanças

Projeto para Controle de Finanças usando o conceito REST API criada usando Spring Boot e Spring Data JPA com banco de dados Mysql. Esse projeto faz parte e um desafio da Pub  Future onde o que foi priorizado nesse projeto foi o back-end.

## Requirementos

1. Maven

2. Java

3. Banco de dados Mysql

4. Postman 


## Configuração

**1. Clonar a aplicação**

```bash
git clone https://github.com/Jbisatto/desafiopubfuture.git
```
**2. Executar o projeto no Maven**

Dentro da pasta principal do projeto abra um terminal de comando e execute os seguites comandos:
```bash
mvnw install
```
Após a instação das dependência execute o camando:

```bash
java -jar target/desafiopubfut-0.0.1-SNAPSHOT.jar
```

### Banco de dados
**3. Criar no Mysql um banco de dados com o nome _desafioPubFuture_**

```bash
create database desafiopubfuture;
```

**4. Utilize o script MySQL contido no arquivo _data.sql_ para criar e popular o banco de dados**

  `src/main/resources/data.sql`
  
**5. Configuração de login do Mysql:**

+ abrir `src/main/resources/application.properties`

+ altere `spring.datasource.username` e `spring.datasource.password`  de acordo com a instalação do seu Mysql


## Funcionalidade
Como o projeto foi feita apenas o back-end, para testar suas funcionalidade foi usado o Postman. O projeto apresenta as seguintes funções (click em cada uma delas para obter mais informações):


### Receitas

*  [Cadastrar receitas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/CadastrarReceita.md)

*  [Editar receitas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/EditarReceita.md)

*  [Remover receitas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/DeletarReceita.md)

*  [Listar receitas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/ListarReceita.md)
  >*  [Filtro por período (dataInicial – dataFinal)](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/FiltroDataReceita.md)
  >*  [Filtro por tipo de receita](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/FiltroTipoReceita.md)

*  [Listar total de receitas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/ListarTotalReceita.md)

### Despesas

* [Cadastrar despesas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/CadastrarDespesa.md)

*  [Editar despesas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/EditarDespesa.md)

*  [Remover despesas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/DeletarDespesa.md)

*  [Listar despesas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/ListarDespesa.md)
  >*  [Filtro por período (dataInicial – dataFinal)](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/FiltroData.md)
 >*  [Filtro por tipo de despesa](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/FiltroTipoDespesa.md)

*  [Listar total de despesas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/ListarTotalDespesa.md)

### Contas
*  [Cadastrar conta](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/CadastrarConta.md)
*  [Editar conta](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/EditarConta.md)
*  [Remover conta](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/DeletarConta.md)
*  [Listar contas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/ListarConta.md)
*  [Transferir saldo entre contas](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/TransfereSaldoConta.md)
*  [Listar saldo total](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/ListarSaldo.md)

