package com.manutencao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manutencao.entidade.Servicos;

public interface ManutencaoRepositorio extends JpaRepository<Servicos, Long> {

}
