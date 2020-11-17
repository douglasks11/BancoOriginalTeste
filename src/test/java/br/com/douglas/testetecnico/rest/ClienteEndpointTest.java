package br.com.douglas.testetecnico.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.douglas.testetecnico.model.Cliente;
import br.com.douglas.testetecnico.repository.ClienteRepository;
import br.com.douglas.testetecnico.service.ClienteService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ClienteEndpoint.class)
public class ClienteEndpointTest {
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private ClienteService clienteService;
	
	
	@Test
	public void busca_todos_os_clientes() throws Exception {
		
		mock.perform(MockMvcRequestBuilders.get("/clientes"))
			.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	public void cria_cliente() throws Exception {
		
		Cliente cliente = new Cliente(null, "Nome", "email", "cpf");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cliente);
		
		mock.perform(MockMvcRequestBuilders.post("/clientes")
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(json))
						.andExpect(MockMvcResultMatchers.status().is(201));
	}
	
	@Test
	public void deleta_cliente() throws Exception{
		mock.perform(MockMvcRequestBuilders.delete("/clientes/1"))
				.andExpect(MockMvcResultMatchers.status().is(200));
		
	}
	
	@Test
	public void valida_via_cep() throws Exception{
		mock.perform(MockMvcRequestBuilders.get("https://viacep.com.br/ws/01001000/json/"))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
