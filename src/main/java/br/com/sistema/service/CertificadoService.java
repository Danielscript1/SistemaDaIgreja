package br.com.sistema.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.Certificado;
import br.com.sistema.dto.CertificadoDTO;
import br.com.sistema.repositories.CertificadoRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;
@Service
public class CertificadoService {
	@Autowired
	private CertificadoRepository certificadoRepository;
	
	//buscar pelo id
	public Certificado find(Integer id) {
		
		Optional<Certificado> certificado = certificadoRepository.findById(id);
		
		return certificado.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Certificado.class.getName()));
	}
	
	
	//inserir pelo id
	public Certificado insert(Certificado obj) {
		obj.setId(null);
		
		obj =  certificadoRepository.save(obj);
		
		return obj;
	}
	
	//atualizar

	public Certificado update(Certificado obj, Integer id) {
		//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
		Certificado newObj = find(obj.getId());//pegar meus dados do banco
		updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
		return certificadoRepository.save(newObj);
	}
	
	//minha função auxiliar que ataulizar os dados
			private void updateData(Certificado newObj, Certificado obj) {
				//atualizar meu newObj com base nesse novos obj
				newObj.setNome(obj.getNome());
				newObj.setData(obj.getData());
			}
			
	//deletar		
	public void delete(Integer id) {
		try {
			find(id);//verifcar se esse id existe
		    certificadoRepository.deleteById(id);
			}catch(DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
			}
		
	}

	public Certificado fromDto(CertificadoDTO objDto) {
		Certificado certificado = new Certificado(null,objDto.getNome(),objDto.getData()); 
		return certificado;
	}

}
