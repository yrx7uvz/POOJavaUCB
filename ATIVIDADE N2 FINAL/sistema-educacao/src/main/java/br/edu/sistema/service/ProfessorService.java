package br.edu.sistema.service;

import br.edu.sistema.dao.ProfessorDAO;
import br.edu.sistema.model.Professor;
import br.edu.sistema.util.ValidacaoUtil;
import java.util.List;

public class ProfessorService {
    private final ProfessorDAO professorDAO;
    
    public ProfessorService() {
        this.professorDAO = new ProfessorDAO();
    }
    
    public boolean salvar(Professor professor) {
        if (!validarProfessor(professor)) {
            return false;
        }
        
        // formatar cpf
        professor.setCpf(ValidacaoUtil.formatarCPF(professor.getCpf()));
        
        return professorDAO.salvar(professor);
    }
    
    public boolean atualizar(Professor professor) {
        if (!validarProfessor(professor) || professor.getId() == null) {
            return false;
        }
        
        // formatar cpf
        professor.setCpf(ValidacaoUtil.formatarCPF(professor.getCpf()));
        
        return professorDAO.atualizar(professor);
    }
    
    public boolean excluir(Long id) {
        if (id == null) {
            return false;
        }
        
        return professorDAO.excluir(id);
    }
    
    public List<Professor> listarTodos() {
        return professorDAO.listarTodos();
    }
    
    public Professor buscarPorId(Long id) {
        return professorDAO.buscarPorId(id);
    }
    
    private boolean validarProfessor(Professor professor) {
        if (professor == null) {
            return false;
        }
        
        if (!ValidacaoUtil.validarTextoObrigatorio(professor.getNome())) {
            System.err.println("nome é obrigatório");
            return false;
        }
        
        if (!ValidacaoUtil.validarTextoObrigatorio(professor.getCpf())) {
            System.err.println("cpf é obrigatório");
            return false;
        }
        
        if (!ValidacaoUtil.validarTextoObrigatorio(professor.getEspecialidade())) {
            System.err.println("especialidade é obrigatória");
            return false;
        }
        
        if (professor.getEmail() != null && !professor.getEmail().trim().isEmpty() && 
            !ValidacaoUtil.validarEmail(professor.getEmail())) {
            System.err.println("email inválido");
            return false;
        }
        
        return true;
    }
}
