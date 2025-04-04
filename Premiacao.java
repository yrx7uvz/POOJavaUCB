/**Classe da premiação*/

public class Premiacao {
    private String nome;
    private int ano;
    private String tipo; // ex: Nacional, Internacional, etc.

    // Construtor
    public Premiacao(String nome, int ano, String tipo) {
        this.nome = nome;
        this.ano = ano;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Premiacao{" +
                "nome='" + nome + '\'' +
                ", ano=" + ano +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}