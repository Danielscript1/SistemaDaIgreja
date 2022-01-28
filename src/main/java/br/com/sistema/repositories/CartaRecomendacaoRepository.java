package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.CartaRecomendacao;
@Repository
public interface CartaRecomendacaoRepository extends JpaRepository<CartaRecomendacao, Integer> {

}
