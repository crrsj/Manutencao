package com.manutencao.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.manutencao.entidade.Cliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarDto {
	
	private Long id;
	private String dataCadastro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;
	private String telefone;
	private String email;
	
	
	public AtualizarDto(Cliente atualizar) {
	  this.id = atualizar.getId();
	  this.dataCadastro = atualizar.getDataCadastro();
	  this.nome = atualizar.getNome();
	  this.telefone = atualizar.getTelefone();
	  this.email = atualizar.getEmail();
	}
}
