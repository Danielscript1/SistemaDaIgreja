package br.com.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)//anotacao para definir herança InheritanceType.SINGLE_TABLE ou InheritanceType.JOINED
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
	private String nome;
	private String nomePastor;
	private String email;
	private Double calculoDezPorCento;
	
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
	
	//associação com igreja um pra um
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="ata_id")
	@MapsId
	private Ata ata;
	
	//associacao com endereco
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="endereco_id")
	@MapsId
	private Endereco endereco;
	
	//associação com usuario
	@OneToMany(mappedBy = "igreja")
	private List<Usuario> usuarios = new  ArrayList<>();
	
	//associação com carteira de membro
	@OneToMany(mappedBy = "igreja")
	List<CarteiraMembro> carteiraMembros = new ArrayList<>();
	
	public Igreja() {
	
	}

	public Igreja(Integer id, String nome, String nomePastor, String email, Double calculoDezPorCento, Ata ata,
			Endereco endereco) {
		
		this.id = id;
		this.nome = nome;
		this.nomePastor = nomePastor;
		this.email = email;
		this.calculoDezPorCento = calculoDezPorCento;
		this.ata = ata;
		this.endereco = endereco;
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

	public Double getCalculoDezPorCento() {
		return calculoDezPorCento;
	}

	public List<CarteiraMembro> getCarteiraMembro() {
		return carteiraMembro;
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
