package br.com.jefferson.desafiopubfut.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jefferson.desafiopubfut.models.Receita;

import br.com.jefferson.desafiopubfut.repository.ReceitaRepository;
import br.com.jefferson.desafiopubfut.service.ReceitaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/receita")
@Tag(name = "Receita")
public class ReceitaController {

	@Autowired
	ReceitaRepository receitaRepository;
	@Autowired
	ReceitaService receitaService;

	@GetMapping
	@Operation(summary = "Listar receitas")
	public List<Receita> buscaListaContas() {

		return receitaService.buscarReceitas();

	}

	@GetMapping("/{id}") 
	@Operation(summary = "Listar uma receita")
	public Receita buscaReceita(@PathVariable(value = "id") long id) {

		return receitaService.buscarReceitaID(id);

	}

	@PostMapping
	@Operation(summary = "Cadastrar receitas")
	public ResponseEntity<Receita> salva(@RequestBody Receita receita, UriComponentsBuilder uriBuldier) {

		receita = receitaService.salvar(receita);
		URI uri = uriBuldier.path("/receita/{id}").buildAndExpand(receita.getId_receita()).toUri();
		return ResponseEntity.created(uri).body(receita);

	}

	@DeleteMapping
	@Operation(summary = "Remover receitas")
	public void deletaReceita(@RequestBody Receita receita) {

		receitaService.deletar(receita);
		return;

	}

	@PutMapping
	@Operation(summary = "Editar receitas")
	public ResponseEntity<Receita> atualizaReceita(@RequestBody Receita receita, UriComponentsBuilder uriBuldier) {

		receita = receitaService.atualizar(receita);
		URI uri = uriBuldier.path("/receita/{id}").buildAndExpand(receita.getId_receita()).toUri();
		return ResponseEntity.created(uri).body(receita);
	}

	@GetMapping("/tipoReceita")
	@Operation(summary = "Listar por tipo de receita")
	public List<Receita> buscaReceitaTipo(String tipo) {
		
		return receitaService.buscarTipo(tipo);

	}

	@GetMapping("/totalReceitas")
	@Operation(summary = "Listar total de receitas")
	public double totalReceitas() {
		
		return receitaService.saldo();
	}

	@GetMapping("/data")
	@Operation(summary = "Listar por período( dataInicial - dataFinal)")
	public List<Receita> buscaReceitaData(String inicial, String fim) {
		
		return receitaService.buscarPorData(inicial, fim);

	}
}
