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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class CarteiraMembro implements Serializable{
	/**Checklist para criar entidades:
	o Atributos básicos
	o Associações (inicie as coleções)
	o Construtores (não inclua coleções no construtor com parâmetros)
	o Getters e setters
	o hashCode e equals (implementação padrão: somente id)
	o Serializable (padrão: 1L)
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private Date dataExpedicao;
	private Date AdesaoMinisterio;
	
	//associação
	@ManyToOne
	@JoinColumn(name="certificado_id")
	private Certificado certificado;
	
	//muitos para um
	@ManyToOne
	@JoinColumn(name="igreja_id")
	@JsonIgnore
	private Igreja igreja;

	//mapeamento com usuario ->uma carteira de membro conhecer o usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	@JsonIgnore
	private Usuario usuario;

	
	public CarteiraMembro() {
		
	}



	public CarteiraMembro(Integer id, String nome, Date dataExpedicao, Date adesaoMinisterio, Certificado certificado,
			Igreja igreja/*,Usuario usuario*/) {
		
		this.id = id;
		this.nome = nome;
		this.dataExpedicao = (dataExpedicao == null)?null:dataExpedicao;
		this.AdesaoMinisterio = (adesaoMinisterio == null)?null: adesaoMinisterio;
		this.setCertificado(certificado);
		this.setIgreja(igreja);
		//this.usuario = (usuario == null)?null:usuario;
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



	public Date getDataExpedicao() {
		return dataExpedicao;
	}



	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}



	public Date getAdesaoMinisterio() {
		return AdesaoMinisterio;
	}



	public void setAdesaoMinisterio(Date adesaoMinisterio) {
		AdesaoMinisterio = adesaoMinisterio;
	}



	public Certificado getCertificado() {
		return certificado;
	}



	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}



	public Igreja getIgreja() {
		return igreja;
	}



	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}
	
	
	/*public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/



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
		CarteiraMembro other = (CarteiraMembro) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
