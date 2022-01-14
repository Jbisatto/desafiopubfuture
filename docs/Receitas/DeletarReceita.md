## Remover Receita
 Com a aplicação rodando, abra o Postman, selecione
o método **DELETE**, insira o seguinte endereço de envio:
```bash
Http://localhost:8080/receita
```
Na aba **Headers** configure o cabeçalho de envio "Content-type" e "Application/json". Na aba **Body** selecione **raw**, insira o json para enviar as informações e aperte **Send**.
Se a receita que foi deleta tiver uma data de recebimento, o valor dessa receita será retirado do saldo da conta referênciada.
```bash
    {
        "id_receita": 5
    }
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/DeletarReceita.png)
