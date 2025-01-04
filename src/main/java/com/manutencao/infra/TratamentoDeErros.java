package com.manutencao.infra;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.manutencao.dto.MensagemDeErro;
import com.manutencao.dto.ValidarCampos;

@ControllerAdvice
public class TratamentoDeErros {
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErro>idNaoEncontrado(){		
		var erros = new MensagemDeErro(HttpStatus.NOT_FOUND, "Objeto não encontrado");
		return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>ValidandoCampos(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
	return ResponseEntity.badRequest().body(erros.stream().map(ValidarCampos::new).toList());
	}

}
