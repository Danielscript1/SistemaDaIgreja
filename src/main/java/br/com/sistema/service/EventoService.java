package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.Evento;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.EventoDTO;
import br.com.sistema.repositories.EventoRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	//buscar todos os elementos associados
	
		public List<Evento> findAll() {
					
			return eventoRepository.findAll();
		}
		
		//buscar igreja pelo id
		public Evento find(Integer id) {
		
		Optional<Evento> evento = eventoRepository.findById(id);
		
		return evento.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Evento.class.getName()));
		}
		
		//inserir
		@Transactional
		public Evento insert(Evento obj) {
			obj.setId(null);
			
			
			
			
			
			obj = eventoRepository.save(obj);
			//carteiraRepository.saveAll(obj.getCarteiraMembro());
			
			return obj;
		}
		
		//atualizar
				public Evento update( Evento obj,Integer id) {
				//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
				Evento newObj = find(obj.getId());//pegar meus dados do banco
				updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
				return eventoRepository.save(newObj);
			}
			//minha função auxiliar que ataulizar os dados
			private void updateData(Evento newObj, Evento obj) {
				//atualizar meu newObj com base nesse novos obj
				newObj.setNomeEvento(obj.getNomeEvento());
				newObj.setDescricao(obj.getDescricao());
			}
			
			//deletar
			public void delete(Integer id) {
				try {
					find(id);//verifcar se esse id existe
				    eventoRepository.deleteById(id);
					}catch(DataIntegrityViolationException e) {
						throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
					}
					
				}

			public Evento fromDto(EventoDTO objDto) {
				
			
				Evento evento = new Evento(null, objDto.getNomeEvento(), objDto.getDescricaoEvento(),objDto.getIgreja());
				evento.setIgreja(evento.getIgreja());
				return evento;
			}
			
		
}
