package br.com.sistema.dto;

import java.util.Date;

public class CertificadoDTO {
	
	private String nome;
	private Date dataCertificado;
	
	public CertificadoDTO() {
		
	}
	
	
public CertificadoDTO(CertificadoDTO objDto) {
		
	}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public Date getData() {
	return dataCertificado;
}


public void setData(Date data) {
	this.dataCertificado = data;
}
	
	
}
