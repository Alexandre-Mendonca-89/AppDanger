package br.edu.ifms.appdanger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.appdanger.service.exception.ObjectNotFoundException;
import br.edu.ifms.appdanger.dto.ServidorDto;
import br.edu.ifms.appdanger.model.Servidor;
import br.edu.ifms.appdanger.repository.RepositoryServidor;

@Service //Para ignorar propriedades individuais, use o atributo [JsonIgnore]
public class ServidorService {
	@Autowired //Para ignorar propriedades individuais, use o atributo [JsonIgnore]
	private RepositoryServidor repositoryServidor;
	
		
	public List<Servidor> buscarTodos(){
		return repositoryServidor.findAll();
	}	
	
	public Servidor buscarPorId(Integer id) {
		Optional<Servidor> servidor = repositoryServidor.findById(id);
		return servidor.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Servidor.class.getName()));		
	}
	public Servidor inserir(Servidor servidor) {
		servidor.setId(null);
		return repositoryServidor.save(servidor);
	}
	
	public void remover(Integer id) {
		buscarPorId(id);
		repositoryServidor.deleteById(id);		
	}
	
	public Servidor atualizar(Servidor servidor) {
		Servidor servidorNovo = buscarPorId(servidor.getId());		
		servidorNovo.setNome(servidor.getNome());
		servidorNovo.setCpf(servidor.getCpf());
		return repositoryServidor.save(servidorNovo);
	}
	
	public Servidor fromDto(ServidorDto servidorDto) {
		return new Servidor(servidorDto.getId(),servidorDto.getNome(),servidorDto.getCpf(),null);
	}
}
