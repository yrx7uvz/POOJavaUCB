// arquivo: TelaLogin.java
package view;

import javax.swing.*;
import dao.Repositorio;
import model.Usuario;
import service.LoginService;

public class TelaLogin extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private LoginService loginService;

    public TelaLogin() {
        setTitle("login de usuário");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new java.awt.GridLayout(3, 2));

        campoLogin = new JTextField();
        campoSenha = new JPasswordField();

        add(new JLabel("login:"));
        add(campoLogin);
        add(new JLabel("senha:"));
        add(campoSenha);

        Repositorio<Usuario> repo = new Repositorio<>("usuarios.dat");
        loginService = new LoginService(repo);

        JButton botaoEntrar = new JButton("entrar");
        botaoEntrar.addActionListener(e -> {
            String login = campoLogin.getText();
            String senha = new String(campoSenha.getPassword());
            if (loginService.autenticar(login, senha)) {
                JOptionPane.showMessageDialog(this, "login bem-sucedido");
                new TelaProdutos().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "usuário ou senha inválidos");
            }
        });
        add(botaoEntrar);
    }
}