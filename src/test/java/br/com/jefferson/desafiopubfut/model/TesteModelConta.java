package br.com.jefferson.desafiopubfut.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.jefferson.desafiopubfut.enumerador.EConta;
import br.com.jefferson.desafiopubfut.models.Conta;

class TesteModelConta {

	@Test
	void testeTransferencia(){
		Conta conta1 = new Conta(400.00, EConta.valueOf("CARTEIRA"), "Banco do Brasil");
		Conta conta2 = new Conta(100.00, EConta.valueOf("POUPANCA"), "Caixa Econômica");
		
		conta1.transfere(100, conta2);
		assertEquals(300, conta1.getSaldo());
		assertEquals(200, conta2.getSaldo());
	}

}
