package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.CarteiraMembro;
import br.com.sistema.domain.Endereco;
import br.com.sistema.domain.Igreja;
import br.com.sistema.domain.Usuario;

import br.com.sistema.dto.IgrejaDTO;
import br.com.sistema.repositories.CarteiraRepository;
import br.com.sistema.repositories.EnderecoRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	//buscar todos os elementos associados
	
	public List<Endereco> findAll() {
				
		return enderecoRepository.findAll();
	}
		
	
	//buscar endereco pelo id
	public Endereco find(Integer id) {
	
	Optional<Endereco> endereco = enderecoRepository.findById(id);
	
	return endereco.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}


	


	

	

	
}
