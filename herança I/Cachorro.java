public class Cachorro extends Mamifero {
    private String raca;

    public Cachorro(String nome, int idade, double peso, String cor, boolean pelagem, int tempGestacao, String raca) {
        super(nome, idade, peso, cor, pelagem, tempGestacao);
        this.raca = raca;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está latindo!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está correndo!");
    }

    public void abanarRabo() {
        System.out.println(nome + " está abanando o rabo!");
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return super.toString() + ", raça: " + raca;
    }
}