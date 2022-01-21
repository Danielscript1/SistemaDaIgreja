package br.com.sistema.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private String descricao;
	
	//associação com igreja um para um
	//Associações (inicie as coleções)
	@OneToOne(mappedBy = "ata",cascade = CascadeType.ALL)
	private Igreja igreja;

	public Ata() {
		
	}

	public Ata(Integer id, String nome, String descricao, Igreja igreja) {
	
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.igreja = igreja;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		Ata other = (Ata) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
