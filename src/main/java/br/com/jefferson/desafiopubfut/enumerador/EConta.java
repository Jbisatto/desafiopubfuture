package br.com.jefferson.desafiopubfut.enumerador;

public enum EConta {
	CARTEIRA("Carteira"),
	CONTACORRENTE("Conta Corrente"),
	POUPANCA("Poupança");

	private String descricao;
	
	
	EConta(String descricao) {
		this.descricao=descricao;
	}
    public String getDescricao() {
		return descricao;
	}
	
}
