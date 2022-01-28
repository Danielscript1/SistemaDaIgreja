package br.com.sistema.dto;

import br.com.sistema.domain.Igreja;

public class EquipamentoDTO {
	
	private String nomeEquipamento;
	private int quantidade;
	private Igreja igreja;
	
	public EquipamentoDTO() {
		
	}
	
public EquipamentoDTO(EquipamentoDTO objDto) {
		
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

public Igreja getIgreja() {
	return igreja;
}

public void setIgreja(Igreja igreja) {
	this.igreja = igreja;
}
	

	
}
