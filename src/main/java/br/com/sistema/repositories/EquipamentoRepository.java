package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.Equipamento;
@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer>{

}
