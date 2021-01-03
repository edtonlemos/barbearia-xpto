package br.com.edtonlemos.barbeariaxpto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario extends Pessoa{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
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
