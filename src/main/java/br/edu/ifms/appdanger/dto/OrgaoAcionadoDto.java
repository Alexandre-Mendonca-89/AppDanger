package br.edu.ifms.appdanger.dto;

import java.io.Serializable;

import br.edu.ifms.appdanger.model.OrgaoAcionado;

public class OrgaoAcionadoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	
	public OrgaoAcionadoDto() {
		// TODO Auto-generated constructor stub
	}

	public OrgaoAcionadoDto(OrgaoAcionado orgaoAcionado) {
		super();
		this.id = orgaoAcionado.getId();
		this.nome = orgaoAcionado.getNome();
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

}
