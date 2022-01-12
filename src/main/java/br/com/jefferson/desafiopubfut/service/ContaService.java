package br.com.jefferson.desafiopubfut.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jefferson.desafiopubfut.enumerador.EErros;
import br.com.jefferson.desafiopubfut.exeption.ErrosException;
import br.com.jefferson.desafiopubfut.models.Conta;
import br.com.jefferson.desafiopubfut.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	ContaRepository contarepository;

	public void transferir(Transferencia transfere) {
		if (contarepository.findById(transfere.getId_conta_pagar()) == null
				|| contarepository.findById(transfere.getId_conta_receber()) == null) {
			throw new ErrosException("Conta não cadastrada!!!", EErros.BUSCAR);
		}
		Conta contaPagar = new Conta();
		Conta contaReceber = new Conta();
		contaPagar = contarepository.findById(transfere.getId_conta_pagar());
		contaReceber = contarepository.findById(transfere.getId_conta_receber());
		if (contaPagar.getSaldo() >= transfere.getValor()) {
			contaPagar.transfere(transfere.getValor(), contaReceber);
			contarepository.save(contaPagar);
			contarepository.save(contaReceber);
		} else {
			throw new ErrosException("Saldo insuficente!!!", EErros.SEM_SALDO);
		}

		return;

	}

	public List<Conta> buscarContas() {
		if (contarepository.findAll() == null) {
			throw new ErrosException("Nenhuma conta cadastrada", EErros.BUSCAR);
		}
		return contarepository.findAll();

	}

	public Conta buscarContaId(long id) {
		if (contarepository.findById(id) == null) {
			throw new ErrosException("Conta não cadatrada!!!", EErros.BUSCAR);
		}
		return contarepository.findById(id);

	}

	public Conta salvar(@Valid Conta conta) {
		try {
			conta = contarepository.save(conta);
		} catch (Exception e) {
			throw new ErrosException("Alguma informação não foi preenchida!!!", EErros.RECEBER);
		}

		return conta;
	}

	public void deletar(Conta conta) {
		if (contarepository.findById(conta.getId_conta()) == null) {
			throw new ErrosException("Conta não cadatrada!!!", EErros.DELETAR);
		}
		contarepository.delete(conta);
	}

	public Conta atualizar(Conta conta) {
		if (contarepository.findById(conta.getId_conta()) == null) {
			throw new ErrosException("Conta não cadatrada!!!", EErros.ATUALIZAR);
		}
		return contarepository.save(conta);
	}

	public double saldo() {
		List<Conta> lista = contarepository.findAll();
		if (lista == null) {
			throw new ErrosException("Nenhuma conta cadastrada", EErros.BUSCAR);
		}
		double saldo = 0;
		for (Conta conta : lista) {
			saldo += conta.getSaldo();
		}
		return saldo;
	}
}
