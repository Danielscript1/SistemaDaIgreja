package br.com.sistema.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.Agendamento;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.AgendamentoDTO;
import br.com.sistema.repositories.AgendamentoRepository;
import br.com.sistema.repositories.IgrejaRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;
@Service
public class AgendamentoService {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private IgrejaRepository repo;
	
	//buscar todos os elementos associados
	
		public List<Agendamento> findAll() {
					
			return agendamentoRepository.findAll();
		}
		
		//buscar igreja pelo id
		public Agendamento find(Integer id) {
		
		Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
		
		return agendamento.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Agendamento.class.getName()));
		}
		
		//inserir
		@Transactional
		public Agendamento insert(Agendamento obj) {
			obj.setId(null);
			
			
		
			//obj.setId(obj.getIgreja().getId());
			//obj = agendamentoRepository.save(obj);
			//carteiraRepository.saveAll(obj.getCarteiraMembro());
			
			obj = agendamentoRepository.save(obj);
			//repo.save(obj.getIgreja());
			return obj;
		}
		
		//atualizar
				public Agendamento update( Agendamento obj,Integer id) {
				//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
				Agendamento newObj = find(obj.getId());//pegar meus dados do banco
				updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
				return agendamentoRepository.save(newObj);
			}
			//minha função auxiliar que ataulizar os dados
			private void updateData(Agendamento newObj, Agendamento obj) {
				//atualizar meu newObj com base nesse novos obj
				newObj.setNomeAgendamento(obj.getNomeAgendamento());
				newObj.setData(obj.getData());
				newObj.setIgreja(obj.getIgreja());
			}
			
			//deletar
			public void delete(Integer id) {
				try {
					find(id);//verifcar se esse id existe
				    agendamentoRepository.deleteById(id);
					}catch(DataIntegrityViolationException e) {
						throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
					}
					
				}

			public Agendamento fromDto(AgendamentoDTO objDto) {
				
				
				
				
				 Igreja igreja = new Igreja(1, null, null, null, null, null,null);
				//repo.findById();
				
			
				Agendamento agendamento = new Agendamento(null, objDto.getNomeAgendamento(), objDto.getAgendamentoData(),igreja);
				//agendamento.setIgreja(agendamento.getIgreja());
				 //igreja.getAgendamentos().add(agendamento);
				//agendamento.getIgreja();
				
				return agendamento;
			}
}
