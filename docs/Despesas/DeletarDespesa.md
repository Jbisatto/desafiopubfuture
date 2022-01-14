## Remover Despesas
 Com a aplicação rodando, abra o Postman, selecione
o método **DELETE**, insira o seguinte endereço de envio:
```bash
Http://localhost:8080/despesa
```
Na aba **Headers** configure o cabeçalho de envio "Content-type" e "Application/json". Na aba **Body** selecione **raw**, insira o json para enviar as informações e aperte **Send**.
Se a despesa que foi deleta tiver uma data de pagamento, o valor dessa despesa voltará para o saldo da conta referênciada.
```bash
    {
        "id_despesa": 5
    }
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Despesas/DeletarDespesas.png)
