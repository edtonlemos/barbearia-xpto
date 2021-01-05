package br.com.edtonlemos.barbeariaxpto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.edtonlemos.barbeariaxpto.model.Servico;
import br.com.edtonlemos.barbeariaxpto.repository.ServicoRepository;

@ManagedBean
@ViewScoped
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	private Servico servico;
	private List<Servico> servicos = new ArrayList<Servico>();
	private boolean modoEdicao = false;
	
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
	public boolean isModoEdicao() {
		return modoEdicao;
	}
	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}
	
	@PostConstruct
	public void iniciaListaServicos() {
		setServicos(servicoRepository.findAll());
	}

}
