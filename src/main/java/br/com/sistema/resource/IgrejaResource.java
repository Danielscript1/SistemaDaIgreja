package br.com.sistema.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.service.IgrejaService;

@RestController
@RequestMapping(value="/igreja")
public class IgrejaResource {
	
	@Autowired
	private IgrejaService igrejaService;
	
	//listando todos associados
	@GetMapping
	public ResponseEntity<List<Igreja>> findAll() {
		List<Igreja> igreja = igrejaService.findAll();
		return ResponseEntity.ok().body(igreja);
	}
	
	
	
	//buscar igreja pelo id
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Igreja> buscarId(@PathVariable Integer id) {
		Igreja igreja = igrejaService.find(id);
		return ResponseEntity.ok().body(igreja);
	}
	
	
	//buscar Igreja por email
		@GetMapping(value="/email")
		public ResponseEntity<Igreja> find(@RequestParam(value="value") String email) {
			Igreja obj = igrejaService.findByEmail(email);
			return ResponseEntity.ok().body(obj);
		}
		
		//insert processo de execução
		@PostMapping
		public ResponseEntity<Igreja> insert(@Validated @RequestBody IgrejaDTO  objDto){ 
			
			Igreja obj = igrejaService.fromDto(objDto);
			obj = igrejaService.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		//atualizar
		@PutMapping(value="/{id}")
		public ResponseEntity<Igreja> update(@Validated @RequestBody IgrejaDTO objDto,@PathVariable Integer id) {
			Igreja obj = igrejaService.fromDto(objDto);
			obj.setId(id);//garantiar que vem o id desejado 
			obj = igrejaService.update(obj, obj.getId());
			return ResponseEntity.noContent().build();
		}
		
		//deletar
		@DeleteMapping(value="/{id}")
		public ResponseEntity<Igreja> deletar(@PathVariable Integer id){
			igrejaService.delete(id);
			return ResponseEntity.noContent().build();
		}
}
