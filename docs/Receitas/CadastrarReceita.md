## Cadastrar Receita
 Com a aplicação rodando, abra o Postman, selecione
o método **POST**, insira o seguinte endereço de envio:
```Html
Http://localhost:8080/receita
```
Na aba **Headers** configure o cabeçalho de
 envio "Content-type" e "Application/json". Na aba
**Body** selecione **raw**, insira o json para
 enviar as informações e aperte **Send**.
 Quando houver um cadastramento de receita com a data de recebimento, a conta que foi selecionada terá seu saldo aumentado.
```bash
   {
        "descricao": "Sálário atrasado",
        "valor": 400.0,
        "dtRecebimento": "2021-10-09",
        "dtRecebEsperado": "2021-10-10",
        "tipoReceita": "SALARIO",
        "conta": {
            "id_conta": 1
        }
   }
```
![](https://github.com/Jbisatto/desafiopubfuture/blob/master/docs/Receitas/CadastrarReceita.png)
