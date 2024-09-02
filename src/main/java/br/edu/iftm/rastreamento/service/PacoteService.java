package br.edu.iftm.rastreamento.service;

import java.time.Instant;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.repository.EnderecoRepository;
import br.edu.iftm.rastreamento.repository.PacoteRepository;
import br.edu.iftm.rastreamento.repository.RastreamentoRepository;
import br.edu.iftm.rastreamento.service.exceptions.ResourceNotFoundException;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Pacote> getAllPacotes() {
        Iterable<Pacote> pacotesIterable = pacoteRepository.findAll();
        List<Pacote> pacotesList = new ArrayList<>();
        pacotesIterable.forEach(pacotesList::add);
        return pacotesList;
    }

    public Pacote getPacoteById(Long id) {
        return pacoteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pacote não encontrado com o id " + id));
    }

    public Pacote createPacote(Pacote pacote) {
        if (pacote.getEndereco() != null) {
            pacote.setEndereco(enderecoRepository.findById(pacote.getEndereco().getId()).orElse(null));
        }
        return pacoteRepository.save(pacote);
    }


    public Pacote updatePacote(Long id, Pacote pacoteDetails) {
        Pacote pacote = pacoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pacote não encontrado com o id " + id));
        pacote.setId(id);
        pacote.atualizarStatus(pacoteDetails.getStatus(), Date.from(Instant.now()), "não implementado");
        
        // Obter o último rastreamento
        Rastreamento ultiRastreamento = pacote.getRastreamentos().get(pacote.getRastreamentos().size() - 1);
        rastreamentoRepository.save(ultiRastreamento);
        
        return pacoteRepository.save(pacote);
    }

    public void deletePacote(Long id) {
        Pacote pacote = pacoteRepository.findById(id).orElseThrow(() -> new RuntimeException("Pacote não encontrado com o id " + id));
        pacoteRepository.delete(pacote);
    }

    public List<Pacote> findPacotesByStatus(String status) {
        return pacoteRepository.findByStatus(status);
    }

    public List<Pacote> findPacotesByDestinatario(String destinatario) {
        return pacoteRepository.findByDestinatario(destinatario);
    }
}

