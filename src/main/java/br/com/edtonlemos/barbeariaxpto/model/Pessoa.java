package br.com.edtonlemos.barbeariaxpto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String documento;
	
	public Pessoa(String nome, String telefone, String email, String documento) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.documento = documento;
	}
	
	public Pessoa() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", documento=" + documento
				+ "]";
	}
	
	

}
