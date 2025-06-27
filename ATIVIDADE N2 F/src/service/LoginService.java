// arquivo: LoginService.java
package service;

import model.Usuario;
import dao.Repositorio;

public class LoginService {
    private Repositorio<Usuario> repoUsuarios;

    public LoginService(Repositorio<Usuario> repoUsuarios) {
        this.repoUsuarios = repoUsuarios;
    }

    public boolean autenticar(String login, String senha) {
        for (Usuario u : repoUsuarios.listar()) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}