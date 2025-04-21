public abstract class Animal {
    protected String nome;
    protected int idade;
    protected double peso;
    protected String cor;

    public Animal(String nome, int idade, double peso, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.cor = cor;
    }

    public abstract void emitirSom();
    public abstract void mover();

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "nome: " + nome + 
               ", idade: " + idade + 
               ", peso: " + peso + "kg" +
               ", cor: " + cor;
    }
}