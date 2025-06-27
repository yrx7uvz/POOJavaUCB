// arquivo: CriarUsuario.java
package view;

import dao.Repositorio;
import model.Usuario;

public class CriarUsuario {
    public static void main(String[] args) {
        // cria um repositório de usuários
        Repositorio<Usuario> repo = new Repositorio<>("usuarios.dat");

        // adiciona usuários iniciais
        repo.adicionar(new Usuario("administrador", "admin", "123"));
        repo.adicionar(new Usuario("usuario padrão", "user", "456"));

        System.out.println("usuários iniciais criados com sucesso.");
    }
}