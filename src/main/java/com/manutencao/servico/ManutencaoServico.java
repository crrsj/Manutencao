package com.manutencao.servico;

import org.springframework.stereotype.Service;

import com.manutencao.dto.ServicoDto;
import com.manutencao.entidade.Servicos;
import com.manutencao.repositorio.ClienteRepositorio;
import com.manutencao.repositorio.ManutencaoRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManutencaoServico {
	
	private final ManutencaoRepositorio manutencaoRepositorio;
	
	private final ClienteRepositorio clienteRepositorio;
	
	public Servicos criarServicos(ServicoDto servicoDto,Long clienteId) {
		var criar = new Servicos(servicoDto);
		var cliente = clienteRepositorio.findById(clienteId).get();
		criar.setCliente(cliente);
		return manutencaoRepositorio.save(criar);
		
		
	}
	
	public Servicos atualizarServicos(ServicoDto servicoDto,Long id) {
		var atualizar = new Servicos(servicoDto);
		atualizar.setId(id);
		return manutencaoRepositorio.save(atualizar);
	}

}
