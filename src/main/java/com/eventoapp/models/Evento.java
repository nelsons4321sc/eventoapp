package com.eventoapp.models;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Após a criação da classe de configuração de banco de Dados,
 * precisamos criar uma entidade que será uma tabela do nosso banco de dados.
 * E pra isso criamos uma anotação com o Entity
 */

@Entity
public class Evento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Faz-se necessário, após a criação da entidade, criarmos um ID, pois toda entidade deve ter um, 
	 * para isso, vamos criar uma variável long com anotação Id
	 * e para que não seja necessário entrar com este dado no formulário
	 * é bom criar a anotação GeneratedValue
	 * Para que essas anotações funcionem bem, necessário implementar serializable
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	
	
	private String nome;
	private String local;
	private String data;
	private String horario;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	

}
