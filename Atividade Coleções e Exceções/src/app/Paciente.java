package app;

import java.io.Serializable;

public class Paciente implements Serializable {
    private String nome;
    private int idade;

    public Paciente(String nome, int idade) throws IllegalArgumentException {
        if (nome == null || nome.isEmpty() || idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Dados inválidos para o paciente.");
        }
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return nome + " - " + idade + " anos";
    }
}