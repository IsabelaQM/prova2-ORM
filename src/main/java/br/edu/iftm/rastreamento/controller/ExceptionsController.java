package br.edu.iftm.rastreamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import br.edu.iftm.rastreamento.service.exceptions.ResourceNotFoundException;

@ControllerAdvice
@Tag(name = "Exceptions", description = "API para tratamento de exceções")
public class ExceptionsController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Operation(summary = "Trata exceções de pacote não encontrado", description = "Trata exceções quando o pacote não é encontrado pelo ID", tags = {"Exceptions"}, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Pacote não encontrado")
    })
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Operation(summary = "Trata exceções genéricas", description = "Trata todas as exceções não capturadas por outros handlers", tags = {"Exceptions"}, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}

// package br.edu.iftm.rastreamento.controller;

// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;

// @ControllerAdvice
// @Tag(name = "Exceptions", description = "API para tratamento de exceções")
// public class ExceptionsController {

//     @ExceptionHandler(Exception.class)
//     @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//     @Operation(summary = "Trata exceções genéricas", description = "Trata todas as exceções não capturadas por outros handlers", tags = {"Exceptions"}, responses = {
//             @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Erro interno do servidor")
//     })
//     public ResponseEntity<String> handleException(Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//     }

// }

// package br.edu.iftm.rastreamento.controller;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import br.edu.iftm.rastreamento.service.exceptions.NaoAcheiException;

// @ControllerAdvice
// public class ExceptionsController {

// 	@ExceptionHandler(NaoAcheiException.class)
// 	public ResponseEntity<?> naoAchei(NaoAcheiException e) {
// 		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
// 	}
// }
