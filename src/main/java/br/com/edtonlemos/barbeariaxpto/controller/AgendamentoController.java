package br.com.edtonlemos.barbeariaxpto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.edtonlemos.barbeariaxpto.model.Agendamento;
import br.com.edtonlemos.barbeariaxpto.repository.AgendamentoRepository;

@ManagedBean
@ViewScoped
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;	
	private Agendamento agendamento = new Agendamento();
	private List<Agendamento> agendamentos = new ArrayList<Agendamento>();
	private boolean modoEdicao = false;

	public Agendamento getAgendamento() {
		return agendamento;
	}
	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	public boolean isModoEdicao() {
		return modoEdicao;
	}
	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}
	
	@PostConstruct
	public void iniciaListaAgendamentos() {
		setAgendamentos(agendamentoRepository.findAll());
	}
	
	public void salvar() {
		agendamentoRepository.save(agendamento);
		if(!isModoEdicao())
			agendamentos.add(agendamento);
		this.agendamento = new Agendamento();
	}
	

}
