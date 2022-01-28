package br.com.sistema.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
public class Filias {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nomeFilial;
	private Integer quantidadeFilial;
	
	
	//ASSOCIACAO COM IGREJA
	@ManyToOne
	@JoinColumn(name="igreja_id")
	@JsonIgnore
	private Igreja igreja;
	
	public Filias() {
		
	}

	public Filias(Integer id, String nomeFilial, Integer quantidadeFilial, Igreja igreja) {
		super();
		this.id = id;
		this.nomeFilial = nomeFilial;
		this.quantidadeFilial = quantidadeFilial;
		this.igreja = igreja;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public Integer getQuantidadeFilial() {
		return quantidadeFilial;
	}

	public void setQuantidadeFilial(Integer quantidadeFilial) {
		this.quantidadeFilial = quantidadeFilial;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filias other = (Filias) obj;
		return Objects.equals(id, other.id);
	}

	
	
	

	
	
	
	


	


	



	
	
	
}
