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

import br.com.sistema.domain.Equipamento;
import br.com.sistema.domain.Lideres;
import br.com.sistema.dto.EquipamentoDTO;
import br.com.sistema.dto.LideresDTO;
import br.com.sistema.service.EquipamentoService;
import br.com.sistema.service.LideresService;

@RestController
@RequestMapping(value="/lideres")
public class LideresResource {
	
	@Autowired
	private LideresService lideresService;
	
	//listando todos associados
	@GetMapping
	public ResponseEntity<List<Lideres>> findAll() {
		List<Lideres> lideres = lideresService.findAll();
		return ResponseEntity.ok().body(lideres);
	}
	
	// buscar Ata pelo id

		@GetMapping(value = "/{id}")
		public ResponseEntity<Lideres> buscarId(@PathVariable Integer id) {
			Lideres lideres = lideresService.find(id);
			return ResponseEntity.ok().body(lideres);
		}
		
		

		//insert processo de execução
				@PostMapping
				public ResponseEntity<Lideres> insert(@Validated @RequestBody LideresDTO  objDto){ 
					
					Lideres obj = lideresService.fromDto(objDto);
					obj = lideresService.insert(obj);
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
					return ResponseEntity.created(uri).build();
				}
	
				//atualizar
				@PutMapping(value="/{id}")
				public ResponseEntity<Lideres> update(@Validated @RequestBody LideresDTO objDto,@PathVariable Integer id) {
					Lideres obj = lideresService.fromDto(objDto);
					obj.setId(id);//garantiar que vem o id desejado 
					obj = lideresService.update(obj, obj.getId());
					return ResponseEntity.noContent().build();
				}
				
				//deletar
				@DeleteMapping(value="/{id}")
				public ResponseEntity<Lideres> deletar(@PathVariable Integer id){
					lideresService.delete(id);
					return ResponseEntity.noContent().build();
				}
}
