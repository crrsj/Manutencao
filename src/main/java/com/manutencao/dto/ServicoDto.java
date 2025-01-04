package com.manutencao.dto;

import java.util.Random;

import com.manutencao.entidade.Cliente;
import com.manutencao.entidade.Servicos;
import com.manutencao.enums.StatusServico;
import com.manutencao.enums.Tipo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ServicoDto {

	
	private Long id;
	private int ordem = new Random().nextInt(1000 + 1);	
	private Tipo tipo;
	@NotBlank(message = "Não posde estar em branco !")
	private String descricao;
	private Double valor;	
	private StatusServico status;	
	private Cliente cliente;
	
	public ServicoDto(Servicos criarServico) {
		this.id = criarServico.getId();
		this.ordem = criarServico.getOrdem();		
		this.tipo = criarServico.getTipo();
		this.descricao = criarServico.getDescricao();
		this.valor = criarServico.getValor();
		this.status = criarServico.getStatus();
		this.cliente = criarServico.getCliente();
	}
}
