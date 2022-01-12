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

@RestController
@RequestMapping(value = "/receita")
public class ReceitaController {

	@Autowired
	ReceitaRepository receitaRepository;
	@Autowired
	ReceitaService receitaService;

	@GetMapping // http://localhost:8080/receita
	public List<Receita> buscaListaContas() {

		return receitaService.buscarReceitas();

	}

	@GetMapping("/{id}") // http://localhost:8080/receita/1
	public Receita buscaReceita(@PathVariable(value = "id") long id) {

		return receitaService.buscarReceitaID(id);

	}

	@PostMapping // http://localhost:8080/receita/
	public ResponseEntity<Receita> salva(@RequestBody Receita receita, UriComponentsBuilder uriBuldier) {

		receita = receitaService.salvar(receita);
		URI uri = uriBuldier.path("/receita/{id}").buildAndExpand(receita.getId_receita()).toUri();
		return ResponseEntity.created(uri).body(receita);

	}

	@DeleteMapping // http://localhost:8080/receita/
	public void deletaReceita(@RequestBody Receita receita) {

		receitaService.deletar(receita);
		return;

	}

	@PutMapping // http://localhost:8080/receita/
	public ResponseEntity<Receita> atualizaReceita(@RequestBody Receita receita, UriComponentsBuilder uriBuldier) {

		receita = receitaService.atualizar(receita);
		URI uri = uriBuldier.path("/receita/{id}").buildAndExpand(receita.getId_receita()).toUri();
		return ResponseEntity.created(uri).body(receita);
	}

	@GetMapping("/tipoReceita") // http://localhost:8080/receita/tipoReceita?tipo=SALARIO
	public List<Receita> buscaReceitaTipo(String tipo) {
		
		return receitaService.buscarTipo(tipo);

	}

	@GetMapping("/totalReceitas") // http://localhost:8080/receita/totalReceitas
	public double totalReceitas() {
		
		return receitaService.saldo();
	}

	@GetMapping("/data") // http://localhost:8080/receita/data?inicial=09/01/2021&fim=10/01/2021
	public List<Receita> buscaReceitaData(String inicial, String fim) {
		
		return receitaService.buscarPorData(inicial, fim);

	}
}
