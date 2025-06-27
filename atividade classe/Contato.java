public class Contato {
    private String nome;
    private String telefone;
    
    // construtor
    public Contato() {
        this.nome = "";
        this.telefone = "";
    }
    
    //get e set para nome
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    //get e set para telefone
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}