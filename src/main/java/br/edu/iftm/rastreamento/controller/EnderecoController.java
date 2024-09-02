package br.edu.iftm.rastreamento.controller;

import br.edu.iftm.rastreamento.dto.EnderecoDTO;
import br.edu.iftm.rastreamento.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
@Tag(name = "Endereco", description = "API para gerenciamento de endereços")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @PostMapping
    @Operation(summary = "Cria um novo endereço", description = "Cria um novo endereço a partir dos dados fornecidos", tags = {"Endereco"}, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Endereço criado com sucesso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO novoRecursEnderecoDTO = service.createEndereco(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRecursEnderecoDTO);
    }
}
