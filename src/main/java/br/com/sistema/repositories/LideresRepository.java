package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.Lideres;

@Repository
public interface LideresRepository extends JpaRepository<Lideres, Integer>{

}
