package br.edu.sistema.dao;

import br.edu.sistema.config.ConexaoBanco;
import br.edu.sistema.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    public Usuario buscarPorNomeUsuario(String nomeUsuario) {
        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND ativo = TRUE";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, nomeUsuario);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(rs.getString("tipo_usuario")));
                usuario.setAtivo(rs.getBoolean("ativo"));
                return usuario;
            }
            
        } catch (SQLException e) {
            System.err.println("erro ao buscar usuário: " + e.getMessage());
        }
        
        return null;
    }
    
    public boolean salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome_usuario, senha, tipo_usuario, ativo) VALUES (?, ?, ?, ?)";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTipoUsuario().name());
            stmt.setBoolean(4, usuario.isAtivo());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("erro ao salvar usuário: " + e.getMessage());
            return false;
        }
    }
    
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE ativo = TRUE ORDER BY nome_usuario";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNomeUsuario(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(rs.getString("tipo_usuario")));
                usuario.setAtivo(rs.getBoolean("ativo"));
                usuarios.add(usuario);
            }
            
        } catch (SQLException e) {
            System.err.println("erro ao listar usuários: " + e.getMessage());
        }
        
        return usuarios;
    }
}
