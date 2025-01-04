package com.manutencao.controle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manutencao.dto.AtEnderecoDto;
import com.manutencao.dto.EnderecoDto;
import com.manutencao.servico.EnderecoServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/endereco")
@RequiredArgsConstructor
public class EnderecoControle {

	private final EnderecoServico enderecoServico;
	
	@PostMapping("{clienteId}")
	@Operation(summary = "Endpoint responsável por cadastrar endereço dos clientes.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<EnderecoDto>salvarEndereco(@RequestBody @Valid EnderecoDto enderecoDto,
			@PathVariable("clienteId")Long clienteId){
		var salvar = enderecoServico.salvarEndereco(enderecoDto, clienteId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(salvar.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(salvar));
	}
	
	@PutMapping
	@Operation(summary = "Endpoint responsável por atualizar endereço dos clientes.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AtEnderecoDto>atualizarEndereco(@RequestBody AtEnderecoDto enderecoDto){
		var atualize = enderecoServico.atualizarEndereco(enderecoDto);
		return ResponseEntity.ok().body(new AtEnderecoDto(atualize));
	}
}
