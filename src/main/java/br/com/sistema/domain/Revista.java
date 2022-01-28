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
@Entity
public class Revista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nomeRevista;
	private String descricao;
	private String urlImagem;
	private Date inicioCiclo;
	private Date fimCiclo;
	
	//mapeamento com igreja
	@ManyToOne
	@JoinColumn(name="igreja_id")
	private Igreja igreja;

	public Revista() {
		
	}

	public Revista(Integer id, String nomeRevista, String descricao, String urlImagem, Date inicioCiclo, Date fimCiclo,
			Igreja igreja) {
		
		this.id = id;
		this.nomeRevista = nomeRevista;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
		this.inicioCiclo = inicioCiclo;
		this.fimCiclo = fimCiclo;
		this.igreja = igreja;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeRevista() {
		return nomeRevista;
	}

	public void setNomeRevista(String nomeRevista) {
		this.nomeRevista = nomeRevista;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public Date getInicioCiclo() {
		return inicioCiclo;
	}

	public void setInicioCiclo(Date inicioCiclo) {
		this.inicioCiclo = inicioCiclo;
	}

	public Date getFimCiclo() {
		return fimCiclo;
	}

	public void setFimCiclo(Date fimCiclo) {
		this.fimCiclo = fimCiclo;
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
		Revista other = (Revista) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
