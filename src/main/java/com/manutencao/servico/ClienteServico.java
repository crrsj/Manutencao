package com.manutencao.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manutencao.dto.AtualizarDto;
import com.manutencao.dto.ClienteDto;
import com.manutencao.entidade.Cliente;
import com.manutencao.repositorio.ClienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServico {
	
	private final ClienteRepositorio clienteRepositorio;
	
	public Cliente salvarCliente(ClienteDto clienteDto) {		
		var salvar = new Cliente(clienteDto);
		return clienteRepositorio.save(salvar);
		
	}

	
	public List<ClienteDto>  listarClientes() {	
		return clienteRepositorio.findAll().stream().map(ClienteDto::new).toList();
		
	}
	
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> buscar = clienteRepositorio.findById(id);
		return buscar.get();
	}
	
	
	public Cliente AtualizarCliente(AtualizarDto atualizarDto,Long id) {
		var atualizar = new Cliente(atualizarDto);
		atualizar.setId(id);
		return clienteRepositorio.save(atualizar);
	}
	
	public void excluirCliente(Long id) {
		clienteRepositorio.deleteById(id);
	}
	
	public List<Cliente>buscarPorNome(String nome) {
		return clienteRepositorio.findByNome(nome.trim().toUpperCase());
	}
}
