package br.com.sistema.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("filias") 
public class Filias extends Igreja{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 	
	private Integer id;

	public Filias() {
		
	}

	public Filias(Integer id, String nome, String nomePastor, String email, Double calculoDezPorCento, Ata ata,
			Endereco endereco) {
		super(id, nome, nomePastor, email, calculoDezPorCento, ata, endereco);
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filias other = (Filias) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
