package br.com.edtonlemos.barbeariaxpto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.edtonlemos.barbeariaxpto.model.Agendamento;
import br.com.edtonlemos.barbeariaxpto.model.Servico;
import br.com.edtonlemos.barbeariaxpto.repository.AgendamentoRepository;
import br.com.edtonlemos.barbeariaxpto.repository.ServicoRepository;

@ManagedBean
@ViewScoped
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	
	private Integer servicoId; //para capturar a ID do serviço selecionado no menu de serviços
	
	private Agendamento agendamento = new Agendamento(); //para vincular os campos do jsf
	private List<Agendamento> agendamentos = new ArrayList<Agendamento>(); //para exibir a listar dos agendamentos
	private boolean modoEdicao = false; 
	

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public Agendamento getAgendamento() {
		return agendamento;
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
		
//		if(!isModoEdicao())
//			agendamentos.add(agendamento);
		
		if(agendamento.getServicos().isEmpty()) {
			throw new RuntimeException("Um agendamento precisa de pelo menos um serviço.");
		}
		this.agendamento = new Agendamento();
		iniciaListaAgendamentos();
	}
	
	/**
	 * Método utilizado para popular a combobox da seleção de serviços do formulário
	 * @return
	 */
	public List<Servico> getServicos(){
		return servicoRepository.findAll();
	}
	
	public List<Servico> getServicosDoAgendamento() {
		return this.agendamento.getServicos();
	}
	
	public void inserirServico() {
		Servico servicoSelecionado = servicoRepository.getOne(servicoId);
		this.agendamento.adicionarServico(servicoSelecionado);
	}

}
