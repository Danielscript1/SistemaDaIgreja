package br.com.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
public class Igreja implements Serializable{
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
	private String nomeIgreja;
	private String nomePastor;
	private String email;
	
	
	//associação com carteiraMembro
	@OneToMany(mappedBy = "igreja")
	private List<CarteiraMembro> carteiraMembro = new ArrayList<>();
	
	//associação com evento
	@OneToMany(mappedBy = "igreja")
	private List<Evento> eventos = new ArrayList<>();
	
	//associação com agendamento
	@OneToMany(mappedBy = "igreja")
	private List<Agendamento> agendamentos = new ArrayList<>();
	
	//associacao com equipamentos
	@OneToMany(mappedBy = "igreja")
	private List<Equipamento> equipamentos = new ArrayList<>();
	
	//associação com lideres
	@OneToMany(mappedBy = "igreja")
	private List<Lideres> lideres = new ArrayList<>();
	
	
	
	@ManyToOne
	@JoinColumn(name="endereco_id")
	@JsonIgnore
	private Endereco endereco;
	
	//associação com usuario
	@OneToMany(mappedBy = "igreja")
	private List<Usuario> usuarios = new  ArrayList<>();
	
	//associação com carteira de membro
//	@OneToMany(mappedBy = "igreja")
//	@JsonIgnore
//	List<CarteiraMembro> carteiraMembros = new ArrayList<>();
	
	//mapeamento com revista
	//associação com carteira de membro
	@OneToMany(mappedBy = "igreja")
	List<Revista> revistas = new ArrayList<>();
		
	
	//MAPEAMENTO 
	@OneToMany(mappedBy = "igreja")
	List<Filias> filias = new ArrayList<>();
	
	//mapeamento com carta de recomendacao
	@OneToMany(mappedBy = "igreja")
	List<CartaRecomendacao> cartaRecomendacao = new ArrayList<>();
	
	
	//endereco associação
	
	@ManyToOne
	@JoinColumn(name="ata_id")
	private Ata ata;
	
	private Double salario;
	
	public Igreja() {
	
	}

	public Igreja(Integer id, String nomeIgreja, String nomePastor,  String email, Double salario,Endereco endereco,
			Ata ata) {
		
		this.id = id;
		this.nomeIgreja = nomeIgreja;
		this.nomePastor = nomePastor;
		this.email = email;
		this.salario = salario;
		this.endereco = (endereco==null)?null:endereco;
		this.setAta(ata);
		
	}

	
	
	

	
	
	public List<CarteiraMembro> getCarteiraMembro() {
		return carteiraMembro;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeIgreja() {
		return nomeIgreja;
	}

	public void setNomeIgreja(String nomeIgreja) {
		this.nomeIgreja = nomeIgreja;
	}

	public String getNomePastor() {
		return nomePastor;
	}

	public void setNomePastor(String nomePastor) {
		this.nomePastor = nomePastor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ata getAta() {
		return ata;
	}

	public void setAta(Ata ata) {
		this.ata = ata;
	}
	
	



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	public List<Evento> getEventos() {
		return eventos;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public List<Lideres> getLideres() {
		return lideres;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
	
	public List<Revista> getRevistas() {
		return revistas;
	}
	
	

	public List<Filias> getFilias() {
		return filias;
	}
	
	

	public List<CartaRecomendacao> getCartaRecomendacao() {
		return cartaRecomendacao;
	}
	
	

	


	//metodo calculo 10%
	public Double getCalculoDezPorCento() {
		Double soma = 0.0;
		return soma = getSalario()*10/100;
	
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
		Igreja other = (Igreja) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
