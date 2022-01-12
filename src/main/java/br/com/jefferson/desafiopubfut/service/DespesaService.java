package br.com.jefferson.desafiopubfut.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jefferson.desafiopubfut.enumerador.EErros;
import br.com.jefferson.desafiopubfut.enumerador.ETipoDespesa;
import br.com.jefferson.desafiopubfut.exeption.ErrosException;
import br.com.jefferson.desafiopubfut.models.Conta;
import br.com.jefferson.desafiopubfut.models.Despesa;
import br.com.jefferson.desafiopubfut.repository.ContaRepository;
import br.com.jefferson.desafiopubfut.repository.DespesaRepository;

@Service
public class DespesaService {
	private Conta conta;
	@Autowired
	ContaRepository contaRepository;

	@Autowired
	DespesaRepository despesaRepository;

	public List<Despesa> buscarDespesas() {
		if (despesaRepository.findAll() == null) {
			throw new ErrosException("Nenhuma despesa cadastrada!!!", EErros.BUSCAR);
		}
		return despesaRepository.findAll();
	}

	public Despesa buscarDespesaId(long id) {
		if (despesaRepository.findById(id) == null) {
			throw new ErrosException("Despesa não cadastrada!!!", EErros.BUSCAR);
		}
		return despesaRepository.findById(id);

	}

	public Despesa salvar(Despesa despesa) {
		conta = contaRepository.findById(despesa.getConta().getId_conta());
		if (conta == null) {
			throw new ErrosException("Nenhuma conta cadastrada", EErros.BUSCAR);
		}
		if (despesa.getDtPagamento() != null) {
			try {
				conta.setSaldo(conta.getSaldo() - despesa.getValor());
				conta = contaRepository.save(conta);
			} catch (Exception e) {
				throw new ErrosException("Saldo Insuficiente!!!", EErros.SEM_SALDO);
			}
		}
		despesa.setConta(conta);

		return despesaRepository.save(despesa);

	}

	public Despesa atualizar(Despesa despesa) {
		if (despesaRepository.findById(despesa.getId_despesa()) == null) {
			throw new ErrosException("Despesa não cadatrada!!!", EErros.ATUALIZAR);
		}
		Despesa despesaOld = new Despesa();
		Conta contaOld = new Conta();
		despesaOld = despesaRepository.findById(despesa.getId_despesa());
		conta = contaRepository.findById(despesa.getConta().getId_conta());
		contaOld = contaRepository.findById(despesaOld.getConta().getId_conta());
		if (conta.getId_conta() != contaOld.getId_conta()) {
			if (despesaOld.getDtPagamento() != null) {
				contaOld.setSaldo(contaOld.getSaldo() + despesaOld.getValor());
				contaRepository.save(contaOld);
			}
			if (despesa.getDtPagamento() != null) {
				conta.setSaldo(conta.getSaldo() - despesa.getValor());

			}
		} else if (despesa.getDtPagamento() != null && despesaOld.getDtPagamento() == null) {
			conta.setSaldo(conta.getSaldo() - despesa.getValor());

		} else if (despesa.getDtPagamento() == null && despesaOld.getDtPagamento() != null) {
			conta.setSaldo(conta.getSaldo() + despesa.getValor());

		}
		contaRepository.save(conta);
		despesa.setConta(conta);
		return despesaRepository.save(despesa);
	}

	public double saldo() {
		List<Despesa> lista = despesaRepository.findAll();
		double saldo = 0;
		for (Despesa conta : lista) {
			saldo += conta.getValor();
		}
		return saldo;
	}

	public void deletar(Despesa despesa) {
		if (despesaRepository.findById(despesa.getId_despesa()) == null) {
			throw new ErrosException("Despesa não cadatrada!!!", EErros.DELETAR);
		}
		despesa = despesaRepository.findById(despesa.getId_despesa());
		conta = contaRepository.findById(despesa.getConta().getId_conta());
		if (despesa.getDtPagamento() != null) {
			conta.setSaldo(conta.getSaldo() + despesa.getValor());
			contaRepository.save(conta);
		}

		despesaRepository.delete(despesa);
	}

	public List<Despesa> buscarTipo(String tipo) {
		try {
			ETipoDespesa eTipoDespesa = ETipoDespesa.valueOf(tipo.toUpperCase());
			return despesaRepository.findByTipoDespesa(eTipoDespesa);
		} catch (Exception e) {
			throw new ErrosException(tipo + " não corresponde ao um tipo de Despesa!!!", EErros.ENUMERADOR);
		}
	}

	public List<Despesa> buscarPorData(String inicial, String fim) {
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date dataStart = formato.parse(inicial);
			Date dataEnd = formato.parse(fim);
			return despesaRepository.findByDtPagamentoBetween(dataStart, dataEnd);
		} catch (Exception e) {
			throw new ErrosException("data informada errada!!!", EErros.DATA);
		}
	}

}
