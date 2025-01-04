package com.manutencao.entidade;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manutencao.dto.ServicoDto;
import com.manutencao.enums.StatusServico;
import com.manutencao.enums.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_servicos")
@Data
@NoArgsConstructor
public class Servicos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private int ordem = new Random().nextInt(1000 + 1);
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private String descricao;
	private Double valor;
	@Enumerated(EnumType.STRING)
	private StatusServico status;
	@ManyToOne
	@JoinColumn(name = "Id_cliente")
	@JsonIgnore
	private Cliente cliente;

	public Servicos(ServicoDto servicoDto) {
		this.id = servicoDto.getId();
		this.ordem = servicoDto.getOrdem();
		this.tipo = servicoDto.getTipo();
		this.descricao = servicoDto.getDescricao();
		this.valor = servicoDto.getValor();
		this.status = servicoDto.getStatus();
		this.cliente = servicoDto.getCliente();
	}
}
