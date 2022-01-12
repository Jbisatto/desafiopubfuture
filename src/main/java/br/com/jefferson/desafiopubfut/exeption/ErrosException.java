package br.com.jefferson.desafiopubfut.exeption;

import br.com.jefferson.desafiopubfut.enumerador.EErros;

public class ErrosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrosException(String mensagem, EErros excecao) {
			super(excecao.getMensagem() + "-" + mensagem);
	}

}
