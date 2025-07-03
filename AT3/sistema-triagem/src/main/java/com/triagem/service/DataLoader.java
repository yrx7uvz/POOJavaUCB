package com.triagem.config;

import com.triagem.model.Medico;
import com.triagem.model.Paciente;
import com.triagem.repository.MedicoRepository;
import com.triagem.repository.PacienteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void run(String... args) throws Exception {
        // verifica se o banco já tem dados
        if (pacienteRepository.count() == 0) {
            // cria pacientes iniciais
            pacienteRepository.save(new Paciente("João", 45, "atropelamento", "vermelha", "grave"));
            pacienteRepository.save(new Paciente("Maria", 32, "febre alta", "amarela", "moderada"));
            pacienteRepository.save(new Paciente("Carlos", 27, "corte no braço", "verde", "leve"));
        }

        if (medicoRepository.count() == 0) {
            // cria médicos iniciais
            medicoRepository.save(new Medico("Dra. Ana", "Clínica Geral", "CRM001", true));
            medicoRepository.save(new Medico("Dr. Pedro", "Ortopedia", "CRM002", false));
        }
    }
}
