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
import br.com.sistema.domain.Evento;
import br.com.sistema.dto.EquipamentoDTO;
import br.com.sistema.dto.EventoDTO;
import br.com.sistema.service.EquipamentoService;
import br.com.sistema.service.EventoService;
@RestController
@RequestMapping(value="/equipamento")
public class EquipamentoResource {
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	//listando todos associados
	@GetMapping
	public ResponseEntity<List<Equipamento>> findAll() {
		List<Equipamento> equipamento = equipamentoService.findAll();
		return ResponseEntity.ok().body(equipamento);
	}
	
	// buscar Ata pelo id

		@GetMapping(value = "/{id}")
		public ResponseEntity<Equipamento> buscarId(@PathVariable Integer id) {
			Equipamento equipamento = equipamentoService.find(id);
			return ResponseEntity.ok().body(equipamento);
		}
		
		

		//insert processo de execução
				@PostMapping
				public ResponseEntity<Equipamento> insert(@Validated @RequestBody EquipamentoDTO  objDto){ 
					
					Equipamento obj = equipamentoService.fromDto(objDto);
					obj = equipamentoService.insert(obj);
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
					return ResponseEntity.created(uri).build();
				}
	
				//atualizar
				@PutMapping(value="/{id}")
				public ResponseEntity<Equipamento> update(@Validated @RequestBody EquipamentoDTO objDto,@PathVariable Integer id) {
					Equipamento obj = equipamentoService.fromDto(objDto);
					obj.setId(id);//garantiar que vem o id desejado 
					obj = equipamentoService.update(obj, obj.getId());
					return ResponseEntity.noContent().build();
				}
				
				//deletar
				@DeleteMapping(value="/{id}")
				public ResponseEntity<Equipamento> deletar(@PathVariable Integer id){
					equipamentoService.delete(id);
					return ResponseEntity.noContent().build();
				}
				
}
