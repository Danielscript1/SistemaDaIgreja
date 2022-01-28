package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.CarteiraMembro;
import br.com.sistema.domain.Consumo;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.ConsumoDTO;
import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.repositories.ConsumoRepository;
import br.com.sistema.repositories.UsuarioRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;
@Service
public class ConsumoService {
	@Autowired
	private ConsumoRepository consumoRepository;
	//buscar todos os elementos associados
	
	public List<Consumo> findAll() {
				
		return consumoRepository.findAll();
	}
		
	
	//buscar consumo pelo id
	public Consumo find(Integer id) {
	
	Optional<Consumo> consumo = consumoRepository.findById(id);
	
	return consumo.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Consumo.class.getName()));
	}


	

	//inserir
	@Transactional
	public Consumo insert(Consumo obj) {
		obj.setId(null);
		
		
		
		
		
		obj = consumoRepository.save(obj);
		//carteiraRepository.saveAll(obj.getCarteiraMembro());
		
		return obj;
	}
	
	//atualizar
		public Consumo update( Consumo obj,Integer id) {
		//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
		Consumo newObj = find(obj.getId());//pegar meus dados do banco
		updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
		return consumoRepository.save(newObj);
	}
	//minha função auxiliar que ataulizar os dados
	private void updateData(Consumo newObj, Consumo obj) {
		//atualizar meu newObj com base nesse novos obj
		newObj.setNome(obj.getNome());
		newObj.setCusto(obj.getCusto());
	}
	
	//deletar
	public void delete(Integer id) {
		try {
			find(id);//verifcar se esse id existe
			consumoRepository.deleteById(id);
			}catch(DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
			}
			
		}
	
	

	//conveter
	public Consumo fromDto(ConsumoDTO objDto) {
		
		
		

		
		
	   
	    Consumo consumo = new Consumo(null, objDto.getNomeCusto(), objDto.getCusto());
        //CarteiraMembro cart = new CarteiraMembro(null, objDto.getNome(), objDto.getDataExpedição(), objDto.getAdesaoMinisterio(), null, consumo);
        
        
        
        	
        
        
       
		 return consumo;
	}


	
}
