package br.com.jefferson.desafiopubfut.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.jefferson.desafiopubfut.enumerador.EConta;

@Entity
@Table(name = "tb_conta")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_conta;

	@NotNull
	@DecimalMin(value = "0.01")
	private double saldo;

	@NotNull
	@Enumerated(EnumType.STRING)
	private EConta tipoConta;

	@NotEmpty
	private String instFinanceira;

	public Conta() {

	}

	public Conta(@NotNull @DecimalMin("0.01") double saldo, @NotNull EConta tipoConta,
			@NotEmpty String instFinanceira) {
		super();
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instFinanceira = instFinanceira;
	}

	public Conta(long id_conta, @NotNull @DecimalMin("0.01") double saldo, @NotNull EConta tipoConta,
			@NotEmpty String instFinanceira) {
		super();
		this.id_conta = id_conta;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
		this.instFinanceira = instFinanceira;
	}

	public long getId_conta() {
		return id_conta;
	}

	public void setId_conta(long id_conta) {
		this.id_conta = id_conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public EConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(EConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getInstFinanceira() {
		return instFinanceira;
	}

	public void setInstFinanceira(String instFinanceira) {
		this.instFinanceira = instFinanceira;
	}

	public void transfere(double valor, Conta recebe) {
		this.saldo = this.saldo - valor;
		recebe.setSaldo(recebe.getSaldo() + valor);

	}
}
