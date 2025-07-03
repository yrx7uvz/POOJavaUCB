package com.triagem.service;

import com.triagem.model.Paciente;
import com.triagem.model.Medico;
import com.triagem.repository.PacienteRepository;
import com.triagem.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TriagemService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Medico salvarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Optional<Medico> atualizarPlantao(Long id, boolean status) {
        Optional<Medico> medicoOpt = medicoRepository.findById(id);
        medicoOpt.ifPresent(m -> {
            m.setEmPlantao(status);
            medicoRepository.save(m);
        });
        return medicoOpt;
    }

   public Optional<Paciente> proximoAtendimento() {
    List<Medico> medicos = medicoRepository.findByEmPlantaoTrue();
    if (medicos.isEmpty()) return Optional.empty();

    return pacienteRepository.findAll().stream()
        .sorted(Comparator
            .comparing((Paciente p) -> prioridadeParaNumero(p.getPrioridade()))
            .thenComparing(p -> gravidadeParaNumero(p.getGravidade()))
            .thenComparing(Paciente::getDataEntrada)
        )
        .findFirst();
}

private int prioridadeParaNumero(String prioridade) {
    return switch (prioridade.toLowerCase()) {
        case "vermelha" -> 1;
        case "amarela"  -> 2;
        case "verde"    -> 3;
        default         -> 4;
    };
}

private int gravidadeParaNumero(String gravidade) {
    return switch (gravidade.toLowerCase()) {
        case "grave"    -> 1;
        case "moderada" -> 2;
        case "leve"     -> 3;
        default         -> 4;
    };
}

}