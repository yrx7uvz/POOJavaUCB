package com.triagem.controller;

import com.triagem.model.Medico;
import com.triagem.model.Paciente;
import com.triagem.service.TriagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TriagemController {

    @Autowired
    private TriagemService triagemService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("sistema de triagem ativo");
    }

    @PostMapping("/triagem")
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(triagemService.salvarPaciente(paciente));
    }

    @PostMapping("/medicos")
    public ResponseEntity<Medico> registrarMedico(@RequestBody Medico medico) {
        return ResponseEntity.ok(triagemService.salvarMedico(medico));
    }

    @PutMapping("/medicos/{id}/plantao")
    public ResponseEntity<?> atualizarPlantao(@PathVariable Long id, @RequestParam boolean emPlantao) {
        return triagemService.atualizarPlantao(id, emPlantao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<?> buscarPaciente(@PathVariable Long id) {
        return triagemService.buscarPacientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/atendimento/proximo")
    public ResponseEntity<?> proximoPaciente() {
        return triagemService.proximoAtendimento()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).body("nenhum paciente disponível ou sem médicos em plantão"));
    }
}