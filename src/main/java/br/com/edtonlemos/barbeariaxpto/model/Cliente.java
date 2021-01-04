package br.com.edtonlemos.barbeariaxpto.model;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	private int fidelidade;
	
	public Cliente(String nome, String telefone, String email, String documento) {
		super(nome, telefone, email, documento);
		setFidelidade(0);
	}
	
	public Cliente() {
		setFidelidade(0);
	}

	public int getFidelidade() {
		return fidelidade;
	}

	private void setFidelidade(int fidelidade) {
		this.fidelidade = fidelidade;
	}
	
	public void adicionarFidelidade() {
		this.fidelidade += 1;
	}
	
	
}
