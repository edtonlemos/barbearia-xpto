package br.com.edtonlemos.barbeariaxpto.repository;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.edtonlemos.barbeariaxpto.model.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestClienteRepository {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testSalvar(){
	
		Cliente cli = new Cliente("João Silva", "79111112222","joao@bol.com", "123456789");
		Cliente cliSalvo = clienteRepository.save(cli);
		Assert.assertNotNull(cliSalvo.getId());
		
	}

}
