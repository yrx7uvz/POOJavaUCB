package br.edu.sistema.service;

import br.edu.sistema.dao.DisciplinaDAO;
import br.edu.sistema.model.Disciplina;
import br.edu.sistema.util.ValidacaoUtil;
import java.util.List;

public class DisciplinaService {
    private final DisciplinaDAO disciplinaDAO;
    
    public DisciplinaService() {
        this.disciplinaDAO = new DisciplinaDAO();
    }
    
    public boolean salvar(Disciplina disciplina) {
        if (!validarDisciplina(disciplina)) {
            return false;
        }
        
        return disciplinaDAO.salvar(disciplina);
    }
    
    public boolean atualizar(Disciplina disciplina) {
        if (!validarDisciplina(disciplina) || disciplina.getId() == null) {
            return false;
        }
        
        return disciplinaDAO.atualizar(disciplina);
    }
    
    public boolean excluir(Long id) {
        if (id == null) {
            return false;
        }
        
        return disciplinaDAO.excluir(id);
    }
    
    public List<Disciplina> listarTodos() {
        return disciplinaDAO.listarTodos();
    }
    
    public Disciplina buscarPorId(Long id) {
        return disciplinaDAO.buscarPorId(id);
    }
    
    private boolean validarDisciplina(Disciplina disciplina) {
        if (disciplina == null) {
            return false;
        }
        
        if (!ValidacaoUtil.validarTextoObrigatorio(disciplina.getNome())) {
            System.err.println("nome é obrigatório");
            return false;
        }
        
        if (!ValidacaoUtil.validarTextoObrigatorio(disciplina.getCodigo())) {
            System.err.println("código é obrigatório");
            return false;
        }
        
        if (disciplina.getCargaHoraria() == null || disciplina.getCargaHoraria() <= 0) {
            System.err.println("carga horária deve ser maior que zero");
            return false;
        }
        
        return true;
    }
}
