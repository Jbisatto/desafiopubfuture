## Editar Receita

Com a aplicação rodando, abra o Postman, selecione
o método **PUT**, insira o seguinte endereço de envio:
```Html
Http://localhost:8080/receita
```
Na aba **Headers** configure o cabeçalho de
 envio "Content-type" e "Application/json". Na aba
**Body** selecione **raw**, insira o json para
 enviar as informações e aperte **Send**.
 Caso seja adionada a data de recebimento, a conta referência terá seu saldo acrescentado, caso seja retirado a data de recebimento, o saldo dela será diminuído. Se houver troca de conta, o valor da receita será repassado de acordo com o cadastramento da data de recebimento.
```bash
{
    "id_receita": 5,
    "descricao": "Sálário atrasado",
    "valor": 400.0,
    "dtRecebimento": "2021-10-08",
    "dtRecebEsperado": "2021-10-09",
    "tipoReceita": "SALARIO",
    "conta": {
        "id_conta": 2
    }
}
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/EditarReceita.png)
