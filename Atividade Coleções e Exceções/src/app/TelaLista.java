package app;

import javax.swing.*;
import java.awt.*;

public class TelaLista extends JFrame {
    public TelaLista(RepositorioPacientes repositorio) {
        setTitle("Lista de Pacientes");
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Paciente p : repositorio.listarPacientes()) {
            model.addElement(p.toString());
        }

        JList<String> lista = new JList<>(model);
        add(new JScrollPane(lista), BorderLayout.CENTER);
    }
}