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

import br.com.sistema.domain.Filias;
import br.com.sistema.dto.FiliasDTO;
import br.com.sistema.service.FiliasService;

@RestController
@RequestMapping(value="/filias")
public class FiliasResource {
	
	@Autowired
	private FiliasService filiasService;
	
	// listando todos associados
	@GetMapping
	public ResponseEntity<List<Filias>> findAll() {
		List<Filias> filias = filiasService.findAll();
		return ResponseEntity.ok().body(filias);
	}

	// buscar Ata pelo id

	@GetMapping(value = "/{id}")
	public ResponseEntity<Filias> buscarId(@PathVariable Integer id) {
		Filias filias = filiasService.find(id);
		return ResponseEntity.ok().body(filias);
	}

	// insert processo de execução
	@PostMapping
	public ResponseEntity<Filias> insert(@Validated @RequestBody FiliasDTO objDto) {

		Filias obj = filiasService.fromDto(objDto);
		
		obj = filiasService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualizar
	@PutMapping(value = "/{id}")
	public ResponseEntity<Filias> update(@Validated @RequestBody FiliasDTO objDto, @PathVariable Integer id) {
		Filias obj = filiasService.fromDto(objDto);
		obj.setId(id);// garantiar que vem o id desejado
		obj = filiasService.update(obj, obj.getId());
		return ResponseEntity.noContent().build();
	}

	// deletar
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Filias> deletar(@PathVariable Integer id) {
		filiasService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
