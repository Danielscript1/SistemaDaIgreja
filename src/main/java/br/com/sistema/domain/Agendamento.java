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
public class Agendamento implements Serializable{
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
	private String nomeAgendamento;
	private Date data;
	
	//associação com igreja muitos pra um
	@ManyToOne
	@JoinColumn(name="igreja_id")
	@JsonIgnore
	private Igreja igreja;

	public Agendamento() {
		
	}

	public Agendamento(Integer id, String nomeAgendamento, Date data, Igreja igreja) {
		
		this.id = id;
		this.nomeAgendamento = nomeAgendamento;
		this.data = data;
		this.igreja = igreja;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAgendamento() {
		return nomeAgendamento;
	}

	public void setNomeAgendamento(String nomeAgendamento) {
		this.nomeAgendamento = nomeAgendamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		Agendamento other = (Agendamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
