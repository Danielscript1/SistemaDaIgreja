package br.com.sistema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.Igreja;
@Repository
public interface AtaRepository extends JpaRepository<Ata, Integer>{
	
	
	
	
}
