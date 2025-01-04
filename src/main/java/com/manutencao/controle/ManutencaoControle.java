package com.manutencao.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manutencao.dto.ServicoDto;
import com.manutencao.servico.ManutencaoServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/servico")
@RequiredArgsConstructor
public class ManutencaoControle {
	
	private final ManutencaoServico manutencaoServico;
	
	
	@PostMapping("{clienteId}")
	@Operation(summary = "Endpoint responsável por cadastrar serviços.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ServicoDto>criarServico(@RequestBody @Valid ServicoDto servicoDto,@PathVariable("clienteId") Long clienteId){
		var criarServico = manutencaoServico.criarServicos(servicoDto, clienteId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(criarServico.getId()).toUri();
		return ResponseEntity.created(uri).body(new ServicoDto(criarServico));
	}
	
	@PutMapping("{id}")
	@Operation(summary = "Endpoint responsável por atualizar serviços.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ServicoDto>atualizarServico(@RequestBody ServicoDto servicoDto,@PathVariable Long id){
		var atualizar = manutencaoServico.atualizarServicos(servicoDto, id);
			return ResponseEntity.ok().body(new ServicoDto(atualizar));
		
	}
}
