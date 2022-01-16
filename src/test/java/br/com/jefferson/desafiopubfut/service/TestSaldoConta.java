package br.com.jefferson.desafiopubfut.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.jefferson.desafiopubfut.enumerador.EConta;
import br.com.jefferson.desafiopubfut.models.Conta;
import br.com.jefferson.desafiopubfut.repository.ContaRepository;

@ExtendWith(MockitoExtension.class)
class TestSaldoConta {

	@Mock
	ContaRepository contaRepository;

	@InjectMocks
	ContaService contaService;

	@BeforeEach
	void configuraRepository() {
		Conta conta1 = new Conta(1, 400.00, EConta.valueOf("CARTEIRA"), "Banco do Brasil");
		Conta conta2 = new Conta(2, 500.00, EConta.valueOf("POUPANCA"), "Bradesco");
		Conta conta3 = new Conta(3, 600.00, EConta.valueOf("CONTACORRENTE"), "Santander");
		Conta conta4 = new Conta(4, 700.00, EConta.valueOf("CARTEIRA"), "Banco UNICRED");
		List<Conta> listaConta = new ArrayList<Conta>();
		listaConta.add(conta1);
		listaConta.add(conta2);
		listaConta.add(conta3);
		listaConta.add(conta4);

		Mockito.when(contaRepository.findAll()).thenReturn(listaConta);
	}
	
	@Test
	void testSaldo() {
		double resultado=contaService.saldo();
		assertEquals(2200, resultado);
		
		
	}

}
