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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.Evento;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.EventoDTO;
import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.service.EventoService;

@RestController
@RequestMapping(value="/evento")
public class EventoResource {
	
	
	@Autowired
	private EventoService eventoService;
	
	//listando todos associados
	@GetMapping
	public ResponseEntity<List<Evento>> findAll() {
		List<Evento> evento = eventoService.findAll();
		return ResponseEntity.ok().body(evento);
	}
	
	// buscar Ata pelo id

		@GetMapping(value = "/{id}")
		public ResponseEntity<Evento> buscarId(@PathVariable Integer id) {
			Evento evento = eventoService.find(id);
			return ResponseEntity.ok().body(evento);
		}
		
		

		//insert processo de execução
				@PostMapping
				public ResponseEntity<Evento> insert(@Validated @RequestBody EventoDTO  objDto){ 
					
					Evento obj = eventoService.fromDto(objDto);
					obj = eventoService.insert(obj);
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
					return ResponseEntity.created(uri).build();
				}
	
				//atualizar
				@PutMapping(value="/{id}")
				public ResponseEntity<Evento> update(@Validated @RequestBody EventoDTO objDto,@PathVariable Integer id) {
					Evento obj = eventoService.fromDto(objDto);
					obj.setId(id);//garantiar que vem o id desejado 
					obj = eventoService.update(obj, obj.getId());
					return ResponseEntity.noContent().build();
				}
				
				//deletar
				@DeleteMapping(value="/{id}")
				public ResponseEntity<Evento> deletar(@PathVariable Integer id){
					eventoService.delete(id);
					return ResponseEntity.noContent().build();
				}
				
}
