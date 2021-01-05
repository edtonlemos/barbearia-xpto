package br.com.edtonlemos.barbeariaxpto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.edtonlemos.barbeariaxpto.model.Cliente;
import br.com.edtonlemos.barbeariaxpto.repository.ClienteRepository;

@ManagedBean
@ViewScoped
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private boolean modoEdicao = false;
	
	
	public boolean isModoEdicao() {
		return modoEdicao;
	}

	public void setModoEdicao(boolean modoEdicao) {
		this.modoEdicao = modoEdicao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	@PostConstruct
	public void iniciaListaClientes() {
		setClientes(clienteRepository.findAll());
	}

	public void salvar() {
		clienteRepository.save(cliente);
		if(!isModoEdicao())
			clientes.add(cliente);
		cliente = new Cliente();
		this.setModoEdicao(false);
	}
	
	public void remover(Cliente cliente) {
		clienteRepository.delete(cliente);
		clientes.remove(cliente); // removendo da lista 
	}
	
	public void editar(Cliente cliente) {
		setCliente(cliente);
		this.setModoEdicao(true);
	}
	
	public void cancelar() {
		cliente = new Cliente();
		setModoEdicao(false);
	}
}
