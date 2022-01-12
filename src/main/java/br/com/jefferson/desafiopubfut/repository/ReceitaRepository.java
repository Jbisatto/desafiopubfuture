package br.com.jefferson.desafiopubfut.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jefferson.desafiopubfut.enumerador.ETipoReceita;
import br.com.jefferson.desafiopubfut.models.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	
	Receita findById(long id);

	List<Receita> findByTipoReceita(ETipoReceita tipoReceita);

	List<Receita> findByDtRecebimentoBetween(final Date start, final Date end);

}
