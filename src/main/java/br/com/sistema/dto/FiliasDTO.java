package br.com.sistema.dto;

public class FiliasDTO {
	
	private String nomeFilial;
	private Integer quantidadeFilial;
	
	public FiliasDTO() {
		
	}
	
	public FiliasDTO(FiliasDTO objDto) {
		
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public Integer getQuantidadeFilial() {
		return quantidadeFilial;
	}

	public void setQuantidadeFilial(Integer quantidadeFilial) {
		this.quantidadeFilial = quantidadeFilial;
	}
	
	
	
}
