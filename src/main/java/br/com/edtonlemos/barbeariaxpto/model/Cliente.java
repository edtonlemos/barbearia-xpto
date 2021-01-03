package br.com.edtonlemos.barbeariaxpto.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cliente extends Pessoa{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int fidelidade;
	
	public Cliente(String nome, String telefone, String email, String documento) {
		super(nome, telefone, email, documento);
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
