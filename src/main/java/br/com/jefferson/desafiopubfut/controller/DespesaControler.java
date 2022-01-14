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

@RestController
@RequestMapping(value = "/despesa")
public class DespesaControler {

	@Autowired
	DespesaRepository despesaRepository;
	@Autowired
	DespesaService despesaService;

	@GetMapping // http://localhost:8080/despesa
	public List<Despesa> buscaListaDespesa() {

		return despesaService.buscarDespesas();

	}

	@GetMapping("/{id}") // http://localhost:8080/despesa/1
	public Despesa buscaDespesa(@PathVariable(value = "id") long id) {

		return despesaService.buscarDespesaId(id);

	}

	@PostMapping // http://localhost:8080/despesa
	public ResponseEntity<Despesa> salva(@RequestBody Despesa despesa, UriComponentsBuilder uriBuldier) {

		despesa = despesaService.salvar(despesa);
		URI uri = uriBuldier.path("/despesa/{id}").buildAndExpand(despesa.getId_despesa()).toUri();
		return ResponseEntity.created(uri).body(despesa);

	}

	@DeleteMapping // http://localhost:8080/despesa
	public void deletaDespesa(@RequestBody Despesa despesa) {

		despesaService.deletar(despesa);

		return;

	}

	@PutMapping // http://localhost:8080/despesa
	public ResponseEntity<Despesa> atualizaDespesa(@RequestBody Despesa despesa, UriComponentsBuilder uriBuldier) {

		despesa = despesaService.atualizar(despesa);
		URI uri = uriBuldier.path("/despesa/{id}").buildAndExpand(despesa.getId_despesa()).toUri();
		return ResponseEntity.created(uri).body(despesa);
	}

	@GetMapping("/tipoDespesa") // http://localhost:8080/despesa/tipoDespesa?tipo=ALIMENTACAO
	public List<Despesa> buscaDespesaTipo(String tipo) {

		return despesaService.buscarTipo(tipo);

	}

	@GetMapping("/totalDespesa") // http://localhost:8080/despesa/totalDespesa
	public double totalDespesa() {
		return despesaService.saldo();
	}

	@GetMapping("/data") // http://localhost:8080/despesa/data?inicial=09/07/2021&fim=10/10/2021
	public List<Despesa> buscaDespesaData(String inicial, String fim) {
		return despesaService.buscarPorData(inicial, fim);

	}
}
