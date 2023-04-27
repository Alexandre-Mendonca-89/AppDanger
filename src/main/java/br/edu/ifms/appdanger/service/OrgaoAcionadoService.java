package br.edu.ifms.appdanger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.appdanger.service.exception.ObjectNotFoundException;
import br.edu.ifms.appdanger.dto.OrgaoAcionadoDto;
import br.edu.ifms.appdanger.model.OrgaoAcionado;
import br.edu.ifms.appdanger.repository.RepositoryOrgaoAcionado;

@Service
public class OrgaoAcionadoService {
	@Autowired
	private RepositoryOrgaoAcionado repositoryOrgaoAcionado;
	
		
	public List<OrgaoAcionado> buscarTodos(){
		return repositoryOrgaoAcionado.findAll();
	}	
	
	public OrgaoAcionado buscarPorId(Integer id) {
		Optional<OrgaoAcionado> orgaoacionado = repositoryOrgaoAcionado.findById(id);
		return orgaoacionado.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + OrgaoAcionado.class.getName()));		
	}
	public OrgaoAcionado inserir(OrgaoAcionado orgaoacionado) {
		orgaoacionado.setId(null);
		return repositoryOrgaoAcionado.save(orgaoacionado);
	}
	
	public void remover(Integer id) {
		buscarPorId(id);
		repositoryOrgaoAcionado.deleteById(id);		
	}
	
	public OrgaoAcionado atualizar(OrgaoAcionado orgaoacionado) {
		OrgaoAcionado orgaoacionadoNovo = buscarPorId(orgaoacionado.getId());		
		orgaoacionadoNovo.setNome(orgaoacionado.getNome());
		return repositoryOrgaoAcionado.save(orgaoacionadoNovo);
	}
	
	public OrgaoAcionado fromDto(OrgaoAcionadoDto orgaoacionadoDto) {
		return new OrgaoAcionado(orgaoacionadoDto.getId(),orgaoacionadoDto.getNome(), null);
	}
}
