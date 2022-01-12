package br.com.jefferson.desafiopubfut.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.jefferson.desafiopubfut.enumerador.ETipoDespesa;

@Entity
@Table(name = "tb_despesa")
public class Despesa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_despesa;

	@NotNull
	private double valor;

	@Temporal(TemporalType.DATE)
	private Date dtPagamento;

	@Temporal(TemporalType.DATE)
	private Date dtPagEsperado;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ETipoDespesa tipoDespesa;

	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;

	public Despesa() {

	}

	public Despesa(long id_despesa, @NotNull double valor, Date dtPagamento, Date dtPagEsperado,
			@NotNull ETipoDespesa tipoDespesa, Conta conta) {
		super();
		this.id_despesa = id_despesa;
		this.valor = valor;
		this.dtPagamento = dtPagamento;
		this.dtPagEsperado = dtPagEsperado;
		this.tipoDespesa = tipoDespesa;
		this.conta = conta;
	}

	public long getId_despesa() {
		return id_despesa;
	}

	public void setId_despesa(long id_despesa) {
		this.id_despesa = id_despesa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public Date getDtPagEsperado() {
		return dtPagEsperado;
	}

	public void setDtPagEsperado(Date dtPagEsperado) {
		this.dtPagEsperado = dtPagEsperado;
	}

	public ETipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(ETipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
