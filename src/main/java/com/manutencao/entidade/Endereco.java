package com.manutencao.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manutencao.dto.AtEnderecoDto;
import com.manutencao.dto.EnderecoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_enderecos")
@NoArgsConstructor
@Data
public class Endereco {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	@Size(min = 2,max = 2)
	private String uf;
	@ManyToOne
	@JoinColumn(name = "Id_cliente")
	@JsonIgnore
	private Cliente cliente;
	
	public Endereco(EnderecoDto enderecoDto) {
		this.id = enderecoDto.getId();
		this.rua = enderecoDto.getRua();
		this.numero = enderecoDto.getNumero();
		this.complemento = enderecoDto.getComplemento();
		this.bairro = enderecoDto.getBairro();
		this.cidade = enderecoDto.getCidade();
		this.uf = enderecoDto.getUf();
		this.cliente = enderecoDto.getCliente();
		
	}

	public void atualizando(AtEnderecoDto atEnderecoDto) {
		if(atEnderecoDto.getRua() != null) {
			this.rua = atEnderecoDto.getRua();
		}
		
		if(atEnderecoDto.getNumero() !=  null) {
			this.numero = atEnderecoDto.getNumero();
		}
		if(atEnderecoDto.getComplemento() != null) {
			this.complemento = atEnderecoDto.getComplemento();
		}
		if(atEnderecoDto.getBairro() != null) {
			this.bairro = atEnderecoDto.getBairro();
		}
		if(atEnderecoDto.getCidade() != null) {
			this.cidade = atEnderecoDto.getCidade();
		}
		if(atEnderecoDto.getUf() != null) {
			this.uf = atEnderecoDto.getUf();
		}
	}	
}
