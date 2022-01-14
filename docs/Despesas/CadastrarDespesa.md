## Cadastrar Despesa
 Com a aplicação rodando, abra o Postman, selecione
o método **POST**, insira o seguinte endereço de envio:
```Html
Http://localhost:8080/despesa
```
Na aba **Headers** configure o cabeçalho de
 envio "Content-type" e "Application/json". Na aba
**Body** selecione **raw**, insira o json para
 enviar as informações e aperte **Send**.
 Quando houver um cadastramento de despesa com a data de pagamento, a conta que foi selecionada terá seu saldo diminuído.
```bash
{
    "valor": 200.0,
    "dtPagamento": "2021-09-08",
    "dtPagEsperado": "2021-09-12",
    "tipoDespesa": "ALIMENTACAO",
    "conta": {
           "id_conta": 3
    }
}
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/CadastrarDespesa.png)
