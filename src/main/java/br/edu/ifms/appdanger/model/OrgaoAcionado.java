package br.edu.ifms.appdanger.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class OrgaoAcionado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@JsonIgnore
	@OneToMany(mappedBy = "orgaoacionado")	
	private List<Emergencia> emergencia = new ArrayList<Emergencia>();
	
	public OrgaoAcionado() {
		// TODO Auto-generated constructor stub
	}

	public OrgaoAcionado(Integer id, String nome, List<Emergencia> emergencia) {
		super();
		this.id = id;
		this.nome = nome;
		this.emergencia = emergencia;
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

	public List<Emergencia> getEmergencia() {
		return emergencia;
	}

	public void setEmergencia(List<Emergencia> emergencia) {
		this.emergencia = emergencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrgaoAcionado other = (OrgaoAcionado) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
