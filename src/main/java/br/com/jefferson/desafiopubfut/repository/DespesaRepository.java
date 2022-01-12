package br.com.jefferson.desafiopubfut.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jefferson.desafiopubfut.enumerador.ETipoDespesa;
import br.com.jefferson.desafiopubfut.models.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa,Long>{

	Despesa findById(long id);

	List<Despesa> findByTipoDespesa(ETipoDespesa tipoDespesa);

	List<Despesa> findByDtPagamentoBetween(final Date start, final Date end);


}
