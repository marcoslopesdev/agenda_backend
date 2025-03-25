package com.marcos.agenda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;

import com.marcos.agenda.model.Contato;
import com.marcos.agenda.repository.ContatoRepository;
import com.marcos.agenda.model.Cliente;
import com.marcos.agenda.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ContatoRepository contatoRepository;

	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
		return clienteRepository.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/nome-cliente/{nomeCliente}")
	public ResponseEntity<List<Cliente>> getByNomeCliente(@PathVariable String nomeCliente) {
		return ResponseEntity.ok(clienteRepository.findAllByNomeClienteContainingIgnoreCase(nomeCliente));
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> post(@Valid @RequestBody Cliente cliente) {

		if (clienteRepository.existsByCpf(cliente.getCpf())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já cadastrado.");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Cliente> put(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.findById(cliente.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/clientes")
	public List<Cliente> buscarClientesPorNome(@RequestParam String nomeCliente) {
		return clienteRepository.findAllByNomeClienteContainingIgnoreCase(nomeCliente);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (cliente.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		clienteRepository.deleteById(id);
	}

	@GetMapping("/{id}/contatos")
	public ResponseEntity<List<Contato>> getContatosByClienteId(@PathVariable Long id) {

		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		List<Contato> contatos = contatoRepository.findByClienteId(id);

		if (contatos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(contatos);
	}
}
