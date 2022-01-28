package br.com.sistema.dto;

public class ConsumoDTO {
	
	private String nomeCusto;
	private Double custo;
	
	
	public ConsumoDTO() {
		
	}
	
	public ConsumoDTO(ConsumoDTO objDto) {
			
		}

	public String getNomeCusto() {
		return nomeCusto;
	}

	public void setNomeCusto(String nomeCusto) {
		this.nomeCusto = nomeCusto;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
		
	
	
}
