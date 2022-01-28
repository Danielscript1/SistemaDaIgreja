package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.CarteiraMembro;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.CarteiraDTO;
import br.com.sistema.repositories.CarteiraRepository;
import br.com.sistema.repositories.IgrejaRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;

@Service
public class CarteiraService {
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	@Autowired
	private IgrejaRepository repo;
	
	//buscar todos os elementos associados
	
	public List<CarteiraMembro> findAll() {
				
		return carteiraRepository.findAll();
	}
	
	
	
		//buscar igreja pelo id
		public CarteiraMembro find(Integer id) {
		
		Optional<CarteiraMembro> carteira = carteiraRepository.findById(id);
		
		return carteira.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + CarteiraMembro.class.getName()));
		}
		
		
		//inserir
		@Transactional
		public CarteiraMembro insert(CarteiraMembro obj) {
			obj.setId(null);
			obj = carteiraRepository.save(obj);
			return obj;
		}
		
		//update
		public CarteiraMembro update( CarteiraMembro obj,Integer id) {
			//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
			CarteiraMembro newObj = find(obj.getId());//pegar meus dados do banco
			updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
			return carteiraRepository.save(newObj);
		}
		//minha função auxiliar que ataulizar os dados
		private void updateData(CarteiraMembro newObj, CarteiraMembro obj) {
			//atualizar meu newObj com base nesse novos obj
			newObj.setNome(obj.getNome());
			newObj.setDataExpedicao(obj.getDataExpedicao());
			newObj.setAdesaoMinisterio(obj.getAdesaoMinisterio());
		}
		
		//deletar
		public void delete(Integer id) {
			try {
				find(id);//verifcar se esse id existe
			    carteiraRepository.deleteById(id);
				}catch(DataIntegrityViolationException e) {
					throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
				}
				
			}



		public CarteiraMembro fromDto(CarteiraDTO objDto) {
			
			CarteiraMembro membro = new CarteiraMembro(null, objDto.getNomeCarteira(), objDto.getDataExpedição(), objDto.getAdesãoMinisterio(), objDto.getCertificado(), objDto.getIgreja());
			
			//Optional<Igreja> id = repo.findById(membro.getIgreja().getId());
			//membro.setIgreja(objDto.getIgreja());
		
			return membro;
		}
		
		
		
		
		
}
