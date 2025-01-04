package com.manutencao.dto;

import com.manutencao.entidade.Endereco;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtEnderecoDto {
	
	private Long id;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	
	public AtEnderecoDto(Endereco atualize) {
		this.id  = atualize.getId();
		this.rua = atualize.getRua();
		this.numero = atualize.getNumero();
		this.complemento = atualize.getComplemento();
		this.bairro = atualize.getBairro();
		this.cidade  = atualize.getCidade();
		this.uf = atualize.getUf();
	}
}
