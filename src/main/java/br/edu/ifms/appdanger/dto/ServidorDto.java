package br.edu.ifms.appdanger.dto;

import java.io.Serializable;

import br.edu.ifms.appdanger.model.Servidor;

public class ServidorDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String cpf;
	
	public ServidorDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ServidorDto(Servidor obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
	}

	public ServidorDto(Integer id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
