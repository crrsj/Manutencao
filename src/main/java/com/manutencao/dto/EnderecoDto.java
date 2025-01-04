package com.manutencao.dto;

import com.manutencao.entidade.Cliente;
import com.manutencao.entidade.Endereco;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoDto {
	
	private Long id;
	@NotBlank(message = "Não posde estar em branco !")
	private String rua;	
	private String numero;	
	private String complemento;
	@NotBlank(message = "Não posde estar em branco !")
	private String bairro;
	@NotBlank(message = "Não posde estar em branco !")
	private String cidade;
	@NotBlank(message = "Não posde estar em branco !")
	private String uf;
	private Cliente cliente;
	
	public EnderecoDto(Endereco salvar) {
		this.id = salvar.getId();
		this.rua = salvar.getRua();
		this.numero = salvar.getNumero();
		this.complemento = salvar.getComplemento();
		this.bairro = salvar.getBairro();
		this.cidade = salvar.getCidade();
		this.uf = salvar.getUf();
		this.cliente = salvar.getCliente();
	}

}
