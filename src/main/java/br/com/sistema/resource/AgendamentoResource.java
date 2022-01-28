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

import br.com.sistema.domain.Agendamento;
import br.com.sistema.dto.AgendamentoDTO;
import br.com.sistema.repositories.AgendamentoRepository;
import br.com.sistema.service.AgendamentoService;

@RestController
@RequestMapping(value="/agendamento")
public class AgendamentoResource {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	// listando todos associados
	@GetMapping
	public ResponseEntity<List<Agendamento>> findAll() {
		List<Agendamento> agendamento = agendamentoService.findAll();
		return ResponseEntity.ok().body(agendamento);
	}

	// buscar Ata pelo id

	@GetMapping(value = "/{id}")
	public ResponseEntity<Agendamento> buscarId(@PathVariable Integer id) {
		Agendamento agendamento = agendamentoService.find(id);
		return ResponseEntity.ok().body(agendamento);
	}

	// insert processo de execução
	@PostMapping
	public ResponseEntity<Agendamento> insert(@Validated @RequestBody AgendamentoDTO objDto) {

		Agendamento obj = agendamentoService.fromDto(objDto);
		
		obj = agendamentoService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualizar
	@PutMapping(value = "/{id}")
	public ResponseEntity<Agendamento> update(@Validated @RequestBody AgendamentoDTO objDto, @PathVariable Integer id) {
		Agendamento obj = agendamentoService.fromDto(objDto);
		obj.setId(id);// garantiar que vem o id desejado
		obj = agendamentoService.update(obj, obj.getId());
		return ResponseEntity.noContent().build();
	}

	// deletar
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Agendamento> deletar(@PathVariable Integer id) {
		agendamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
