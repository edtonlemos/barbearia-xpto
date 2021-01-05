package br.com.edtonlemos.barbeariaxpto.teste;

import java.math.BigDecimal;

import br.com.edtonlemos.barbeariaxpto.model.Agendamento;
import br.com.edtonlemos.barbeariaxpto.model.Cliente;
import br.com.edtonlemos.barbeariaxpto.model.Servico;
import br.com.edtonlemos.barbeariaxpto.model.Usuario;

public class TestesModel {

	public static void main(String[] args) {

		Usuario admin = new Usuario("Edton", "79111112222", "ed@hotmail.com",
				"23297465", "edtonlogin", "1234");
		System.out.println(admin.getNome() + ", tel: " + admin.getTelefone());
		
		Cliente cliente1 = new Cliente("Daniel", "79111112222", "daniel@bol.com.br", "123456789");
		
		Servico barba = new Servico("Barba", new BigDecimal(22.50));
		Servico cabelo = new Servico("Cabelo", new BigDecimal(28.0));
		Servico hidratacao = new Servico("Hidratação", new BigDecimal(8.25));
		
		Agendamento agenda = new Agendamento("Edton", "Cliente irá trazer o próprio produto", "05/01/2021 08:30");
		
		agenda.adicionarServico(cabelo);
//		agenda.adicionarServico(barba);
		
		System.out.println(agenda);
		System.out.println(agenda.listarServicos());
	}

}
