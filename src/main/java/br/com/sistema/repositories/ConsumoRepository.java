package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.Consumo;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Integer>{

}
