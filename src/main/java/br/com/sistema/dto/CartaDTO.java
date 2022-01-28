package br.com.sistema.dto;

import java.util.Date;

import br.com.sistema.domain.Usuario;

public class CartaDTO {
	
	private String nomeCarta;
	private Date dataRecomedacao;
	private String nomePastor;
	private String nomeSecretario;
	private Usuario usuario;
	
	private Integer usuarioId;
	

	public CartaDTO() {
		
	}
	
	public CartaDTO(CartaDTO objDto) {
			
		}
	
	
	
	
	
	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNomePastor() {
		return nomePastor;
	}

	public void setNomePastor(String nomePastor) {
		this.nomePastor = nomePastor;
	}

	public String getNomeSecretario() {
		return nomeSecretario;
	}

	public void setNomeSecretario(String nomeSecretario) {
		this.nomeSecretario = nomeSecretario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNomeCarta() {
		return nomeCarta;
	}

	public void setNomeCarta(String nomeCarta) {
		this.nomeCarta = nomeCarta;
	}

	public Date getDataRecomedacao() {
		return dataRecomedacao;
	}

	public void setDataRecomedacao(Date dataRecomedacao) {
		this.dataRecomedacao = dataRecomedacao;
	}
	
	
	
}
