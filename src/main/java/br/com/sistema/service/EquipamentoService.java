package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.Equipamento;
import br.com.sistema.domain.Evento;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.EquipamentoDTO;
import br.com.sistema.dto.EventoDTO;
import br.com.sistema.repositories.EquipamentoRepository;
import br.com.sistema.repositories.EventoRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;
@Service
public class EquipamentoService {
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	//buscar todos os elementos associados
	
		public List<Equipamento> findAll() {
					
			return equipamentoRepository.findAll();
		}
		
		//buscar igreja pelo id
		public Equipamento find(Integer id) {
		
		Optional<Equipamento> equipamento = equipamentoRepository.findById(id);
		
		return equipamento.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Equipamento.class.getName()));
		}
		
		//inserir
		@Transactional
		public Equipamento insert(Equipamento obj) {
			obj.setId(null);
			
			
			
			
			
			obj = equipamentoRepository.save(obj);
			//carteiraRepository.saveAll(obj.getCarteiraMembro());
			
			return obj;
		}
		
		//atualizar
				public Equipamento update( Equipamento obj,Integer id) {
				//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
				Equipamento newObj = find(obj.getId());//pegar meus dados do banco
				updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
				return equipamentoRepository.save(newObj);
			}
			//minha função auxiliar que ataulizar os dados
			private void updateData(Equipamento newObj, Equipamento obj) {
				//atualizar meu newObj com base nesse novos obj
				newObj.setIgreja(obj.getIgreja());
				newObj.setNomeEquipamento(obj.getNomeEquipamento());
				newObj.setQuantidade(obj.getQuantidade());
			}
			
			//deletar
			public void delete(Integer id) {
				try {
					find(id);//verifcar se esse id existe
				    equipamentoRepository.deleteById(id);
					}catch(DataIntegrityViolationException e) {
						throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
					}
					
				}

			public Equipamento fromDto(EquipamentoDTO objDto) {
				
				 Igreja igreja = new Igreja(1, null, null, null, null, null,null);
				Equipamento equipamento = new Equipamento(null, objDto.getNomeEquipamento(), objDto.getQuantidade(),igreja,null);
				equipamento.setIgreja(equipamento.getIgreja());
				return equipamento;
			}
	
}
