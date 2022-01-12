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

import br.com.jefferson.desafiopubfut.enumerador.ETipoReceita;

@Entity
@Table(name = "tb_receita")
public class Receita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_receita;

	private String descricao;
	@NotNull
	private double valor;

	@Temporal(TemporalType.DATE)
	private Date dtRecebimento;

	@Temporal(TemporalType.DATE)
	private Date dtRecebEsperado;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ETipoReceita tipoReceita;

	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;

	public Receita() {

	}

	public Receita(long id_receita, double valor, Date dtRecebimento, Date dtRecebEsperado, String descricao,
			ETipoReceita tipoReceita, Conta conta) {
		this.id_receita = id_receita;
		this.valor = valor;
		this.dtRecebimento = dtRecebimento;
		this.dtRecebEsperado = dtRecebEsperado;
		this.descricao = descricao;
		this.tipoReceita = tipoReceita;
		this.conta = conta;
	}

	public long getId_receita() {
		return id_receita;
	}

	public void setId_receita(long id_receita) {
		this.id_receita = id_receita;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(Date dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}

	public Date getDtRecebEsperado() {
		return dtRecebEsperado;
	}

	public void setDtRecebEsperado(Date dtRecebEsperado) {
		this.dtRecebEsperado = dtRecebEsperado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public ETipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(ETipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

}
