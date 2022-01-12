package br.com.jefferson.desafiopubfut.enumerador;

public enum EErros {
		RECEBER("Ocorreu algum erro no recebimento das informações"),
		BUSCAR("Erro ao buscar: "),
		DELETAR("Erro ao deletar: "),
		ATUALIZAR("Erro ao Atualizar: "),
		SEM_SALDO("Erro ao efetuar a transferencia: "),
		ENUMERADOR("Tipo errado :"),
		DATA("Erro ao buscar receitas por data: ");
		
		private final String mensagem;

		public String getMensagem() {
			return mensagem;
		}
		
		private EErros(String mensagem) {
			this.mensagem = mensagem;
		}
	}