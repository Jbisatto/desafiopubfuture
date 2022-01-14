## Remover Conta
 Com a aplicação rodando, abra o Postman, selecione
o método **DELETE**, insira o seguinte endereço de envio:
```Html
Http://localhost:8080/conta
```
Na aba **Headers** configure o cabeçalho de
 envio "Content-type" e "Application/json". Na aba
**Body** selecione **raw**, insira o json para
 enviar as informações e aperte **Send**.
```bash
    {
        "id_conta": 4
    }
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/deletarConta.png)
