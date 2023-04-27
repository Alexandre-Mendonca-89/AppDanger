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

import br.edu.ifms.appdanger.model.OrgaoAcionado;
import br.edu.ifms.appdanger.dto.OrgaoAcionadoDto;
import br.edu.ifms.appdanger.service.OrgaoAcionadoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/orgaoacionado")
public class OrgaoAcionadoResource {

	@Autowired
	OrgaoAcionadoService orgaoacionado;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrgaoAcionado> find(@PathVariable Integer id) {		
		OrgaoAcionado obj = orgaoacionado.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody OrgaoAcionadoDto objDto) {
		OrgaoAcionado obj = orgaoacionado.fromDto(objDto);
		obj = orgaoacionado.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody OrgaoAcionadoDto objDto, @PathVariable Integer id) {
		OrgaoAcionado obj = orgaoacionado.fromDto(objDto);
		obj.setId(id);
		obj = orgaoacionado.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody OrgaoAcionado obj,@PathVariable Integer id){
		orgaoacionado.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OrgaoAcionadoDto>> findAll() {		
		List<OrgaoAcionado> list = orgaoacionado.buscarTodos();
		List<OrgaoAcionadoDto> listDto = list.stream().map(obj -> new OrgaoAcionadoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	

}
