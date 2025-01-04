package com.manutencao.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manutencao.dto.AtualizarDto;
import com.manutencao.dto.ClienteDto;
import com.manutencao.servico.ClienteServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/cliente")
@RequiredArgsConstructor
public class ClienteControle {
	
	private final ClienteServico clienteServico;
	
	@PostMapping
	@Operation(summary = "Endpoint responsável pelo cadastro de clientes.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDto>salvarCliente(@RequestBody @Valid ClienteDto clienteDto){
		var salvar = clienteServico.salvarCliente(clienteDto);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(salvar.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(salvar));
	}

	@GetMapping
	@Operation(summary = "Endpoint responsável pela busca dos clientes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ClienteDto>>listarClientes(){
		var listar =  clienteServico.listarClientes();
		return ResponseEntity.ok().body(listar);
		
	}
	
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável pela busca de clientes pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })         
	public ResponseEntity<ClienteDto>buscarPorId(@PathVariable Long id){		
		var buscar = clienteServico.buscarPorId(id);
		return ResponseEntity.ok().body(new ClienteDto(buscar));
	}
	
	@PutMapping("{id}")
	@Operation(summary = "Endpoint responsável por atualizar dados dos clientes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })          
	public ResponseEntity<AtualizarDto>atualizarCliente(@RequestBody AtualizarDto atualizarDto,@PathVariable Long id){
		var atualizar = clienteServico.AtualizarCliente(atualizarDto, id);
		return ResponseEntity.ok().body(new AtualizarDto(atualizar));
	}
	
	
	@DeleteMapping("{id}")
    @Operation(summary = "Endpoint responsávelpor excluir clientes.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))         
	})     
	public ResponseEntity<Void>excluirCliente(@PathVariable Long id){
		clienteServico.excluirCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("buscarNome")
	@Operation(summary = "Endpoint responsável pela busca dos clientes pelo nome.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ClienteDto>>buscarPorNome(@RequestParam("nome") String nome){
		var busca = clienteServico.buscarPorNome(nome).stream().map(ClienteDto::new).toList();
		return ResponseEntity.ok().body(busca);
	}
	
}
