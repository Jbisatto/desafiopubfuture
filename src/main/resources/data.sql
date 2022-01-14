create table tb_conta(
	id_conta bigint primary key auto_increment,
    saldo double,
    tipo_conta varchar(255),
    inst_financeira varchar(255)
);
create table tb_receita(
	id_receita bigint primary key auto_increment,
    valor double,
    dt_recebimento date,
    dt_receb_esperado date,
    descricao text(200),
    id_conta bigint,
    tipo_receita varchar(50),
    CONSTRAINT fk_receitas FOREIGN KEY (id_conta) REFERENCES tb_conta (id_conta)
);
create table tb_despesa(
	id_despesa bigint primary key auto_increment,
    valor double,
    dt_pagamento date,
    dt_pag_esperado date,
    id_conta bigint,
    tipo_despesa varchar(255),
    CONSTRAINT fk_despesas FOREIGN KEY (id_conta) REFERENCES tb_conta (id_conta)
);

insert into tb_conta (saldo, tipo_conta, inst_financeira) values(700,'POUPANCA','Banco do Brasil');
insert into tb_conta (saldo, tipo_conta, inst_financeira) values(900,'CONTACORRENTE','Caixa Econômica');
insert into tb_conta (saldo, tipo_conta, inst_financeira) values(800,'CARTEIRA','Bradesco');
insert into tb_receita (descricao,dt_receb_esperado,dt_recebimento,tipo_receita,valor,id_conta)
 values('Descricao1','2021-10-10','2021-10-09','SALARIO',250.00,1);
 insert into tb_receita (descricao,dt_receb_esperado,dt_recebimento,tipo_receita,valor,id_conta)
 values('Descricao2','2021-08-10','2021-08-09','PRESENTE',350.00,1);
 insert into tb_receita (descricao,dt_receb_esperado,dt_recebimento,tipo_receita,valor,id_conta)
 values('Descricao3','2021-07-10','2021-07-09','PREMIO',450.00,2);
 insert into tb_receita (descricao,dt_receb_esperado,dt_recebimento,tipo_receita,valor,id_conta)
 values('Descricao4','2021-09-01','2021-09-09','SALARIO',250.00,3);
 
 insert into tb_despesa (valor,dt_pagamento,dt_pag_esperado,tipo_despesa,id_conta)
 values(500,'2021-10-08','2021-10-09','ALIMENTACAO',1);
  insert into tb_despesa (valor,dt_pagamento,dt_pag_esperado,tipo_despesa,id_conta)
 values(500,'2021-11-18','2021-11-20','EDUCACAO',2);
  insert into tb_despesa (valor,dt_pagamento,dt_pag_esperado,tipo_despesa,id_conta)
 values(500,'2021-07-12','2021-07-15','SAUDE',1);
  insert into tb_despesa (valor,dt_pagamento,dt_pag_esperado,tipo_despesa,id_conta)
 values(500,'2021-09-08','2021-09-12','ALIMENTACAO',3);
