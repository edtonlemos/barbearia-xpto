package br.com.edtonlemos.barbeariaxpto.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.edtonlemos.barbeariaxpto.model.Agendamento;
import br.com.edtonlemos.barbeariaxpto.model.Cliente;
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

	private Integer servicoId; // para capturar a ID do serviço selecionado no menu de serviços

	private Agendamento agendamento = new Agendamento(); // para vincular os campos do jsf
	private List<Agendamento> agendamentos = new ArrayList<Agendamento>(); // para exibir a listar dos agendamentos
	private boolean modoEdicao = false;

	@PostConstruct
	public void iniciaListaAgendamentos() {
		setAgendamentos(agendamentoRepository.findAll());
	}

	public void salvar() {
		agendamentoRepository.save(agendamento);

		if(!isModoEdicao())
			agendamentos.add(agendamento);

		if (agendamento.getServicos().isEmpty()) {
//			throw new RuntimeException("Um agendamento precisa de pelo menos um serviço.");
			FacesContext.getCurrentInstance().addMessage("servico",
					new FacesMessage("O Agendamento precisa de pelo menos um serviço!"));
			return;
		}
		this.agendamento = new Agendamento();
		iniciaListaAgendamentos();
		setModoEdicao(false);
	}

	/**
	 * Método utilizado para popular a combobox da seleção de serviços do formulário
	 * @return
	 */
	public List<Servico> getServicos() {
		return servicoRepository.findAll();
	}

	/**
	 * Listar na tela do agendamento os serviços inseridos
	 * @return
	 */
	public List<Servico> getServicosDoAgendamento() {
		return this.agendamento.getServicos();
	}

	/**
	 * Adicionar serviços selecionados no combobox na lista de serviços do
	 * agendamento
	 */
	public void inserirServico() {
		Servico servicoSelecionado = servicoRepository.getOne(servicoId);
		this.agendamento.adicionarServico(servicoSelecionado);
	}

	/**
	 * Utilizado para chamar o formulário de cadastro de serviços na tela do
	 * agendamento
	 * @return
	 */
	public String formServico() {
		return "servico?faces-redirect=true";
	}

	/**
	 * Remover um agendamento do banco
	 * @param agendamento
	 */
	public void remover(Agendamento agendamento) {
		agendamentoRepository.delete(agendamento);
		agendamentos.remove(agendamento);
	}
	
	/**
	 * Carregar os dados de um agendamento no formulário para edição
	 * @param agendamento
	 */
	public void editar(Agendamento agendamento) {
		this.agendamento = agendamento;
		setModoEdicao(true);
	}
	/**
	 * remover um serviço que vou inserido na lista para cadastrar/editar o agendamento
	 * @param servico
	 */
	public void removerServicoDoAgendamento(Servico servico) {
		this.agendamento.removerServico(servico);
	}
	
	
	public void cancelar() {
		this.agendamento = new Agendamento();
		setModoEdicao(false);
		iniciaListaAgendamentos();
	}
	

//GETTERS AND SETTERS	
	
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

}
