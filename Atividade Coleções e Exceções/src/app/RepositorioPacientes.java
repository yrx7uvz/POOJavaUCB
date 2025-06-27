package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPacientes {
    private static final String ARQUIVO = "pacientes.dat";
    private List<Paciente> pacientes;

    public RepositorioPacientes() {
        pacientes = carregarPacientes();
    }

    @SuppressWarnings("unchecked")
    private List<Paciente> carregarPacientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (List<Paciente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public void salvarPacientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(pacientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        salvarPacientes();
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }
}