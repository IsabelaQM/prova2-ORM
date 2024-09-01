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

// package br.edu.iftm.rastreamento.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import br.edu.iftm.rastreamento.dto.EnderecoDTO;
// import br.edu.iftm.rastreamento.service.EnderecoService;

// @RestController
// @RequestMapping("/enderecos")
// public class EnderecoController {

// 	@Autowired
// 	private EnderecoService enderecoService;

// 	@GetMapping
// 	public List<EnderecoDTO> getAllEnderecos() {
// 		System.out.println("-----------------------------------------");
// 		return enderecoService.getAllEnderecos();
// 	}

// 	@GetMapping("/{id}")
// 	public ResponseEntity<EnderecoDTO> getById(@PathVariable Long id) {
// 		EnderecoDTO endereco = enderecoService.getEnderecoById(id);
// 		return ResponseEntity.status(HttpStatus.FOUND).body(endereco);
// 	}

// 	@PostMapping
// 	public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
// 		EnderecoDTO novoRecursEnderecoDTO = enderecoService.createEndereco(enderecoDTO);
// 		return ResponseEntity.status(HttpStatus.CREATED).body(novoRecursEnderecoDTO);
// 	}
// }
