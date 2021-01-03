package br.com.edtonlemos.barbeariaxpto.model;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Servico {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descricao;
	private BigDecimal valor;
	
	public Servico(String descricao, BigDecimal valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Servico [descricao=" + descricao + ", valor=" + valor + "]";
	}
	
	
	
}
