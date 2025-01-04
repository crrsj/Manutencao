package com.manutencao.entidade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.manutencao.dto.AtualizarDto;
import com.manutencao.dto.ClienteDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_clientes")
@NoArgsConstructor
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataCadastro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;
	private String telefone;
	private String email;
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)	
	private List<Endereco>endereco;
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)	
	private List<Servicos>servicos;
	
	public Cliente(AtualizarDto atualizarDto) {
		this.id = atualizarDto.getId();
		this.dataCadastro = atualizarDto.getDataCadastro();
		this.nome = atualizarDto.getNome();
		this.telefone = atualizarDto.getTelefone();
		this.email = atualizarDto.getEmail();
		
	}
   public Cliente(ClienteDto clienteDto) {
	   this.id = clienteDto.getId();
	   this.nome = clienteDto.getNome();
	   this.telefone = clienteDto.getTelefone();
	   this.email = clienteDto.getEmail();
	   this.endereco = clienteDto.getEndereco();
       this.servicos = clienteDto.getServicos();
	   
   }
	
		
	

}
