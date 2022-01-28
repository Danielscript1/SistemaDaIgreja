package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.Filias;

@Repository
public interface FiliasRepository extends JpaRepository<Filias, Integer>{

}
