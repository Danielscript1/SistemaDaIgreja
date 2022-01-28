package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.Filias;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.FiliasDTO;
import br.com.sistema.repositories.FiliasRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;

@Service
public class FiliasService {
	@Autowired
	private FiliasRepository filiasRepository;
	
	//buscar todos os elementos associados
	
		public List<Filias> findAll() {
					
			return filiasRepository.findAll();
		}
		
		//buscar igreja pelo id
		public Filias find(Integer id) {
		
		Optional<Filias> filias = filiasRepository.findById(id);
		
		return filias.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Filias.class.getName()));
		}
		
		//inserir
		@Transactional
		public Filias insert(Filias obj) {
			obj.setId(null);
			
			
			
			
			
			obj = filiasRepository.save(obj);
			//carteiraRepository.saveAll(obj.getCarteiraMembro());
			
			return obj;
		}
		
		//atualizar
				public Filias update( Filias obj,Integer id) {
				//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
				Filias newObj = find(obj.getId());//pegar meus dados do banco
				updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
				return filiasRepository.save(newObj);
			}
			//minha função auxiliar que ataulizar os dados
			private void updateData(Filias newObj, Filias obj) {
				//atualizar meu newObj com base nesse novos obj
				newObj.setIgreja(obj.getIgreja());
				newObj.setNomeFilial(obj.getNomeFilial());
				newObj.setQuantidadeFilial(obj.getQuantidadeFilial());
			}
			
			//deletar
			public void delete(Integer id) {
				try {
					find(id);//verifcar se esse id existe
				    filiasRepository.deleteById(id);
					}catch(DataIntegrityViolationException e) {
						throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
					}
					
				}

			public Filias fromDto(FiliasDTO objDto) {
				
				 Igreja igreja = new Igreja(1, null, null, null, null, null,null);
				Filias filias = new Filias(null, objDto.getNomeFilial(), objDto.getQuantidadeFilial(),igreja);
				//filias.setIgreja(filias.getIgreja());
				return filias;
			}
}
