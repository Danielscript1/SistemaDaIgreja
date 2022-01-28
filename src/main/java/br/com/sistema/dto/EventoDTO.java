package br.com.sistema.dto;

import br.com.sistema.domain.Igreja;

public class EventoDTO {

	private String nomeEvento;
	private String descricaoEvento;
	private Igreja igreja;
	
	public EventoDTO() {
		
	}
	
	public EventoDTO(EventoDTO objDto) {
			
		}

	

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}
		
	
		
}
