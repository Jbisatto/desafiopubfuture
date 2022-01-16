package br.com.jefferson.desafiopubfut.service;

import static org.junit.jupiter.api.Assertions.*;

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
class TestBuscaIdConta {

	@Mock
	ContaRepository contaRepository;

	@InjectMocks
	ContaService contaService;

	@BeforeEach
	void configuraRepository() {
		Conta conta1 = new Conta(1, 400.00, EConta.valueOf("CARTEIRA"), "Banco do Brasil");
		Mockito.when(contaRepository.findById(1)).thenReturn(conta1);
	}
	
	@Test
	void testBuscarContaId() {
		Conta contaAUX = new Conta(1, 400.00, EConta.valueOf("CARTEIRA"), "Banco do Brasil");
		Conta contaTeste= contaService.buscarContaId(contaAUX.getId_conta());
		assertEquals(contaAUX.getId_conta(),contaTeste.getId_conta());
		assertEquals(contaAUX.getSaldo(),contaTeste.getSaldo());
		assertEquals(contaAUX.getTipoConta(),contaTeste.getTipoConta());
		assertEquals(contaAUX.getInstFinanceira(),contaTeste.getInstFinanceira());
		
	}

}
