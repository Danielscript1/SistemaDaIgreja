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

import br.com.sistema.domain.CarteiraMembro;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.CarteiraDTO;
import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.service.CarteiraService;

@RestController
@RequestMapping(value="/carteira")
public class CarteiraResouce {
	
	@Autowired
	private CarteiraService carteiraService;
	
	//listando todos associados
		@GetMapping
		public ResponseEntity<List<CarteiraMembro>> findAll() {
			List<CarteiraMembro> carteira = carteiraService.findAll();
			return ResponseEntity.ok().body(carteira);
		}
		
		
		
		//buscar igreja pelo id
		
		@GetMapping(value="/{id}")
		public ResponseEntity<CarteiraMembro> buscarId(@PathVariable Integer id) {
			CarteiraMembro carteiraMembro =carteiraService.find(id);
			return ResponseEntity.ok().body(carteiraMembro);
		}
		
		
		
			
			//insert processo de execução
			@PostMapping
			public ResponseEntity<CarteiraMembro> insert(@Validated @RequestBody CarteiraDTO  objDto){ 
				
				CarteiraMembro obj = carteiraService.fromDto(objDto);
				obj = carteiraService.insert(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
				return ResponseEntity.created(uri).build();
			}
			
			//atualizar
			@PutMapping(value="/{id}")
			public ResponseEntity<CarteiraMembro> update(@Validated @RequestBody CarteiraDTO objDto,@PathVariable Integer id) {
				CarteiraMembro obj = carteiraService.fromDto(objDto);
				obj.setId(id);//garantiar que vem o id desejado 
				obj = carteiraService.update(obj, obj.getId());
				return ResponseEntity.noContent().build();
			}
			
			//deletar
			@DeleteMapping(value="/{id}")
			public ResponseEntity<CarteiraMembro> deletar(@PathVariable Integer id){
				carteiraService.delete(id);
				return ResponseEntity.noContent().build();
			}
}
