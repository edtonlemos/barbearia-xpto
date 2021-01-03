package br.com.edtonlemos.barbeariaxpto.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Agendamento {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Cliente cliente;
	private List<Servico> servicos = new ArrayList<Servico>(); //precisa ser instanciado
	private BigDecimal valor_total;
	private String observacao;
	private Date horario;
	
	public Agendamento(Cliente cliente, String observacao, String horario) {
		this.cliente = cliente;
		this.observacao = observacao;
		try {
			this.horario = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(horario);  //formato da data que deve ser inserido por String
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.valor_total = new BigDecimal(0);
		cliente.adicionarFidelidade();
	}
	
	/**
	 * Método utilizado para adicionar um ou mais de um tipo de serviço no List do agendamento
	 * automaticamente ele atualiza o valor total dos serviços
	 */
	public void adicionarServico(Servico servico) {
		this.servicos.add(servico);
		this.valor_total = this.valor_total.add(servico.getValor());
	}
	
	public String listarServicos() {
		return this.servicos.toString();
	}

	@Override
	public String toString() {
		return "Agendamento para " + this.cliente.getNome() + "\n" + "Em " + this.horario 
				+ "\n" + "No valor de " + this.valor_total + " reais \n" + "Observação: " + this.observacao;
	}
}
