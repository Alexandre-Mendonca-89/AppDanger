package br.edu.ifms.appdanger.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.appdanger.model.Instituicao;
import br.edu.ifms.appdanger.dto.InstituicaoDto;
import br.edu.ifms.appdanger.service.InstituicaoService;
import jakarta.validation.Valid;

@RestController //A anotação @RestController permite definir um controller com características REST
@RequestMapping(value ="/instituicao")
public class InstituicaoResource {

	@Autowired
	InstituicaoService instituicao;
	//A anotação @RequestMapping permite definir uma rota
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Instituicao> find(@PathVariable Integer id) {		
		Instituicao obj = instituicao.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InstituicaoDto objDto) {
		Instituicao obj = instituicao.fromDto(objDto);
		obj = instituicao.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody InstituicaoDto objDto, @PathVariable Integer id) {
		Instituicao obj = instituicao.fromDto(objDto);
		obj.setId(id);
		obj = instituicao.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Instituicao obj,@PathVariable Integer id){
		instituicao.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InstituicaoDto>> findAll() {		
		List<Instituicao> list = instituicao.buscarTodos();
		List<InstituicaoDto> listDto = list.stream().map(obj -> new InstituicaoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	

}
