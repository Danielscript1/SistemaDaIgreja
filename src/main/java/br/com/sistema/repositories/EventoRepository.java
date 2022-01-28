package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{

}
