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

import br.com.jefferson.desafiopubfut.models.Despesa;
import br.com.jefferson.desafiopubfut.repository.DespesaRepository;
import br.com.jefferson.desafiopubfut.service.DespesaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/despesa")
@Tag(name = "Despesa")
public class DespesaControler {

	@Autowired
	DespesaRepository despesaRepository;
	@Autowired
	DespesaService despesaService;

	@GetMapping
	@Operation(summary = "Listar despesas")
	public List<Despesa> buscaListaDespesa() {

		return despesaService.buscarDespesas();

	}

	@GetMapping("/{id}")
	@Operation(summary = "Listar uma despesa")
	public Despesa buscaDespesa(@PathVariable(value = "id") long id) {

		return despesaService.buscarDespesaId(id);

	}

	@PostMapping
	@Operation(summary = "Cadastrar despesas")
	public ResponseEntity<Despesa> salva(@RequestBody Despesa despesa, UriComponentsBuilder uriBuldier) {

		despesa = despesaService.salvar(despesa);
		URI uri = uriBuldier.path("/despesa/{id}").buildAndExpand(despesa.getId_despesa()).toUri();
		return ResponseEntity.created(uri).body(despesa);

	}

	@DeleteMapping
	@Operation(summary = "Remover Despesas")
	public void deletaDespesa(@RequestBody Despesa despesa) {

		despesaService.deletar(despesa);

		return;

	}

	@PutMapping
	@Operation(summary = "Editar despesas")
	public ResponseEntity<Despesa> atualizaDespesa(@RequestBody Despesa despesa, UriComponentsBuilder uriBuldier) {

		despesa = despesaService.atualizar(despesa);
		URI uri = uriBuldier.path("/despesa/{id}").buildAndExpand(despesa.getId_despesa()).toUri();
		return ResponseEntity.created(uri).body(despesa);
	}

	@GetMapping("/tipoDespesa")
	@Operation(summary = "Listar por tipo de despesa")
	public List<Despesa> buscaDespesaTipo(String tipo) {

		return despesaService.buscarTipo(tipo);

	}

	@GetMapping("/totalDespesa")
	@Operation(summary = "Listar total de despesas")
	public double totalDespesa() {
		return despesaService.saldo();
	}

	@GetMapping("/data")
	@Operation(summary = "Listar por período ( dataInicial - dataFinal)")
	public List<Despesa> buscaDespesaData(String inicial, String fim) {
		return despesaService.buscarPorData(inicial, fim);

	}
}
