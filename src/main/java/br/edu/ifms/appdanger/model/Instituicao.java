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
public class Instituicao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cidade;
	private String bairro;
	private String rua;
	private String telefone;
	@JsonIgnore
	@OneToMany(mappedBy = "instituicao")	
	private List<Servidor> servidor = new ArrayList<Servidor>();
	
	public Instituicao() {
		// TODO Auto-generated constructor stub
	}

	public Instituicao(Integer id, String nome, String cidade, String bairro, String rua, String telefone, List<Servidor> servidor) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.telefone = telefone;
		this.servidor = servidor;
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

	public List<Servidor> getServidor() {
		return servidor;
	}

	public void setServidor(List<Servidor> servidor) {
		this.servidor = servidor;
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
		Instituicao other = (Instituicao) obj;
		return Objects.equals(id, other.id);
	}
}
