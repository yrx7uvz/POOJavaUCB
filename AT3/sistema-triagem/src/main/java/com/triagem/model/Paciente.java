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

    // construtor padrão (obrigatório para JPA)
    public Paciente() {}

    // construtor com campos úteis (usado no DataLoader)
    public Paciente(String nome, int idade, String sintomas, String prioridade, String gravidade) {
        this.nome = nome;
        this.idade = idade;
        this.sintomas = sintomas;
        this.prioridade = prioridade;
        this.gravidade = gravidade;
        this.dataEntrada = LocalDateTime.now(); // define a entrada no momento da criação
    }

    // define a data de entrada automaticamente antes de persistir (caso não tenha sido setada)
    @PrePersist
    protected void onCreate() {
        if (this.dataEntrada == null) {
            this.dataEntrada = LocalDateTime.now();
        }
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}
