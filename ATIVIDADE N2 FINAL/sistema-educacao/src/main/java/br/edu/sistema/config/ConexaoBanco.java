package br.edu.sistema.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {
    private static final String URL_BANCO = "jdbc:sqlite:database/escola.db";
    
    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL_BANCO);
    }
    
    public static void inicializarBanco() {
        try (Connection conexao = obterConexao();
             Statement stmt = conexao.createStatement()) {
            
            // criar tabela usuarios
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome_usuario TEXT UNIQUE NOT NULL,
                    senha TEXT NOT NULL,
                    tipo_usuario TEXT NOT NULL,
                    ativo BOOLEAN DEFAULT TRUE
                )
            """);
            
            // criar tabela alunos
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS alunos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    cpf TEXT UNIQUE NOT NULL,
                    data_nascimento TEXT NOT NULL,
                    email TEXT,
                    telefone TEXT,
                    endereco TEXT,
                    matricula TEXT UNIQUE NOT NULL,
                    ativo BOOLEAN DEFAULT TRUE
                )
            """);
            
            // criar tabela professores
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS professores (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    cpf TEXT UNIQUE NOT NULL,
                    email TEXT,
                    telefone TEXT,
                    especialidade TEXT,
                    salario REAL,
                    ativo BOOLEAN DEFAULT TRUE
                )
            """);
            
            // criar tabela disciplinas
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS disciplinas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    codigo TEXT UNIQUE NOT NULL,
                    carga_horaria INTEGER,
                    professor_id INTEGER,
                    ativo BOOLEAN DEFAULT TRUE,
                    FOREIGN KEY (professor_id) REFERENCES professores(id)
                )
            """);
            
            // inserir usuário administrador padrão
            stmt.execute("""
                INSERT OR IGNORE INTO usuarios (nome_usuario, senha, tipo_usuario) 
                VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'ADMINISTRADOR')
            """);
            
            System.out.println("banco de dados inicializado com sucesso!");
            
        } catch (SQLException e) {
            System.err.println("erro ao inicializar banco: " + e.getMessage());
        }
    }
}
