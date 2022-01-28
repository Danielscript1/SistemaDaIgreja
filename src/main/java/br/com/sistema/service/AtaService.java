package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.Igreja;
import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.repositories.AtaRepository;
import br.com.sistema.repositories.IgrejaRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;
@Service
public class AtaService {
	@Autowired
	private AtaRepository ataRepository;
	@Autowired
	private IgrejaService igrejaService;
	@Autowired
	private IgrejaRepository igrejaRepository;

	//buscar pelo id
	public Ata find(Integer id) {
		Optional<Ata> ata = ataRepository.findById(id);
		
		return ata.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Ata.class.getName()));
		
	}
	
	//inserindo
	@Transactional
	public Ata insert(Ata obj) {
		obj.setId(null);
		
		obj =  ataRepository.save(obj);
		
		return obj;
	}
	
	//conversao
	public  Ata fromDto(IgrejaDTO objDto) {
		
		//Igreja igreja = new Igreja(null, objDto.getNomeIgreja(), objDto.getNomePastor(), objDto.getEmail(), objDto.getSalario(), null,null);
		//Igreja igreja = igrejaRepository.findById(id);
		 Ata ata = new Ata(null,objDto.getNome(),objDto.getDescricao());
		
		 //ata.setId(igreja.get().getId());
		
		// ata.setId(igreja.getId());
		 
			
		return ata;
	}

	public  void delete(Integer id) {
		try {
			find(id);//verifcar se esse id existe
		    ataRepository.deleteById(id);
			}catch(DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
			}
		
	}

	//atualizar
			public Ata update( Ata obj,Integer id) {
			//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
			Ata newObj = find(obj.getId());//pegar meus dados do banco
			updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
			return ataRepository.save(newObj);
		}
		//minha função auxiliar que ataulizar os dados
		private void updateData(Ata newObj, Ata obj) {
			//atualizar meu newObj com base nesse novos obj
			newObj.setNome(obj.getNome());
			newObj.setDescricao(obj.getDescricao());
		}
	
	
	
	
	
	

}
