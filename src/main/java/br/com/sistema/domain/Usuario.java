package br.com.sistema.domain;

import java.util.Date;

public class Usuario {
	
	/*
	 * Checklist para criar entidades:
	o Atributos básicos
	o Associações (inicie as coleções)
	o Construtores (não inclua coleções no construtor com parâmetros)
	o Getters e setters
	o hashCode e equals (implementação padrão: somente id)
	o Serializable (padrão: 1L)  = e uma interface que falar que os objetos dela pode ser convetidos em bytes
	 * */
	
	private Integer id;
	private String nome;
	private Date nascimento;
	private String pai;
	private String mae;
	private String email;
	private String senha;
	
	
}
