package br.edu.sistema;

import br.edu.sistema.view.LoginView;
import br.edu.sistema.config.ConexaoBanco;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SistemaEducacao {
    public static void main(String[] args) {
        try {
            // configurar aparência do sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
            
            // inicializar banco de dados
            ConexaoBanco.inicializarBanco();
            
            // executar interface gráfica
            SwingUtilities.invokeLater(() -> {
                new LoginView().setVisible(true);
            });
            
        } catch (Exception e) {
            System.err.println("erro ao inicializar sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
