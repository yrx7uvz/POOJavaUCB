// arquivo: TelaProdutos.java
package view;

import javax.swing.*;
import java.util.List;
import dao.Repositorio;
import model.Produto;

public class TelaProdutos extends JFrame {
    private Repositorio<Produto> repoProdutos = new Repositorio<>("produtos.dat");

    public TelaProdutos() {
        setTitle("cadastro de produtos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new java.awt.BorderLayout());

        DefaultListModel<String> modelo = new DefaultListModel<>();
        List<Produto> lista = repoProdutos.listar();
        for (Produto p : lista) {
            modelo.addElement(p.toString());
        }

        JList<String> listaProdutos = new JList<>(modelo);
        add(new JScrollPane(listaProdutos), java.awt.BorderLayout.CENTER);

        JButton botaoAdicionar = new JButton("adicionar produto");
        botaoAdicionar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("nome do produto:");
            String precoStr = JOptionPane.showInputDialog("preço:");
            try {
                double preco = Double.parseDouble(precoStr);
                Produto produto = new Produto(nome, preco);
                repoProdutos.adicionar(produto);
                modelo.addElement(produto.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "preço inválido");
            }
        });
        add(botaoAdicionar, java.awt.BorderLayout.SOUTH);
    }
}