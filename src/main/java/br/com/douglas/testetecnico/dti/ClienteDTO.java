package br.com.douglas.testetecnico.dti;

import br.com.douglas.testetecnico.model.Cliente;

public class ClienteDTO {
	
	
	private String nome;
	private String email;
	private String cpf;
	
	
	public ClienteDTO(String nome, String email, String cpf) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public ClienteDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente toEntity() {
		return new Cliente(null, this.nome, this.email, this.cpf);
	}
}
