package br.edu.sistema.view;

import br.edu.sistema.service.AutenticacaoService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoSair;
    private AutenticacaoService autenticacaoService;
    
    public LoginView() {
        this.autenticacaoService = new AutenticacaoService();
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }
    
    private void inicializarComponentes() {
        setTitle("Sistema de Gestão Escolar - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        
        campoUsuario = new JTextField(20);
        campoSenha = new JPasswordField(20);
        botaoLogin = new JButton("Entrar");
        botaoSair = new JButton("Sair");
    }
    
    private void configurarLayout() {
        setLayout(new BorderLayout());
        
        // painel principal
        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // título
        JLabel titulo = new JLabel("Sistema de Gestão Escolar");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        painelPrincipal.add(titulo, gbc);
        
        // campos de login
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        
        gbc.gridx = 0; gbc.gridy = 1;
        painelPrincipal.add(new JLabel("Usuário:"), gbc);
        
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        painelPrincipal.add(campoUsuario, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        painelPrincipal.add(new JLabel("Senha:"), gbc);
        
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        painelPrincipal.add(campoSenha, gbc);
        
        // botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(botaoLogin);
        painelBotoes.add(botaoSair);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painelPrincipal.add(painelBotoes, gbc);
        
        add(painelPrincipal, BorderLayout.CENTER);
        
        // informações de login padrão
        JPanel painelInfo = new JPanel();
        painelInfo.add(new JLabel("Login padrão: admin | Senha: admin"));
        add(painelInfo, BorderLayout.SOUTH);
    }
    
    private void configurarEventos() {
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
        
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // permitir login com enter
        campoSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
    }
    
    private void realizarLogin() {
        String usuario = campoUsuario.getText().trim();
        String senha = new String(campoSenha.getPassword());
        
        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, preencha usuário e senha.", 
                "Campos Obrigatórios", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (autenticacaoService.autenticar(usuario, senha)) {
            // login bem-sucedido
            this.dispose();
            new MenuPrincipalView(autenticacaoService).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Usuário ou senha inválidos.", 
                "Erro de Autenticação", 
                JOptionPane.ERROR_MESSAGE);
            campoSenha.setText("");
            campoUsuario.requestFocus();
        }
    }
}
