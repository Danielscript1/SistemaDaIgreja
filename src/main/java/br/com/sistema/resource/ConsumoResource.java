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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sistema.domain.Consumo;
import br.com.sistema.dto.ConsumoDTO;
import br.com.sistema.service.ConsumoService;

@RestController
@RequestMapping(value="/consumo")
public class ConsumoResource {
	
	

		
		@Autowired
		private ConsumoService consumoService;
		
		//listando todos associados
		@GetMapping
		public ResponseEntity<List<Consumo>> findAll() {
			List<Consumo> consumo = consumoService.findAll();
			return ResponseEntity.ok().body(consumo);
		}
		
		
		
		//buscar consumo pelo id
		
		@GetMapping(value="/{id}")
		public ResponseEntity<Consumo> buscarId(@PathVariable Integer id) {
			Consumo consumo = consumoService.find(id);
			return ResponseEntity.ok().body(consumo);
		}
		
		
			
			//insert processo de execução
			@PostMapping
			public ResponseEntity<Consumo> insert(@Validated @RequestBody ConsumoDTO  objDto){ 
				
				Consumo obj = consumoService.fromDto(objDto);
				obj = consumoService.insert(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
				return ResponseEntity.created(uri).build();
			}
			
			//atualizar
			@PutMapping(value="/{id}")
			public ResponseEntity<Consumo> update(@Validated @RequestBody ConsumoDTO objDto,@PathVariable Integer id) {
				Consumo obj = consumoService.fromDto(objDto);
				obj.setId(id);//garantiar que vem o id desejado 
				obj = consumoService.update(obj, obj.getId());
				return ResponseEntity.noContent().build();
			}
			
			//deletar
			@DeleteMapping(value="/{id}")
			public ResponseEntity<Consumo> deletar(@PathVariable Integer id){
				consumoService.delete(id);
				return ResponseEntity.noContent().build();
			}
	
}
