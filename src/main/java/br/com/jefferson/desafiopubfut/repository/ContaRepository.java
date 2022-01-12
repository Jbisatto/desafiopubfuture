package br.com.jefferson.desafiopubfut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jefferson.desafiopubfut.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	Conta findById(long id);
}
