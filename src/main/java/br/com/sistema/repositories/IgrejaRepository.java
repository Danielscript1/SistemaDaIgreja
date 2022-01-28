package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.domain.Igreja;
@Repository
public interface IgrejaRepository extends JpaRepository<Igreja, Integer>{
	
	@Transactional(readOnly=true)
	Igreja findByEmail(String email);

}
