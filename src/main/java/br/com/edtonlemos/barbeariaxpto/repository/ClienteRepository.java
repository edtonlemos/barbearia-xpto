package br.com.edtonlemos.barbeariaxpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.edtonlemos.barbeariaxpto.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query("select c from Cliente c where c.documento = :documento")
	public Cliente buscarPorDocumento(String documento);

}
