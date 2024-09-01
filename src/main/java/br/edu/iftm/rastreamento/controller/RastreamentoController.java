package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.service.RastreamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rastreamentos")
@Tag(name = "Rastreamento", description = "API para gerenciamento de rastreamentos")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @GetMapping("/{id}")
    @Operation(summary = "Retorna todos os rastreamentos de um pacote", description = "Retorna a lista de todos os rastreamentos de  um pacote", tags = {"Rastreamento"}, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Rastreamentos retornados com sucesso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Nenhum rastreamento encontrado")
    })
    public List<Rastreamento> getRastreamentosPacote(@PathVariable Long id) {
        return rastreamentoService.getRastreamentos(id);
    }

    // Adicione outros métodos (POST, PUT, DELETE) com a documentação do Swagger aqui
}

// package br.edu.iftm.rastreamento.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import br.edu.iftm.rastreamento.model.Rastreamento;
// import br.edu.iftm.rastreamento.service.RastreamentoService;
// import java.util.List;

// @RestController
// @RequestMapping("/rastreamentos")
// public class RastreamentoController {

// 	@Autowired
// 	private RastreamentoService rastreamentoService;

// 	@GetMapping("/{id}")
// 	public List<Rastreamento> getRastreamentosPacote(@PathVariable Long id) {
// 		return rastreamentoService.getRastreamentos(id);
// 	}

// }
