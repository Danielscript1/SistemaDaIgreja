package br.com.sistema.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.CartaRecomendacao;
import br.com.sistema.domain.CarteiraMembro;
import br.com.sistema.domain.Filias;
import br.com.sistema.domain.Igreja;
import br.com.sistema.domain.Usuario;
import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.repositories.AtaRepository;
import br.com.sistema.repositories.CartaRecomendacaoRepository;
import br.com.sistema.repositories.CarteiraRepository;
import br.com.sistema.repositories.IgrejaRepository;
import br.com.sistema.repositories.UsuarioRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;
@Service
public class IgrejaService {
	
	@Autowired
	private IgrejaRepository igrejaRepository;
	@Autowired
	private AtaRepository ataRepository;
	@Autowired
	private IgrejaRepository repo;
	@Autowired
	private CarteiraRepository carteiraRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	//buscar todos os elementos associados
	
	public List<Igreja> findAll() {
				
		return igrejaRepository.findAll();
	}
		
	
	//buscar igreja pelo id
	public Igreja find(Integer id) {
	
	Optional<Igreja> igreja = igrejaRepository.findById(id);
	
	return igreja.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Igreja.class.getName()));
	}


	//buscar pelo email
	public Igreja findByEmail(String email) {
		Igreja igreja = igrejaRepository.findByEmail(email);
		//teste de verificação
		if(email == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado ! Id: "+igreja.getId()+", Tipo: "+Igreja.class.getName()
					);
		}
		return igreja;
	}


	

	//inserir
	@Transactional
	public Igreja insert(Igreja obj) {
		obj.setId(null);
		
		
		
		
		
		obj = igrejaRepository.save(obj);
		//carteiraRepository.saveAll(obj.getCarteiraMembro());
		
		return obj;
	}
	
	//atualizar
		public Igreja update( Igreja obj,Integer id) {
		//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
		Igreja newObj = find(obj.getId());//pegar meus dados do banco
		updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
		return igrejaRepository.save(newObj);
	}
	//minha função auxiliar que ataulizar os dados
	private void updateData(Igreja newObj, Igreja obj) {
		//atualizar meu newObj com base nesse novos obj
		newObj.setNomeIgreja(obj.getNomeIgreja());
		newObj.setEmail(obj.getEmail());
	}
	
	//deletar
	public void delete(Integer id) {
		try {
			find(id);//verifcar se esse id existe
		    igrejaRepository.deleteById(id);
			}catch(DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
			}
			
		}
	
	

	//conveter
	public Igreja fromDto(IgrejaDTO objDto) {
		
		
		

		
		
	   
	    Igreja igreja = new Igreja(null, objDto.getNomeIgreja(), objDto.getNomePastor(), objDto.getEmail(), objDto.getSalario(), null,objDto.getAta_id());
        CarteiraMembro cart = new CarteiraMembro(null, objDto.getNome(), objDto.getDataExpedição(), objDto.getAdesaoMinisterio(), null, igreja);
        
        
        	if(igreja.getAta() != null) {
        		 igreja.getCarteiraMembro().add(cart);
        	}
        	
        
        
       
		 return igreja;
	}


	

	

	


	

}
