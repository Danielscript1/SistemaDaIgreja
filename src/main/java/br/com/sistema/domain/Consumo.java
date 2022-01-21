package br.com.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private Double custo;
	
	//associacao com equipamentos
	@OneToMany(mappedBy = "consumo")
	private List<Equipamento> equipamentos = new ArrayList<>();

	public Consumo() {
		
	}
	
	

	public Consumo(Integer id, String nome, Double custo) {
		
		this.id = id;
		this.nome = nome;
		this.custo = custo;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
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
		Consumo other = (Consumo) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
