package br.com.jefferson.desafiopubfut.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import br.com.jefferson.desafiopubfut.repository.ContaRepository;
import br.com.jefferson.desafiopubfut.service.ContaService;
import br.com.jefferson.desafiopubfut.service.Transferencia;
import br.com.jefferson.desafiopubfut.enumerador.EErros;
import br.com.jefferson.desafiopubfut.exeption.ErrosException;
import br.com.jefferson.desafiopubfut.models.Conta;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

	@Autowired
	ContaRepository contarepository;

	@Autowired
	ContaService contaService;

	@GetMapping
	public List<Conta> buscaListaContas() {

		return contaService.buscarContas();
	}

	@GetMapping("/{id}")
	public Conta buscaConta(@PathVariable long id) {
		return contaService.buscarContaId(id);
	}

	@PostMapping
	public ResponseEntity<Conta> salvaConta(@RequestBody @Valid Conta conta, UriComponentsBuilder uriBuldier) {
		conta=contaService.salvar(conta);
		URI uri = uriBuldier.path("/conta/{id_conta}").buildAndExpand(conta.getId_conta()).toUri();
		return ResponseEntity.created(uri).body(conta);
	}

	@DeleteMapping
	public void deletaConta(@RequestBody Conta conta) {
		contaService.deletar(conta);
		return;
	}

	@PutMapping
	public ResponseEntity<Conta> atualizaConta(@RequestBody Conta conta, UriComponentsBuilder uriBuldier) {
		conta=contaService.atualizar(conta);
		URI uri = uriBuldier.path("/conta/{id_conta}").buildAndExpand(conta.getId_conta()).toUri();
		return ResponseEntity.created(uri).body(conta);
	}

	@PostMapping("/transferencia")
	public void tranferencia(@RequestBody @Valid Transferencia transferencia) throws ErrosException {
		contaService.transferir(transferencia);
		return;
	}

	@GetMapping("/saldoTotal")
	public double saldoTotal() {
		return contaService.saldo();
	}
}
