package br.com.sistema.resource;

import java.net.URI;

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

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.Certificado;
import br.com.sistema.dto.CertificadoDTO;
import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.repositories.CertificadoRepository;
import br.com.sistema.service.CertificadoService;

@RestController
@RequestMapping(value="/certificado")
public class CertificadoResource {
	@Autowired
	private CertificadoService certificadoService;
	
	
	//buscar pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Certificado> buscarId(@PathVariable Integer id) {
		Certificado certificado = certificadoService.find(id);
		return ResponseEntity.ok().body(certificado);
	}
	
	// insert processo de execução
		@PostMapping
		public ResponseEntity<Certificado> insert(@Validated @RequestBody CertificadoDTO objDto,Integer id) {

			Certificado obj = certificadoService.fromDto(objDto);
			obj = certificadoService.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}

		// atualizar
		@PutMapping(value = "/{id}")
		public ResponseEntity<Certificado> update(@Validated @RequestBody CertificadoDTO objDto, @PathVariable Integer id) {
			Certificado obj = certificadoService.fromDto(objDto);
			obj.setId(id);// garantiar que vem o id desejado
			obj = certificadoService.update(obj, obj.getId());
			return ResponseEntity.noContent().build();
		}

		// deletar
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Certificado> deletar(@PathVariable Integer id) {
			certificadoService.delete(id);
			return ResponseEntity.noContent().build();
		}
	
}
