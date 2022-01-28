package br.com.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.domain.Certificado;
@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Integer>{

}
