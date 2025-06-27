package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {
    private JTextField nomeField, idadeField;
    private RepositorioPacientes repositorio = new RepositorioPacientes();

    public TelaCadastro() {
        setTitle("Cadastro de Pacientes");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(this::salvarPaciente);
        add(salvarBtn);

        JButton listarBtn = new JButton("Listar");
        listarBtn.addActionListener(e -> new TelaLista(repositorio).setVisible(true));
        add(listarBtn);
    }

    private void salvarPaciente(ActionEvent e) {
        String nome = nomeField.getText();
        try {
            int idade = Integer.parseInt(idadeField.getText());
            Paciente paciente = new Paciente(nome, idade);
            repositorio.adicionarPaciente(paciente);
            JOptionPane.showMessageDialog(this, "Paciente salvo com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Idade deve ser um número válido.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}