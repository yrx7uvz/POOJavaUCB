package br.edu.sistema.dao;

import br.edu.sistema.config.ConexaoBanco;
import br.edu.sistema.model.Aluno;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    
    public boolean salvar(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, cpf, data_nascimento, email, telefone, endereco, matricula, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getDataNascimento().toString());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getTelefone());
            stmt.setString(6, aluno.getEndereco());
            stmt.setString(7, aluno.getMatricula());
            stmt.setBoolean(8, aluno.isAtivo());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("erro ao salvar aluno: " + e.getMessage());
            return false;
        }
    }
    
    public boolean atualizar(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, cpf = ?, data_nascimento = ?, email = ?, telefone = ?, endereco = ?, matricula = ? WHERE id = ?";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getDataNascimento().toString());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getTelefone());
            stmt.setString(6, aluno.getEndereco());
            stmt.setString(7, aluno.getMatricula());
            stmt.setLong(8, aluno.getId());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("erro ao atualizar aluno: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir(Long id) {
        String sql = "UPDATE alunos SET ativo = FALSE WHERE id = ?";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.err.println("erro ao excluir aluno: " + e.getMessage());
            return false;
        }
    }
    
    public List<Aluno> listarTodos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos WHERE ativo = TRUE ORDER BY nome";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
                aluno.setEmail(rs.getString("email"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setAtivo(rs.getBoolean("ativo"));
                alunos.add(aluno);
            }
            
        } catch (SQLException e) {
            System.err.println("erro ao listar alunos: " + e.getMessage());
        }
        
        return alunos;
    }
    
    public Aluno buscarPorId(Long id) {
        String sql = "SELECT * FROM alunos WHERE id = ? AND ativo = TRUE";
        
        try (Connection conexao = ConexaoBanco.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
                aluno.setEmail(rs.getString("email"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setAtivo(rs.getBoolean("ativo"));
                return aluno;
            }
            
        } catch (SQLException e) {
            System.err.println("erro ao buscar aluno: " + e.getMessage());
        }
        
        return null;
    }
}
