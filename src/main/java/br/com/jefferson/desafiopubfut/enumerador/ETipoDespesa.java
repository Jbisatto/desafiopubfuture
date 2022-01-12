package br.com.jefferson.desafiopubfut.enumerador;

public enum ETipoDespesa {
	ALIMENTACAO("Descrição"),
	EDUCACAO("Educação"),
	LAZER("Lazer"),
	MORADIA("Moradia"),
	ROUPA("Roupa"),
	SAUDE("Saúde"),
	TRANSPORTE("Transporte"),
	OUTROS("Outros");

	private String descricao;
	
	ETipoDespesa(String descricao) {
		this.descricao=descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}
