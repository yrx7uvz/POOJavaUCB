package br.edu.sistema.model;

public class Usuario {
    private Long id;
    private String nomeUsuario;
    private String senha;
    private TipoUsuario tipoUsuario;
    private boolean ativo;
    
    public enum TipoUsuario {
        ADMINISTRADOR, FUNCIONARIO
    }
    
    // construtores
    public Usuario() {}
    
    public Usuario(String nomeUsuario, String senha, TipoUsuario tipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.ativo = true;
    }
    
    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }
    
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
