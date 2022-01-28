package br.com.sistema.dto;

public class LideresDTO {
	
	private String nomeLider;
	private String cargo;
	
	
	public LideresDTO() {
		
	}
	
	public LideresDTO(LideresDTO objDto) {
			
		}

	public String getNomeLider() {
		return nomeLider;
	}

	public void setNomeLider(String nomeLider) {
		this.nomeLider = nomeLider;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
}
