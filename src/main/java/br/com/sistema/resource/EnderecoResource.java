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

import br.com.sistema.domain.Endereco;
import br.com.sistema.domain.Igreja;

import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.service.EnderecoService;
import br.com.sistema.service.IgrejaService;

@RestController
@RequestMapping(value="/endereco")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;
	
	
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> buscarId(@PathVariable Integer id) {
		Endereco endereco = enderecoService.find(id);
		return ResponseEntity.ok().body(endereco);
	}
	
	
}
