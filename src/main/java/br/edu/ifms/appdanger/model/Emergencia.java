package br.edu.ifms.appdanger.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;

@Entity
public class Emergencia implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipo;
	private String nivel;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_instituicao")
	private Instituicao instituicao;	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_servidor")
	private Servidor servidor;	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_orgaoacionado")
	private OrgaoAcionado orgaoacionado;
	
    public Emergencia() {
		// TODO Auto-generated constructor stub
	}

	public Emergencia(Integer id, String tipo, String nivel, Instituicao instituicao, Servidor servidor, OrgaoAcionado orgaoacionado) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nivel = nivel;
		this.instituicao = instituicao;
		this.servidor = servidor;
		this.orgaoacionado = orgaoacionado;
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
	
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public OrgaoAcionado getOrgaoacionado() {
		return orgaoacionado;
	}

	public void setOrgaoacinado(OrgaoAcionado orgaoacinado) {
		this.orgaoacionado = orgaoacinado;
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
		Emergencia other = (Emergencia) obj;
		return Objects.equals(id, other.id);
	}
}
