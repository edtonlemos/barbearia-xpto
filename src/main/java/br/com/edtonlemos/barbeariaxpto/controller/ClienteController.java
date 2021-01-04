package br.com.edtonlemos.barbeariaxpto.controller;

import javax.annotation.ManagedBean;
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
	
	
	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public void salvar() {
		clienteRepository.save(cliente);
	}
	
}
