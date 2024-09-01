package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.service.PacoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pacotes")
@Tag(name = "Pacote", description = "API para gerenciamento de pacotes")
public class PacoteController {

	@Autowired
	private PacoteService pacoteService;

	@GetMapping
	@Operation(summary = "Retorna todos os pacotes", description = "Retorna a lista de todos os pacotes cadastrados", tags = {
			"Pacote" }, responses = {
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Pacotes retornados com sucesso"),
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Nenhum pacote encontrado")
			})
	public List<Pacote> getAllPacotes() {
		return pacoteService.getAllPacotes();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Retorna um pacote pelo ID", description = "Retorna um pacote específico pelo ID", tags = {
			"Pacote" }, responses = {
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Pacote retornado com sucesso"),
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Pacote não encontrado")
			})
	public ResponseEntity<Pacote> getPacoteById(@PathVariable Long id) {
		Pacote pacote = pacoteService.getPacoteById(id);
		return ResponseEntity.ok(pacote);
	}

	@GetMapping("/status/{status}")
    @Operation(summary = "Retorna pacotes pelo status", description = "Retorna a lista de pacotes com o status especificado", tags = {"Pacote"}, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Pacotes retornados com sucesso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Nenhum pacote encontrado")
    })
    public List<Pacote> getPacotesByStatus(@PathVariable String status) {
        return pacoteService.findPacotesByStatus(status);
    }

    @GetMapping("/destinatario/{destinatario}")
    @Operation(summary = "Retorna pacotes pelo destinatário", description = "Retorna a lista de pacotes com o destinatário especificado", tags = {"Pacote"}, responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Pacotes retornados com sucesso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Nenhum pacote encontrado")
    })
    public List<Pacote> getPacotesByDestinatario(@PathVariable String destinatario) {
        return pacoteService.findPacotesByDestinatario(destinatario);
    }

	@PostMapping
	@Operation(summary = "Cria um novo pacote", description = "Cria um novo pacote com os dados fornecidos", tags = {
			"Pacote" }, responses = {
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Pacote criado com sucesso"),
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
			})
	public ResponseEntity<Pacote> createPacote(@RequestBody Pacote pacote) {
		Pacote novoPacote = pacoteService.createPacote(pacote);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoPacote);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualiza um pacote", description = "Atualiza os dados de um pacote existente", tags = {
			"Pacote" }, responses = {
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Pacote atualizado com sucesso"),
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Pacote não encontrado")
			})
	public ResponseEntity<Pacote> updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteDetails) {
		Pacote pacoteAtualizado = pacoteService.updatePacote(id, pacoteDetails);
		return ResponseEntity.ok(pacoteAtualizado);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um pacote", description = "Deleta um pacote existente pelo ID", tags = {
			"Pacote" }, responses = {
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Pacote deletado com sucesso"),
					@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Pacote não encontrado")
			})
	public ResponseEntity<Void> deletePacote(@PathVariable Long id) {
		pacoteService.deletePacote(id);
		return ResponseEntity.noContent().build();
	}
}

// package br.edu.iftm.rastreamento.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import br.edu.iftm.rastreamento.model.Pacote;
// import br.edu.iftm.rastreamento.service.PacoteService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController
// @RequestMapping("/api/pacotes")
// @Tag(name = "Pacote", description = "API para gerenciamento de pacotes")
// public class PacoteController {

// @Autowired
// private PacoteService pacoteService;

// @GetMapping
// @Operation(summary = "Retorna todos os pacotes", description = "Retorna a
// lista de todos os pacotes cadastrados", tags = {"Pacote"}, responses = {
// @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
// description = "Pacotes retornados com sucesso"),
// @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",
// description = "Nenhum pacote encontrado")
// })
// public List<Pacote> getAllPacotes() {
// return pacoteService.getAllPacotes();
// }

// @PostMapping
// public Pacote createPacote(@RequestBody Pacote pacote) {
// return pacoteService.createPacote(pacote);
// }

// @GetMapping("/{id}")
// public Pacote getPacoteById(@PathVariable Long id) {
// return pacoteService.getPacoteById(id);
// }

// @PutMapping("/{id}")
// public Pacote updatePacote(@PathVariable Long id, @RequestBody Pacote
// pacoteDetails) {
// return pacoteService.updatePacote(id, pacoteDetails);
// }

// @DeleteMapping("/{id}")
// public void deletePacote(@PathVariable Long id) {
// pacoteService.deletePacote(id);
// }

// package br.edu.iftm.rastreamento.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import br.edu.iftm.rastreamento.model.Pacote;
// import br.edu.iftm.rastreamento.service.PacoteService;

// @RestController
// @RequestMapping("/pacotes")
// public class PacoteController {

// @Autowired
// private PacoteService pacoteService;

// @GetMapping
// public List<Pacote> getAllPacotes() {
// return pacoteService.getAllPacotes();
// }

// @PostMapping
// public Pacote createPacote(@RequestBody Pacote pacote) {
// return pacoteService.createPacote(pacote);
// }

// @GetMapping("/{id}")
// public Pacote getPacoteById(@PathVariable Long id) {
// return pacoteService.getPacoteById(id);
// }

// @PutMapping("/{id}")
// public Pacote updatePacote(@PathVariable Long id, @RequestBody Pacote
// pacoteDetails) {
// return pacoteService.updatePacote(id, pacoteDetails);
// }

// @DeleteMapping("/{id}")
// public void deletePacote(@PathVariable Long id) {
// pacoteService.deletePacote(id);
// }
// }