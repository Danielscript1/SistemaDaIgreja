package br.com.sistema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("filias") 
public class Filias extends Igreja{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 	
	private Integer id; 
	
}
