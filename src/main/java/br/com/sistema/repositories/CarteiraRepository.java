package br.com.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.CartaRecomendacao;
import br.com.sistema.domain.CarteiraMembro;
@Repository
public interface CarteiraRepository extends JpaRepository<CarteiraMembro, Integer>{



}
