package br.com.jefferson.desafiopubfut.dto;


public class Transferencia {
	private long id_conta_pagar;
	private long id_conta_receber;
	private double valor;


	public long getId_conta_pagar() {
		return id_conta_pagar;
	}

	public void setId_conta_pagar(long id_conta_pagar) {
		this.id_conta_pagar = id_conta_pagar;
	}

	public long getId_conta_receber() {
		return id_conta_receber;
	}

	public void setId_conta_receber(long id_conta_receber) {
		this.id_conta_receber = id_conta_receber;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


}
