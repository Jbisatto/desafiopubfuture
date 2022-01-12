package br.com.jefferson.desafiopubfut.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.jefferson.desafiopubfut.enumerador.EConta;
import br.com.jefferson.desafiopubfut.models.Conta;

@SpringBootTest
class TesteServiceConta {

	@Autowired
	ContaService contaService;

	private static long id_conta=1;
	private static Conta contaTest = new Conta();
	private Conta conta;
	
	@Test
	void atesteServiceContaSalvar() {
		conta = new Conta(1000.00, EConta.valueOf("CARTEIRA"), "Banco do Brasil");
		contaTest = contaService.salvar(conta);
		id_conta = contaTest.getId_conta();
		assertNotNull(contaTest);
		assertNotEquals(null, contaTest.getId_conta());
		assertEquals(conta.getTipoConta(), contaTest.getTipoConta());
		assertEquals(conta.getInstFinanceira(), contaTest.getInstFinanceira());

	}

	@Test
	void btesteServiceContaBuscarID() {
		conta = new Conta();
		conta = contaService.buscarContaId(id_conta);
		assertNotNull(conta);
		assertEquals(contaTest.getId_conta(), conta.getId_conta());
		assertEquals(contaTest.getInstFinanceira(), conta.getInstFinanceira());
		assertEquals(contaTest.getTipoConta(), conta.getTipoConta());

	}

	@Test
	void ctesteServiceContaBuscarTodos() {
		List<Conta> lista = new ArrayList<Conta>();
		lista = contaService.buscarContas();
		assertEquals(false, lista.isEmpty());
		

	}
	@Test
	void dtesteServiceContaAtualizar() {
		conta = new Conta(500.00, EConta.valueOf("POUPANCA"), "Caixa Econonica");
		conta.setId_conta(33);
		contaTest= contaService.atualizar(conta);
		assertNotNull(contaTest);
		assertEquals(conta.getId_conta(), contaTest.getId_conta());
		assertEquals(conta.getInstFinanceira(), contaTest.getInstFinanceira());
		assertEquals(conta.getTipoConta(), contaTest.getTipoConta());

	}
	
	@Test
	void testeServiceContaDeletar() {
		conta = new Conta();
		System.out.println(id_conta);
		conta.setId_conta(id_conta);
		contaService.deletar(conta);
		
		

	}
}
