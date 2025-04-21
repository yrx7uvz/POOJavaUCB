public class Gato extends Mamifero {
    private boolean castrado;

    public Gato(String nome, int idade, double peso, String cor, boolean pelagem, int tempGestacao, boolean castrado) {
        super(nome, idade, peso, cor, pelagem, tempGestacao);
        this.castrado = castrado;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está miando!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está andando silenciosamente!");
    }

    public void arranhar() {
        System.out.println(nome + " está arranhando algo!");
    }

    public boolean estaCastrado() {
        return castrado;
    }

    @Override
    public String toString() {
        return super.toString() + ", castrado: " + (castrado ? "sim" : "não");
    }
}