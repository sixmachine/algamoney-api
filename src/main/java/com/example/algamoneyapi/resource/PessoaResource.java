package com.example.algamoneyapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoneyapi.event.RecursoCriadoEvent;
import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Pessoa> listarPessoas() {
		return repository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Pessoa> pessoa = repository.findById(codigo);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok(pessoa.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Pessoa> salvarPessoa(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa salvado = repository.save(pessoa);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, salvado.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(salvado);

	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		repository.deleteById(codigo);
	}

}
