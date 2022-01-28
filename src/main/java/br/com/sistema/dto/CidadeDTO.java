package br.com.sistema.dto;

import br.com.sistema.domain.Cidade;

public class CidadeDTO {
	
	private Integer id;
	private String nomeCidade;
	
public CidadeDTO() {
		
	}

	public CidadeDTO(Cidade obj) {
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	
}
