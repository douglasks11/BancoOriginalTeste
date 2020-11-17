package br.com.douglas.testetecnico.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.douglas.testetecnico.dti.ClienteDTO;
import br.com.douglas.testetecnico.model.Cliente;
import br.com.douglas.testetecnico.service.ClienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/clientes")
public class ClienteEndpoint {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody ClienteDTO clienteDTO) {
		 return clienteService.create(clienteDTO);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		clienteService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Cliente update(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO) throws Exception {
		return clienteService.update(id, clienteDTO);
	}
}
