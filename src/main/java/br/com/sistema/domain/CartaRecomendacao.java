package br.com.sistema.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class CartaRecomendacao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private Date data;
	private String secreatrio;
	private String pastor;
	
	//associaçoes com igreja
	//associação com igreja muitos pra um
	@ManyToOne
	@JoinColumn(name="igreja_id")
	@JsonIgnore
	private Igreja igreja;
	
	//usuario
	//associação
	@ManyToOne
	@JoinColumn(name="usuario_id")
	@JsonIgnore
	private Usuario usuario;
	
	public CartaRecomendacao() {
		
	}

	public CartaRecomendacao(Integer id, String nome, Date data, String secreatrio, String pastor, Igreja igreja,Usuario usuario) {
		
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.secreatrio = secreatrio;
		this.pastor = pastor;
		this.igreja = igreja;
		this.usuario = usuario;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSecreatrio() {
		return secreatrio;
	}

	public void setSecreatrio(String secreatrio) {
		this.secreatrio = secreatrio;
	}

	public String getPastor() {
		return pastor;
	}

	public void setPastor(String pastor) {
		this.pastor = pastor;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		CartaRecomendacao other = (CartaRecomendacao) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
