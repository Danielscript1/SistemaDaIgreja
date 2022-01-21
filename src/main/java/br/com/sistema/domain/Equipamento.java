package br.com.sistema.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Equipamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private Integer	quantidade;
	
	//associacao com igreja
	@ManyToOne
	@JoinColumn(name="igreja_id")
	private Igreja igreja;
	
	//associacao com consumo
	@ManyToOne
	@JoinColumn(name="consumo_id")
	private Consumo consumo;

	public Equipamento() {
		
	}

	public Equipamento(Integer id, String nome, Integer quantidade, Igreja igreja, Consumo consumo) {
		
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.igreja = igreja;
		this.consumo = consumo;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
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
		Equipamento other = (Equipamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
