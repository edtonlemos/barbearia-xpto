package br.com.edtonlemos.barbeariaxpto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.edtonlemos.barbeariaxpto.model.Agendamento;
import br.com.edtonlemos.barbeariaxpto.model.Servico;
import br.com.edtonlemos.barbeariaxpto.repository.ServicoRepository;

@ManagedBean
@ViewScoped
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	private Servico servico = new Servico();
	private List<Servico> servicos = new ArrayList<Servico>();
	private boolean modoEdicao = false;
	
	public boolean isModoEdicao() {
		return modoEdicao;
	}
	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@PostConstruct
	public void iniciaListaServicos() {
		setServicos(servicoRepository.findAll());
	}
	
	public void salvar() {
		servicoRepository.save(servico);
		if(!isModoEdicao())
			servicos.add(servico);
		this.servico = new Servico();
	}

}
