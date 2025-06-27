package br.edu.sistema.dao;

import br.edu.sistema.config.ConexaoBanco;
import br.edu.sistema.model.Professor;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    
    public boolean salvar(Professor professor) {
        String sql = "INSERT INTO professores (nome, cpf, email, telefone, especialidade, salario, ativo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getTelefone());
            stmt.setString(5, professor.getEspecialidade());
            stmt.setBigDecimal(6, professor.getSalario());
            stmt.setBoolean(7, professor.isAtivo());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("erro ao salvar professor: " + e.getMessage());
            return false;
        }
    }
    
    public boolean atualizar(Professor professor) {
        String sql = "UPDATE professores SET nome = ?, cpf = ?, email = ?, telefone = ?, especialidade = ?, salario = ? WHERE id = ?";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getEmail());
            stmt.setString(4, professor.getTelefone());
            stmt.setString(5, professor.getEspecialidade());
            stmt.setBigDecimal(6, professor.getSalario());
            stmt.setLong(7, professor.getId());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("erro ao atualizar professor: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir(Long id) {
        String sql = "UPDATE professores SET ativo = FALSE WHERE id = ?";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("erro ao excluir professor: " + e.getMessage());
            return false;
        }
    }
    
    public List<Professor> listarTodos() {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professores WHERE ativo = TRUE ORDER BY nome";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Professor professor = new Professor();
                professor.setId(rs.getLong("id"));
                professor.setNome(rs.getString("nome"));
                professor.setCpf(rs.getString("cpf"));
                professor.setEmail(rs.getString("email"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setEspecialidade(rs.getString("especialidade"));
                BigDecimal salario = rs.getBigDecimal("salario");
                professor.setSalario(salario);
                professor.setAtivo(rs.getBoolean("ativo"));
                professores.add(professor);
            }
            
        } catch (SQLException e) {
            System.err.println("erro ao listar professores: " + e.getMessage());
        }
        
        return professores;
    }
    
    public Professor buscarPorId(Long id) {
        String sql = "SELECT * FROM professores WHERE id = ? AND ativo = TRUE";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Professor professor = new Professor();
                professor.setId(rs.getLong("id"));
                professor.setNome(rs.getString("nome"));
                professor.setCpf(rs.getString("cpf"));
                professor.setEmail(rs.getString("email"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setEspecialidade(rs.getString("especialidade"));
                professor.setSalario(rs.getBigDecimal("salario"));
                professor.setAtivo(rs.getBoolean("ativo"));
                return professor;
            }
            
        } catch (SQLException e) {
            System.err.println("erro ao buscar professor: " + e.getMessage());
        }
        
        return null;
    }
}
