package br.com.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sistema.domain.enums.TipoUsuario;

@Entity
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Checklist para criar entidades:
	o Atributos básicos
	o Associações (inicie as coleções)
	o Construtores (não inclua coleções no construtor com parâmetros)
	o Getters e setters
	o hashCode e equals (implementação padrão: somente id)
	o Serializable (padrão: 1L)  = e uma interface que falar que os objetos dela pode ser convetidos em bytes
	 * */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private Date nascimento;
	private String pai;
	private String mae;
	private String email;
	private String senha;
	
	//associação com igreja
	@ManyToOne
	@JoinColumn(name="igreja_id")
	@JsonIgnore
	private Igreja igreja;
	
	//associacao com endereco
	@OneToMany(mappedBy = "usuario")
	private List<Endereco> enderecos = new ArrayList<>();
	
	//associacao com telefone
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	/*Um atributo correspondente aos perfis do usuário a serem armazenados na base de dados 
	 * coloca EAGER, AUTOMATICAMENTE BUSCAR O CLIENTE ,GARANTIR QUE VEM OS PERFIL
	 * */
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();;

	public Usuario() {
		addPerfil(TipoUsuario.CLIENTE);
	}

	public Usuario(Integer id, String nome, Date nascimento, String pai, String mae, String email, String senha,
			Igreja igreja, TipoUsuario tipo) {
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.pai = pai;
		this.mae = mae;
		this.email = email;
		this.senha = senha;
		this.igreja = igreja;
		//this.tipo = tipo.getCod();
		addPerfil(TipoUsuario.CLIENTE);
	}
	
	
	
	//percorrer essa coleção, convertendo todo mundo,para o tipo enumerado perfil
		 public Set<TipoUsuario> getPerfis() {
			 return perfis.stream().map(x -> TipoUsuario.toEnum(x)).collect(Collectors.toSet());
		 }
		 //metodo para adicionar o perfil,passo um perfil como argumento e esse metodo adicionar um perfil
		 public void addPerfil(TipoUsuario perfil) {
			 perfis.add(perfil.getCod());
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
