package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.CartaRecomendacao;
import br.com.sistema.domain.Filias;
import br.com.sistema.domain.Igreja;
import br.com.sistema.domain.Usuario;
import br.com.sistema.dto.CartaDTO;
import br.com.sistema.dto.FiliasDTO;
import br.com.sistema.repositories.CartaRecomendacaoRepository;
import br.com.sistema.repositories.FiliasRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;

@Service
public class CartaRecomendacaoService {
	
	@Autowired
	private CartaRecomendacaoRepository cartaRepository;
	
	//buscar todos os elementos associados
	
		public List<CartaRecomendacao> findAll() {
					
			return cartaRepository.findAll();
		}
		
		//buscar igreja pelo id
		public CartaRecomendacao find(Integer id) {
		
		Optional<CartaRecomendacao> carta = cartaRepository.findById(id);
		
		return carta.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + CartaRecomendacao.class.getName()));
		}
		
		//inserir
		@Transactional
		public CartaRecomendacao insert(CartaRecomendacao obj) {
			obj.setId(null);
			
			
			
			
			
			obj = cartaRepository.save(obj);
			//carteiraRepository.saveAll(obj.getCarteiraMembro());
			
			return obj;
		}
		
		//atualizar
				public CartaRecomendacao update( CartaRecomendacao obj,Integer id) {
				//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
					CartaRecomendacao newObj = find(obj.getId());//pegar meus dados do banco
				updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
				return cartaRepository.save(newObj);
			}
			//minha função auxiliar que ataulizar os dados
			private void updateData(CartaRecomendacao newObj, CartaRecomendacao obj) {
				//atualizar meu newObj com base nesse novos obj
				newObj.setIgreja(obj.getIgreja());
				newObj.setNome(obj.getNome());
				newObj.setPastor(obj.getPastor());
				newObj.setSecreatrio(obj.getSecreatrio());
				newObj.setUsuario(obj.getUsuario());
			}
			
			//deletar
			public void delete(Integer id) {
				try {
					find(id);//verifcar se esse id existe
				    cartaRepository.deleteById(id);
					}catch(DataIntegrityViolationException e) {
						throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
					}
					
				}

			public CartaRecomendacao fromDto(CartaDTO objDto) {
				
				 Igreja igreja = new Igreja(1, null, null, null, null, null,null);
				 Usuario usuario = new Usuario(objDto.getUsuarioId(), null, null, null, null, null, null, igreja, null);
				 CartaRecomendacao carta = new CartaRecomendacao(null, objDto.getNomeCarta(),objDto.getDataRecomedacao(),objDto.getNomeSecretario(),objDto.getNomePastor(),igreja,usuario);
				//carta.setIgreja(carta.getIgreja());
				 
				return carta;
			}
}
