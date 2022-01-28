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

import br.com.sistema.domain.CartaRecomendacao;
import br.com.sistema.dto.CartaDTO;
import br.com.sistema.service.CartaRecomendacaoService;

@RestController
@RequestMapping(value="/carta")
public class CartaRecomendacaoResource {
	
	@Autowired
	private CartaRecomendacaoService cartaService;
	
	// listando todos associados
	@GetMapping
	public ResponseEntity<List<CartaRecomendacao>> findAll() {
		List<CartaRecomendacao> carta = cartaService.findAll();
		return ResponseEntity.ok().body(carta);
	}

	// buscar Ata pelo id

	@GetMapping(value = "/{id}")
	public ResponseEntity<CartaRecomendacao> buscarId(@PathVariable Integer id) {
		CartaRecomendacao carta = cartaService.find(id);
		return ResponseEntity.ok().body(carta);
	}

	// insert processo de execução
	@PostMapping
	public ResponseEntity<CartaRecomendacao> insert(@Validated @RequestBody CartaDTO objDto) {

		CartaRecomendacao obj = cartaService.fromDto(objDto);
		
		obj = cartaService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// atualizar
	@PutMapping(value = "/{id}")
	public ResponseEntity<CartaRecomendacao> update(@Validated @RequestBody CartaDTO objDto, @PathVariable Integer id) {
		CartaRecomendacao obj = cartaService.fromDto(objDto);
		obj.setId(id);// garantiar que vem o id desejado
		obj = cartaService.update(obj, obj.getId());
		return ResponseEntity.noContent().build();
	}

	// deletar
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CartaRecomendacao> deletar(@PathVariable Integer id) {
		cartaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
