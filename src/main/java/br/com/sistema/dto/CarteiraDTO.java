package br.com.sistema.dto;

import java.util.Date;

import br.com.sistema.domain.CarteiraMembro;
import br.com.sistema.domain.Certificado;
import br.com.sistema.domain.Igreja;

public class CarteiraDTO {
	
	private String nomeCarteira;
	private Date DataExpedição;
	private Date adesãoMinisterio;
	private Certificado certificado;
	private Igreja igreja;
	
	
	public CarteiraDTO() {
		
	}
	
	public CarteiraDTO(CarteiraDTO  objDto) {
			
		}

	
	
	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	public String getNomeCarteira() {
		return nomeCarteira;
	}
	
	

	public Certificado getCertificado() {
		return certificado;
	}

	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}

	public void setNomeCarteira(String nomeCarteira) {
		this.nomeCarteira = nomeCarteira;
	}

	public Date getDataExpedição() {
		return DataExpedição;
	}

	public void setDataExpedição(Date dataExpedição) {
		DataExpedição = dataExpedição;
	}

	public Date getAdesãoMinisterio() {
		return adesãoMinisterio;
	}

	public void setAdesãoMinisterio(Date adesãoMinisterio) {
		this.adesãoMinisterio = adesãoMinisterio;
	}
	
	
}
