package br.com.douglas.testetecnico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.douglas.testetecnico.dti.ClienteDTO;
import br.com.douglas.testetecnico.model.Cliente;
import br.com.douglas.testetecnico.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();		
	}

	public Cliente create(ClienteDTO clienteDTO) {
		Cliente cliente = clienteDTO.toEntity();
		return clienteRepository.save(cliente);
	}

	public void deleteById(Long id) {
		clienteRepository.deleteById(id);		
	}

	public Cliente update(Long id, ClienteDTO clienteDTO) throws Exception {
		Cliente clienteEntidade;
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		
		if (clienteOptional.isPresent()) {
			clienteEntidade = clienteOptional.get();
			clienteEntidade.setCpf(clienteDTO.getCpf());
			clienteEntidade.setEmail(clienteDTO.getEmail());
			clienteEntidade.setNome(clienteDTO.getNome());
			return clienteRepository.save(clienteEntidade);
		}
		else {
			throw new Exception("Usuario inexistente");
		}
		
		
	}
}
