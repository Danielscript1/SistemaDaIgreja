package br.com.sistema.dto;

import java.util.Date;

import br.com.sistema.domain.Igreja;

public class AgendamentoDTO {
	private Integer id;
	private String nomeAgendamento;
	private Date agendamentoData;
	private Igreja igreja;
	
	public AgendamentoDTO() {
		
	}
	
	public AgendamentoDTO(AgendamentoDTO objDto) {
			
		}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	public String getNomeAgendamento() {
		return nomeAgendamento;
	}

	public void setNomeAgendamento(String nomeAgendamento) {
		this.nomeAgendamento = nomeAgendamento;
	}

	public Date getAgendamentoData() {
		return agendamentoData;
	}

	public void setAgendamentoData(Date agendamentoData) {
		this.agendamentoData = agendamentoData;
	}
		
		
}
