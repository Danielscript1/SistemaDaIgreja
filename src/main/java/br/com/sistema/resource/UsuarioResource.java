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

import br.com.sistema.domain.Usuario;
import br.com.sistema.dto.UsuarioDTO;
import br.com.sistema.service.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//listando todos associados
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuario = usuarioService.findAll();
		return ResponseEntity.ok().body(usuario);
	}
	
	
	
	//buscar usuario pelo id
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> buscarId(@PathVariable Integer id) {
		Usuario usuario = usuarioService.find(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	
	//buscar Usuario por email
		@GetMapping(value="/email")
		public ResponseEntity<Usuario> find(@RequestParam(value="value") String email) {
			Usuario obj = usuarioService.findByEmail(email);
			return ResponseEntity.ok().body(obj);
		}
		
		//insert processo de execução
		@PostMapping
		public ResponseEntity<Usuario> insert(@Validated @RequestBody UsuarioDTO  objDto){ 
			
			Usuario obj = usuarioService.fromDto(objDto);
			obj = usuarioService.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		//atualizar
		@PutMapping(value="/{id}")
		public ResponseEntity<Usuario> update(@Validated @RequestBody UsuarioDTO objDto,@PathVariable Integer id) {
			Usuario obj = usuarioService.fromDto(objDto);
			obj.setId(id);//garantiar que vem o id desejado 
			obj = usuarioService.update(obj, obj.getId());
			return ResponseEntity.noContent().build();
		}
		
		//deletar
		@DeleteMapping(value="/{id}")
		public ResponseEntity<Usuario> deletar(@PathVariable Integer id){
			usuarioService.delete(id);
			return ResponseEntity.noContent().build();
		}
}
