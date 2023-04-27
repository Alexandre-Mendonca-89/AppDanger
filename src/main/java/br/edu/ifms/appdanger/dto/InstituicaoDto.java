package br.edu.ifms.appdanger.dto;

import java.io.Serializable;

import br.edu.ifms.appdanger.model.Instituicao;

public class InstituicaoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String cidade;
	private String bairro;
	private String rua;
	private String telefone;
	
	public InstituicaoDto() {
		// TODO Auto-generated constructor stub
	}

	public InstituicaoDto(Instituicao instituicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.telefone = telefone;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
