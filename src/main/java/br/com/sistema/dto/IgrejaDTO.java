package br.com.sistema.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.CarteiraMembro;

public class IgrejaDTO implements Serializable{
	
	private static final Integer serialVersionUID = 1;
	//preenchimento igreja
	private String nomeIgreja;
	private String email;
	private String nomePastor;
	private Double salario;
	//prenchimento carteiraMembro
	private Date dataExpedição;
	private Date adesaoMinisterio;
	//preenchimento evento
	private String nomeEvento;
	private String descricao;
	//preenchimento agendamento
	private String nomeAgendamento;
	private Date dataAgendamento;
	//prenchimento equipamentos
	private String nomeEquipamento;
	private int quantidade;
	
	//prenchimento ata
	
	private String nome;
	private String descricaoAta;
	//prenchimento Endereco
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	//PRENCHIMENTO USUARIO
	private String nomeUsuario;
	private Date nascimento;
	private String emailUsuario;
	private String senha;
	private Integer tipo;
	private String pai;
	private String mae;
	//prenchimento telefone
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Ata ata_id;
	
	//certificado
	private CarteiraMembro carteiraMembro;
	
	//ESCOLHER O CODIGO DE UMA CIDADE
	private Integer cidadeId;
	
	public IgrejaDTO() {
		
	}
	
	public IgrejaDTO(IgrejaDTO  objDto) {
		
	}
	
	
	
	

	public CarteiraMembro getCarteiraMembro() {
		return carteiraMembro;
	}

	
	public void setCarteiraMembro(CarteiraMembro carteiraMembro) {
		this.carteiraMembro = carteiraMembro;
	}

	public Ata getAta_id() {
		return ata_id;
	}

	public void setAta_id(Ata ata_id) {
		this.ata_id = ata_id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getNomeIgreja() {
		return nomeIgreja;
	}

	public void setNomeIgreja(String nomeIgreja) {
		this.nomeIgreja = nomeIgreja;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomePastor() {
		return nomePastor;
	}

	public void setNomePastor(String nomePastor) {
		this.nomePastor = nomePastor;
	}

	public Date getDataExpedição() {
		return dataExpedição;
	}

	public void setDataExpedição(Date dataExpedição) {
		this.dataExpedição = dataExpedição;
	}

	public Date getAdesaoMinisterio() {
		return adesaoMinisterio;
	}

	public void setAdesaoMinisterio(Date adesaoMinisterio) {
		this.adesaoMinisterio = adesaoMinisterio;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeAgendamento() {
		return nomeAgendamento;
	}

	public void setNomeAgendamento(String nomeAgendamento) {
		this.nomeAgendamento = nomeAgendamento;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getNomeEquipamento() {
		return nomeEquipamento;
	}

	public void setNomeEquipamento(String nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNomeAta(String nome) {
		this.nome = nome;
	}

	public String getDescricaoAta() {
		return descricaoAta;
	}

	public void setDescricaoAta(String descricaoAta) {
		this.descricaoAta = descricaoAta;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	
	
}
