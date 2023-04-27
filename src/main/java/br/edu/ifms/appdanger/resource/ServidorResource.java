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

import br.edu.ifms.appdanger.dto.ServidorDto;
import br.edu.ifms.appdanger.model.Servidor;
import br.edu.ifms.appdanger.service.ServidorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/servidor")
public class ServidorResource {

	@Autowired
	ServidorService servidor;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Servidor> find(@PathVariable Integer id) {		
		Servidor obj = servidor.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ServidorDto objDto) {
		Servidor obj = servidor.fromDto(objDto);
		obj = servidor.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ServidorDto objDto, @PathVariable Integer id) {
		Servidor obj = servidor.fromDto(objDto);
		obj.setId(id);
		obj = servidor.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Servidor obj,@PathVariable Integer id){
		servidor.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ServidorDto>> findAll() {		
		List<Servidor> list = servidor.buscarTodos();
		List<ServidorDto> listDto = list.stream().map(obj -> new ServidorDto(obj.getId(), obj.getNome(), obj.getCpf()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	

}
