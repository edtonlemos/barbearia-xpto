package br.com.edtonlemos.barbeariaxpto.controller;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.edtonlemos.barbeariaxpto.model.Usuario;
import br.com.edtonlemos.barbeariaxpto.repository.UsuarioRepository;

@ManagedBean
@ViewScoped
public class LoginController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private Usuario usuario = new Usuario();

	public String efetuaLogin() {
		boolean existe = false;
		System.out.println("Verificando credenciais do usuário " + this.usuario.getEmail());

		if (usuarioRepository.existe(usuario.getEmail(), usuario.getSenha()) != null) {
			existe = true;
		}

		if (!existe) {
			FacesContext.getCurrentInstance().addMessage("login",
					new FacesMessage("Usuário não encontrado ou senha incorreta"));
			return "";
		}
		
		return "agendamento?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
