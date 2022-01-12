package br.com.jefferson.desafiopubfut.enumerador;

public enum ETipoReceita {
	SALARIO("Salário"), PRESENTE("presente"), PREMIO("prêmio"), OUTROS("outros");

	private String descricao;

	ETipoReceita(String descricao) {
		this.descricao = descricao;

	}
	
	public String getDescricao() {
		return descricao;
	}
	

}
