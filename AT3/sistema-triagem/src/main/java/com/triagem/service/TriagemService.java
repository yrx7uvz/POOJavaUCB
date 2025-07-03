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
        List<Medico> medicosDisponiveis = medicoRepository.findByEmPlantaoTrue();
        if (medicosDisponiveis.isEmpty()) {
            return Optional.empty();
        }

        return pacienteRepository.findAll().stream()
            .sorted(Comparator.comparing(Paciente::getPrioridade).reversed()
                    .thenComparing(Paciente::getGravidade).reversed()
                    .thenComparing(Paciente::getDataEntrada))
            .findFirst();
    }
}