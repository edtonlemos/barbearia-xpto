package br.com.edtonlemos.barbeariaxpto.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Usuario extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String senha;

	public Usuario(String nome, String telefone, String email, 
			String documento, String login, String senha) {
		super(nome, telefone, email, documento);
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
