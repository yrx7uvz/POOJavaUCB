package com.triagem.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String sintomas;
    private String prioridade;
    private String gravidade;

    private LocalDateTime dataEntrada;

    @PrePersist
    protected void onCreate() {
        this.dataEntrada = LocalDateTime.now();
    }

    // getters e setters omitidos por brevidade
}