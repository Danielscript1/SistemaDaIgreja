package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.Igreja;
import br.com.sistema.domain.Lideres;
import br.com.sistema.dto.LideresDTO;
import br.com.sistema.repositories.LideresRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;

@Service
public class LideresService {
	
	@Autowired
	private LideresRepository lideresRepository;
	
	//buscar todos os elementos associados
	
		public List<Lideres> findAll() {
					
			return lideresRepository.findAll();
		}
		
		//buscar igreja pelo id
		public Lideres find(Integer id) {
		
		Optional<Lideres> lideres = lideresRepository.findById(id);
		
		return lideres.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Lideres.class.getName()));
		}
		
		//inserir
		@Transactional
		public Lideres insert(Lideres obj) {
			obj.setId(null);
			
			
			
			
			
			obj = lideresRepository.save(obj);
			//carteiraRepository.saveAll(obj.getCarteiraMembro());
			
			return obj;
		}
		
		//atualizar
				public Lideres update( Lideres obj,Integer id) {
				//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
				Lideres newObj = find(obj.getId());//pegar meus dados do banco
				updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
				return lideresRepository.save(newObj);
			}
			//minha função auxiliar que ataulizar os dados
			private void updateData(Lideres newObj, Lideres obj) {
				//atualizar meu newObj com base nesse novos obj
				newObj.setIgreja(obj.getIgreja());
				newObj.setNome(obj.getNome());
				newObj.setCargo(obj.getCargo());
			}
			
			//deletar
			public void delete(Integer id) {
				try {
					find(id);//verifcar se esse id existe
				    lideresRepository.deleteById(id);
					}catch(DataIntegrityViolationException e) {
						throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
					}
					
				}

			public Lideres fromDto(LideresDTO objDto) {
				
				 Igreja igreja = new Igreja(1, null, null, null, null, null,null);
				Lideres lideres = new Lideres(null, objDto.getNomeLider(), objDto.getCargo(),igreja);
				lideres.setIgreja(lideres.getIgreja());
				return lideres;
			}
}
