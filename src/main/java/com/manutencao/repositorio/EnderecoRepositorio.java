package com.manutencao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencao.entidade.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

}
