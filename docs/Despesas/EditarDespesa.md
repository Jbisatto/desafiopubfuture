## Editar Despesa

Com a aplicação rodando, abra o Postman, selecione
o método **PUT**, insira o seguinte endereço de envio:
```Html
Http://localhost:8080/despesa
```
Na aba **Headers** configure o cabeçalho de
 envio "Content-type" e "Application/json". Na aba
**Body** selecione **raw**, insira o json para
 enviar as informações e aperte **Send**.
 Caso seja adionada a data de pagamento, a conta referência terá seu saldo diminuído, caso seja retirado a data de pagamento, o saldo dela será acrescentado. Se houver troca de conta, o valor da despesa será repassado de acordo com o cadastramento da data de pagemento.
```bash
    {
        "id_despesa": 5,
        "valor": 200.0,
        "dtPagamento": "2021-09-08",
        "dtPagEsperado": "2021-09-12",
        "tipoDespesa": "ALIMENTACAO",
        "conta": {
            "id_conta": 1
        }
    }
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/EditarDespesa.png)
