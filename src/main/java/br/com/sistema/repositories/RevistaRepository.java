package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.Revista;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Integer>{

}
