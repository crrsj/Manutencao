package com.manutencao.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.manutencao.entidade.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	@Query(value = "select c from Cliente c where upper(trim(c.nome)) like %?1% ") 
	List<Cliente> findByNome(String nome); 

}
