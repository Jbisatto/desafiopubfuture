## Transfêrencia de saldo entre Contas
Com a aplicação rodando, abra o Postman, selecione o método **POST**, insira o seguinte endereço de envio:
```bash
Http://localhost:8080/conta/transferencia
```
Na aba **Headers** configure o cabeçalho de envio "Content-type" e "Application/json". Na aba **Body** selecione **raw**, insira o json para enviar as informações e aperte **Send**.
```bash
{
    "id_conta_pagar": 1,
    "id_conta_receber":2,
    "valor":250
}
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/transferir.png)
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Conta/transfereAntesEDepois.png)
