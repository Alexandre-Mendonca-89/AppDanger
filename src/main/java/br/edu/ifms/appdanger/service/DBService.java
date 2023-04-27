package br.edu.ifms.appdanger.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.appdanger.model.Instituicao;
import br.edu.ifms.appdanger.model.Servidor;
import br.edu.ifms.appdanger.model.OrgaoAcionado;
import br.edu.ifms.appdanger.model.Emergencia;
import br.edu.ifms.appdanger.repository.RepositoryInstituicao;
import br.edu.ifms.appdanger.repository.RepositoryServidor;
import br.edu.ifms.appdanger.repository.RepositoryOrgaoAcionado;
import br.edu.ifms.appdanger.repository.RepositoryEmergencia;

@Service
public class DBService {
	
	@Autowired
	RepositoryServidor repositoryServidor;
	
	@Autowired
	RepositoryInstituicao repositoryInstituicao;
	
	@Autowired
	RepositoryOrgaoAcionado repositoryOrgaoAcionado;
	
	@Autowired
	RepositoryEmergencia repositoryEmergencia;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Instituicao i1 = new Instituicao(null, "IFMS", "Corumbá", "Popular Velha", "Teodomiro Serra", "6732311020", null);
		Instituicao i2 = new Instituicao(null, "Escola Municipal Barão do Rio Branco", "Corumbá", "Centro América", "Rua Oriental", "6732320123", null);
		Instituicao i3 = new Instituicao(null, "Escola Estadual 2 de Setembro", "Ladário", "Centro", "Avenida 14 de Março", "6732330102", null);
		
		Servidor s1 = new Servidor(null, "Juca", "10020030040", i1);
		Servidor s2 = new Servidor(null, "João", "01020304050", i2);
		Servidor s3 = new Servidor(null, "Beltrano", "10203040500", i3);
		
		OrgaoAcionado o1 = new OrgaoAcionado(null, "Policia Militar", null);
		OrgaoAcionado o2 = new OrgaoAcionado(null, "Bombeiro", null);
		OrgaoAcionado o3 = new OrgaoAcionado(null, "Policia Civil", null);
		OrgaoAcionado o4 = new OrgaoAcionado(null, "Samu", null);
		OrgaoAcionado o5 = new OrgaoAcionado(null, "GMC", null);
		
		Emergencia e1 = new Emergencia(null, "Afogamento", "Emergencia", i1 ,s1, o2);
		Emergencia e2 = new Emergencia(null, "Desmaio", "Muito Urgente", i2, s2, o4);
		Emergencia e3 = new Emergencia(null, "Choque", "Pouco Urgente", i3, s3, o4);
		Emergencia e4 = new Emergencia(null, "Briga", "Urgente", i1, s2, o1);
		
		repositoryInstituicao.saveAll(Arrays.asList(i1, i2, i3));
		repositoryServidor.saveAll(Arrays.asList(s1, s2, s3));
		repositoryOrgaoAcionado.saveAll(Arrays.asList(o1, o2, o3, o4, o5));
		repositoryEmergencia.saveAll(Arrays.asList(e1, e2, e3, e4));
		
	}
}