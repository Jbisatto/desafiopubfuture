## Editar Conta

Com a aplicação rodando, abra o Postman, selecione
o método **PUT**, insira o seguinte endereço de envio:
```Html
Http://localhost:8080/conta
```
Na aba **Headers** configure o cabeçalho de
 envio "Content-type" e "Application/json". Na aba
**Body** selecione **raw**, insira o json para
 enviar as informações e aperte **Send**.
```bash
    {
        "id_conta": 4,
        "saldo": 800,
        "tipoConta": "POUPANCA",
        "instFinanceira": "Banco do Brasil"
    }
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/AtualizarConta.png)
