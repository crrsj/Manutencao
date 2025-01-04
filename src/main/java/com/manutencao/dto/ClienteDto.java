package com.manutencao.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.manutencao.entidade.Cliente;
import com.manutencao.entidade.Endereco;
import com.manutencao.entidade.Servicos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDto{
	
  private Long id;
  private String dataCadastro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
  @NotBlank(message = "Não posde estar em branco !")
  private String nome;
  @NotBlank(message = "Não posde estar em branco !")
  private String telefone;
  @Email
  @NotBlank(message = "Não posde estar em branco !")
  private String email;
  private List<Endereco>endereco;
  private List<Servicos>servicos;
		
	public ClienteDto(Cliente cliente) {		
		this.id = cliente.getId();
		this.dataCadastro = cliente.getDataCadastro();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.endereco = cliente.getEndereco();
		this.servicos = cliente.getServicos();
		
	}
	

}
