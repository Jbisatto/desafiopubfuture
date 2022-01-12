package br.com.jefferson.desafiopubfut.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jefferson.desafiopubfut.enumerador.EErros;
import br.com.jefferson.desafiopubfut.enumerador.ETipoReceita;
import br.com.jefferson.desafiopubfut.exeption.ErrosException;
import br.com.jefferson.desafiopubfut.models.Conta;
import br.com.jefferson.desafiopubfut.models.Receita;
import br.com.jefferson.desafiopubfut.repository.ContaRepository;
import br.com.jefferson.desafiopubfut.repository.ReceitaRepository;

@Service
public class ReceitaService {
	private Conta conta;
	@Autowired
	ContaRepository contaRepository;
	@Autowired
	ReceitaRepository receitaRepository;

	public Receita salvar(Receita receita) {
		conta = contaRepository.findById(receita.getConta().getId_conta());
		if (conta == null) {
			throw new ErrosException("Nenhuma conta cadastrada", EErros.BUSCAR);
		}
		if (receita.getDtRecebimento() != null) {
			conta.setSaldo(conta.getSaldo() + receita.getValor());
			conta = contaRepository.save(conta);
		}
		receita.setConta(conta);
		receitaRepository.save(receita);
		return receita;
	}

	public Receita atualizar(Receita receita) {
		if (receitaRepository.findById(receita.getId_receita()) == null) {
			throw new ErrosException("Receita não cadatrada!!!", EErros.ATUALIZAR);
		}
		Receita receitaOld = new Receita();
		Conta contaOld = new Conta();
		receitaOld = receitaRepository.findById(receita.getId_receita());
		conta = contaRepository.findById(receita.getConta().getId_conta());
		contaOld = contaRepository.findById(receitaOld.getConta().getId_conta());
		if (conta.getId_conta() != contaOld.getId_conta()) {
			if (receitaOld.getDtRecebimento() != null) {
				contaOld.setSaldo(contaOld.getSaldo() - receitaOld.getValor());
				contaRepository.save(contaOld);
			}
			if (receita.getDtRecebimento() != null) {
				conta.setSaldo(conta.getSaldo() + receita.getValor());

			}
		} else if (receita.getDtRecebimento() != null && receitaOld.getDtRecebimento() == null) {
			conta.setSaldo(conta.getSaldo() + receita.getValor());

		} else if (receita.getDtRecebimento() == null && receitaOld.getDtRecebimento() != null) {
			conta.setSaldo(conta.getSaldo() - receita.getValor());

		}
		contaRepository.save(conta);
		receita.setConta(conta);
		receitaRepository.save(receita);
		return receita;
	}

	public double saldo() {
		List<Receita> lista = receitaRepository.findAll();
		double saldo = 0;
		for (Receita conta : lista) {
			saldo += conta.getValor();
		}
		return saldo;
	}

	public void deletar(Receita receita) {
		if (receitaRepository.findById(receita.getId_receita()) == null) {
			throw new ErrosException("Receita não cadatrada!!!", EErros.DELETAR);
		}
		receita = receitaRepository.findById(receita.getId_receita());
		conta = contaRepository.findById(receita.getConta().getId_conta());
		if (receita.getDtRecebimento() != null) {
			conta.setSaldo(conta.getSaldo() - receita.getValor());
			contaRepository.save(conta);
		}
		receitaRepository.delete(receita);
	}

	public List<Receita> buscarReceitas() {
		if (receitaRepository.findAll() == null) {
			throw new ErrosException("Nenhuma receita cadastrada!!!", EErros.BUSCAR);
		}
		return receitaRepository.findAll();
	}

	public Receita buscarReceitaID(long id) {
		if (receitaRepository.findById(id) == null) {
			throw new ErrosException("Receita não cadastrada!!!", EErros.BUSCAR);
		}
		return receitaRepository.findById(id);
	}

	public List<Receita> buscarTipo(String tipo) {
		try {
			ETipoReceita eTipoReceita = ETipoReceita.valueOf(tipo.toUpperCase());
			return receitaRepository.findByTipoReceita(eTipoReceita);
		} catch (Exception e) {
			throw new ErrosException(tipo + " não corresponde ao um tipo de Receita!!!", EErros.ENUMERADOR);
		}
	}

	public List<Receita> buscarPorData(String inicial, String fim) {

		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date dataStart = formato.parse(inicial);
			Date dataEnd = formato.parse(fim);
			return receitaRepository.findByDtRecebimentoBetween(dataStart, dataEnd);
		} catch (Exception e) {
			throw new ErrosException("data informada errada!!!", EErros.DATA);
		}
	}
}
