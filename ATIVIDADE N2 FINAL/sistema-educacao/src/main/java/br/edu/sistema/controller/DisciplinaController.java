package br.edu.sistema.controller;

import br.edu.sistema.model.Disciplina;
import br.edu.sistema.model.Professor;
import br.edu.sistema.service.DisciplinaService;
import br.edu.sistema.service.ProfessorService;
import java.util.List;

public class DisciplinaController {
    private DisciplinaService disciplinaService;
    private ProfessorService professorService;
    
    public DisciplinaController() {
        this.disciplinaService = new DisciplinaService();
        this.professorService = new ProfessorService();
    }
    
    public boolean salvarDisciplina(String nome, String codigo, String cargaHoraria, Long professorId) {
        try {
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(nome);
            disciplina.setCodigo(codigo);
            
            // converter carga horária
            if (cargaHoraria != null && !cargaHoraria.trim().isEmpty()) {
                Integer carga = Integer.parseInt(cargaHoraria);
                disciplina.setCargaHoraria(carga);
            }
            
            // associar professor se selecionado
            if (professorId != null && professorId > 0) {
                disciplina.setProfessorId(professorId);
            }
            
            return disciplinaService.salvar(disciplina);
            
        } catch (NumberFormatException e) {
            System.err.println("erro ao converter carga horária: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("erro ao salvar disciplina: " + e.getMessage());
            return false;
        }
    }
    
    public boolean atualizarDisciplina(Long id, String nome, String codigo, 
                                      String cargaHoraria, Long professorId) {
        try {
            Disciplina disciplina = new Disciplina();
            disciplina.setId(id);
            disciplina.setNome(nome);
            disciplina.setCodigo(codigo);
            
            // converter carga horária
            if (cargaHoraria != null && !cargaHoraria.trim().isEmpty()) {
                Integer carga = Integer.parseInt(cargaHoraria);
                disciplina.setCargaHoraria(carga);
            }
            
            // associar professor se selecionado
            if (professorId != null && professorId > 0) {
                disciplina.setProfessorId(professorId);
            }
            
            return disciplinaService.atualizar(disciplina);
            
        } catch (NumberFormatException e) {
            System.err.println("erro ao converter carga horária: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("erro ao atualizar disciplina: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluirDisciplina(Long id) {
        if (id == null) {
            return false;
        }
        
        return disciplinaService.excluir(id);
    }
    
    public List<Disciplina> listarTodasDisciplinas() {
        return disciplinaService.listarTodos();
    }
    
    public Disciplina buscarDisciplinaPorId(Long id) {
        if (id == null) {
            return null;
        }
        
        return disciplinaService.buscarPorId(id);
    }
    
    public List<Professor> listarTodosProfessores() {
        return professorService.listarTodos();
    }
    
    public Professor buscarProfessorPorId(Long id) {
        if (id == null) {
            return null;
        }
        
        return professorService.buscarPorId(id);
    }
    
    public boolean validarCamposObrigatorios(String nome, String codigo, String cargaHoraria) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }
        
        if (cargaHoraria == null || cargaHoraria.trim().isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    public String obterMensagemValidacao(String nome, String codigo, String cargaHoraria) {
        if (nome == null || nome.trim().isEmpty()) {
            return "nome é obrigatório";
        }
        
        if (codigo == null || codigo.trim().isEmpty()) {
            return "código é obrigatório";
        }
        
        if (cargaHoraria == null || cargaHoraria.trim().isEmpty()) {
            return "carga horária é obrigatória";
        }
        
        // validar carga horária
        try {
            Integer carga = Integer.parseInt(cargaHoraria);
            if (carga <= 0) {
                return "carga horária deve ser maior que zero";
            }
        } catch (NumberFormatException e) {
            return "carga horária deve ser um número válido";
        }
        
        return null; // sem erros
    }
    
    public boolean validarCargaHoraria(String cargaHoraria) {
        if (cargaHoraria == null || cargaHoraria.trim().isEmpty()) {
            return false;
        }
        
        try {
            Integer carga = Integer.parseInt(cargaHoraria);
            return carga > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public String obterNomeProfessor(Long professorId) {
        if (professorId == null) {
            return "Não atribuído";
        }
        
        Professor professor = professorService.buscarPorId(professorId);
        return professor != null ? professor.getNome() : "Professor não encontrado";
    }
}
