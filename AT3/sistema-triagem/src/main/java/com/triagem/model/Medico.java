package com.triagem.model;

import jakarta.persistence.*;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;
    private String crm;
    private boolean emPlantao;

    // getters e setters omitidos por brevidade
}