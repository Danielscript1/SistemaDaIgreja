package br.com.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.Cidade;
import br.com.sistema.domain.Endereco;
import br.com.sistema.domain.Igreja;
import br.com.sistema.domain.Usuario;
import br.com.sistema.dto.UsuarioDTO;
import br.com.sistema.repositories.EnderecoRepository;
import br.com.sistema.repositories.UsuarioRepository;
import br.com.sistema.service.exception.DataIntegrityViolationException;
import br.com.sistema.service.exception.ObjectNotFoundException;
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	//buscar todos os elementos associados
	
	public List<Usuario> findAll() {
				
		return usuarioRepository.findAll();
	}
		
	
	//buscar usuario pelo id
	public Usuario find(Integer id) {
	
	Optional<Usuario> usuario = usuarioRepository.findById(id);
	
	return usuario.orElseThrow(() -> new ObjectNotFoundException( //lançar minha exception pensonalizada
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}


	//buscar pelo email
	public Usuario findByEmail(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		//teste de verificação
		if(email == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado ! Id: "+usuario.getId()+", Tipo: "+Usuario.class.getName()
					);
		}
		return usuario;
	}


	

	//inserir
	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		
		
		
		
		
		obj = usuarioRepository.save(obj);
		//carteiraRepository.saveAll(obj.getCarteiraMembro());
		enderecoRepository.saveAll(obj.getEnderecos());
		
		return obj;
	}
	
	//atualizar
		public Usuario update( Usuario obj,Integer id) {
		//instancia um cliente apartir do banco de dados, para ele trazer os objetos ja existente ,junto com dto
		Usuario newObj = find(obj.getId());//pegar meus dados do banco
		updateData(newObj,obj);//atualizar meus dados com base nos dados que vieram do obj
		return usuarioRepository.save(newObj);
	}
	//minha função auxiliar que ataulizar os dados
	private void updateData(Usuario newObj, Usuario obj) {
		//atualizar meu newObj com base nesse novos obj
		newObj.setNome(obj.getNome());
		newObj.setNascimento(obj.getNascimento());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		newObj.setPai(obj.getMae());
		newObj.setMae(obj.getMae());
		
	}
	
	//deletar
	public void delete(Integer id) {
		try {
			find(id);//verifcar se esse id existe
		    usuarioRepository.deleteById(id);
			}catch(DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException("não e possivel excluir porque há entidades relacionadas");
			}
			
		}
	
	

	//conveter
	public Usuario fromDto(UsuarioDTO objDto) {
		
		
		

		
		
		Igreja igreja = new Igreja(1, null, null, null, null, null, null);
	    Usuario usuario = new Usuario(null, objDto.getNomeUsuario(), objDto.getDataNascimento(), objDto.getPai(), objDto.getMae(), objDto.getSenha(),objDto.getEmail(),igreja,objDto.getUsuario());
	  //cidade
		Cidade cidade = new Cidade(objDto.getCidadeId(),null,null);
		//Endereco
		Endereco end = new Endereco(null,objDto.getLogradouro(),objDto.getNumeroCasa(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),usuario,cidade);
        
		
		usuario.getEnderecos().add(end);
        
//        	if(usuario.getIgreja() != null) {
//        		 usuario.getIgreja().getUsuarios().add(usuario);
//        	}
        	
	    usuario.getTelefones().add(objDto.getTelefone1());
		//fazendo um teste de verificação
		if(objDto.getTelefone2() != null) {
			usuario.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3() != null) {
			usuario.getTelefones().add(objDto.getTelefone3());
		}
		
        
        
       
		 return usuario;
	}


	

}
