package com.triagem.controller;

import com.triagem.dto.MedicoDTO;
import com.triagem.dto.PacienteDTO;
import com.triagem.model.Medico;
import com.triagem.model.Paciente;
import com.triagem.service.TriagemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class TriagemController {

    @Autowired
    private TriagemService triagemService;

    // verifica se o sistema está online
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("sistema de triagem ativo");
    }

    // registra um novo paciente via DTO
    @PostMapping("/triagem")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody PacienteDTO dto) {
        Paciente paciente = new Paciente(dto.nome, dto.idade, dto.sintomas, dto.prioridade, dto.gravidade);
        return ResponseEntity.ok(triagemService.salvarPaciente(paciente));
    }

    // registra um novo médico via DTO
    @PostMapping("/medicos")
    public ResponseEntity<Medico> registrarMedico(@RequestBody MedicoDTO dto) {
        Medico medico = new Medico(dto.nome, dto.especialidade, dto.crm, false);
        return ResponseEntity.ok(triagemService.salvarMedico(medico));
    }

    // atualiza status de plantão de um médico
    @PutMapping("/medicos/{id}/plantao")
    public ResponseEntity<?> atualizarPlantao(@PathVariable Long id, @RequestParam boolean emPlantao) {
        Optional<Medico> medico = triagemService.atualizarPlantao(id, emPlantao);
        if (medico.isPresent()) {
            return ResponseEntity.ok(medico.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("médico não encontrado");
        }
    }

    // busca paciente por ID
    @GetMapping("/pacientes/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable Long id) {
        return triagemService.buscarPacientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("paciente não encontrado"));
    }

    // retorna o próximo paciente a ser atendido
    @GetMapping("/atendimento/proximo")
    public ResponseEntity<?> proximoPaciente() {
        return triagemService.proximoAtendimento()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("nenhum paciente disponível ou sem médicos em plantão"));
    }
}
