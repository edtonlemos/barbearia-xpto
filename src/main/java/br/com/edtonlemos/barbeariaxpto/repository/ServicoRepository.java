package br.com.edtonlemos.barbeariaxpto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edtonlemos.barbeariaxpto.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{
	
}
