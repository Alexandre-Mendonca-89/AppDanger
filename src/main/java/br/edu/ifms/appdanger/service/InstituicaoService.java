package br.edu.ifms.appdanger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.appdanger.service.exception.ObjectNotFoundException;
import br.edu.ifms.appdanger.dto.InstituicaoDto;
import br.edu.ifms.appdanger.model.Instituicao;
import br.edu.ifms.appdanger.repository.RepositoryInstituicao;

@Service
public class InstituicaoService {
	@Autowired
	private RepositoryInstituicao repositoryInstituicao;
	
		
	public List<Instituicao> buscarTodos(){
		return repositoryInstituicao.findAll();
	}	
	
	public Instituicao buscarPorId(Integer id) {
		Optional<Instituicao> instituicao = repositoryInstituicao.findById(id);
		return instituicao.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Instituicao.class.getName()));		
	}
	public Instituicao inserir(Instituicao instituicao) {
		instituicao.setId(null);
		return repositoryInstituicao.save(instituicao);
	}
	
	public void remover(Integer id) {
		buscarPorId(id);
		repositoryInstituicao.deleteById(id);		
	}
	
	public Instituicao atualizar(Instituicao instituicao) {
		Instituicao instituicaoNovo = buscarPorId(instituicao.getId());		
		instituicaoNovo.setNome(instituicao.getNome());
		instituicaoNovo.setCidade(instituicao.getCidade());
		instituicaoNovo.setBairro(instituicao.getBairro());
		instituicaoNovo.setRua(instituicao.getRua());
		instituicaoNovo.setTelefone(instituicao.getTelefone());
		return repositoryInstituicao.save(instituicaoNovo);
	}
	
	public Instituicao fromDto(InstituicaoDto instituicaoDto) {
		return new Instituicao(instituicaoDto.getId(),instituicaoDto.getNome(),instituicaoDto.getCidade(),instituicaoDto.getBairro(),instituicaoDto.getRua(),instituicaoDto.getTelefone(),null);
	}
}
