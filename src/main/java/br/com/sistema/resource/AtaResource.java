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

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.repositories.IgrejaRepository;
import br.com.sistema.service.AtaService;
import br.com.sistema.service.IgrejaService;
@RestController
@RequestMapping(value="/ata")
public class AtaResource {

	@Autowired
	private AtaService ataService;

	@Autowired
	private IgrejaService igrejaService;
	

	// buscar Ata pelo id

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ata> buscarId(@PathVariable Integer id) {
		Ata ata = ataService.find(id);
		return ResponseEntity.ok().body(ata);
	}

	

	// insert processo de execução
	@PostMapping
	public ResponseEntity<Ata> insert(@Validated @RequestBody IgrejaDTO objDto,Integer id) {

		Ata obj = ataService.fromDto(objDto);
		obj = ataService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualizar
	@PutMapping(value = "/{id}")
	public ResponseEntity<Ata> update(@Validated @RequestBody IgrejaDTO objDto, @PathVariable Integer id) {
		Ata obj = ataService.fromDto(objDto);
		obj.setId(id);// garantiar que vem o id desejado
		obj = ataService.update(obj, obj.getId());
		return ResponseEntity.noContent().build();
	}

	// deletar
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Ata> deletar(@PathVariable Integer id) {
		ataService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
