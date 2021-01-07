package br.com.edtonlemos.barbeariaxpto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Calendar horario = Calendar.getInstance();
	private String observacao;
	private BigDecimal valor_total;

	@ManyToMany(fetch=FetchType.EAGER) 
	private List<Servico> servicos = new ArrayList<Servico>(); // precisa ser instanciado

	public Agendamento() {
		this.valor_total = new BigDecimal(0.0);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	/**
	 * Método utilizado para adicionar um ou mais de um tipo de serviço no List do
	 * agendamento automaticamente ele atualiza o valor total dos serviços
	 */
	public void adicionarServico(Servico servico) {
		this.servicos.add(servico);
		this.valor_total = this.valor_total.add(servico.getValor());
	}
	
	public void removerServico(Servico servico) {
		this.servicos.remove(servico);
		this.valor_total = this.valor_total.subtract(servico.getValor());
	}

	@Override
	public String toString() {
		return "Agendamento para " + this.nome + "\n" + "Em " + this.horario + "\n" + "No valor de " + this.valor_total
				+ " reais \n" + "Observação: " + this.observacao;
	}
}
