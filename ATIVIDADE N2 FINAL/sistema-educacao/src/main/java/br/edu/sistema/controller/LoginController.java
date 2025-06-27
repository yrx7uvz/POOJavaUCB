package br.edu.sistema.controller;

import br.edu.sistema.service.AutenticacaoService;
import br.edu.sistema.model.Usuario;

public class LoginController {
    private AutenticacaoService autenticacaoService;
    
    public LoginController() {
        this.autenticacaoService = new AutenticacaoService();
    }
    
    public boolean realizarLogin(String nomeUsuario, String senha) {
        if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
            return false;
        }
        
        if (senha == null || senha.trim().isEmpty()) {
            return false;
        }
        
        return autenticacaoService.autenticar(nomeUsuario.trim(), senha);
    }
    
    public void realizarLogout() {
        autenticacaoService.logout();
    }
    
    public Usuario obterUsuarioLogado() {
        return autenticacaoService.getUsuarioLogado();
    }
    
    public boolean isUsuarioLogado() {
        return autenticacaoService.isLogado();
    }
    
    public boolean isUsuarioAdministrador() {
        return autenticacaoService.isAdministrador();
    }
    
    public AutenticacaoService getAutenticacaoService() {
        return autenticacaoService;
    }
}
