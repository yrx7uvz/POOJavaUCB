package br.edu.sistema.service;

import br.edu.sistema.dao.AlunoDAO;
import br.edu.sistema.model.Aluno;
import br.edu.sistema.util.ValidacaoUtil;
import java.util.List;

public class AlunoService {
    private final AlunoDAO alunoDAO;
    
    public AlunoService() {
        this.alunoDAO = new AlunoDAO();
    }
    
    public boolean salvar(Aluno aluno) {
        if (!validarAluno(aluno)) {
            return false;
        }
        
        // formatar cpf
        aluno.setCpf(ValidacaoUtil.formatarCPF(aluno.getCpf()));
        
        return alunoDAO.salvar(aluno);
    }
    
    public boolean atualizar(Aluno aluno) {
        if (!validarAluno(aluno) || aluno.getId() == null) {
            return false;
        }
        
        // formatar cpf
        aluno.setCpf(ValidacaoUtil.formatarCPF(aluno.getCpf()));
        
        return alunoDAO.atualizar(aluno);
    }
    
    public boolean excluir(Long id) {
        if (id == null) {
            return false;
        }
        
        return alunoDAO.excluir(id);
    }
    
    public List<Aluno> listarTodos() {
        return alunoDAO.listarTodos();
    }
    
    public Aluno buscarPorId(Long id) {
        return alunoDAO.buscarPorId(id);
    }
    
    private boolean validarAluno(Aluno aluno) {
        if (aluno == null) {
            return false;
        }
        
        if (!ValidacaoUtil.validarTextoObrigatorio(aluno.getNome())) {
            System.err.println("nome é obrigatório");
            return false;
        }
        
        if (!ValidacaoUtil.validarTextoObrigatorio(aluno.getCpf())) {
            System.err.println("cpf é obrigatório");
            return false;
        }
        
        if (!ValidacaoUtil.validarTextoObrigatorio(aluno.getMatricula())) {
            System.err.println("matrícula é obrigatória");
            return false;
        }
        
        if (aluno.getDataNascimento() == null) {
            System.err.println("data de nascimento é obrigatória");
            return false;
        }
        
        if (aluno.getEmail() != null && !aluno.getEmail().trim().isEmpty() && 
            !ValidacaoUtil.validarEmail(aluno.getEmail())) {
            System.err.println("email inválido");
            return false;
        }
        
        return true;
    }
}
