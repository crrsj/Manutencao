package com.manutencao.servico;

import org.springframework.stereotype.Service;

import com.manutencao.dto.AtEnderecoDto;
import com.manutencao.dto.EnderecoDto;
import com.manutencao.entidade.Endereco;
import com.manutencao.repositorio.ClienteRepositorio;
import com.manutencao.repositorio.EnderecoRepositorio;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoServico {
	
	private final EnderecoRepositorio enderecoRepositorio;
	private final ClienteRepositorio clienteRepositorio;
	
	
	
	public Endereco salvarEndereco(EnderecoDto enderecoDto,Long clienteId) {
		var salvarEndereco = new Endereco(enderecoDto);
		var cliente = clienteRepositorio.findById(clienteId).get();
		salvarEndereco.setCliente(cliente);
		return enderecoRepositorio.save(salvarEndereco);
		
	}
	
	@Transactional
	public Endereco atualizarEndereco(AtEnderecoDto atEnderecoDto) {
	    var atualizar = enderecoRepositorio.getReferenceById(atEnderecoDto.getId());
	    atualizar.atualizando(atEnderecoDto);
		return enderecoRepositorio.save(atualizar);
	}

}
