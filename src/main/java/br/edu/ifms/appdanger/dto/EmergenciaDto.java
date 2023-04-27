package br.edu.ifms.appdanger.dto;

import java.io.Serializable;

import br.edu.ifms.appdanger.model.Emergencia;

public class EmergenciaDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tipo;
	private String nivel;
	
	public EmergenciaDto() {
		// TODO Auto-generated constructor stub
	}

	public EmergenciaDto(Emergencia emergencia) {
		super();
		this.id = emergencia.getId();
		this.tipo = emergencia.getTipo();
		this.nivel = emergencia.getNivel();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
