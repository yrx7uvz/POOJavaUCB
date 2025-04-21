public class Calopsita extends Ave {
    private boolean topete;

    public Calopsita(String nome, int idade, double peso, String cor, boolean voa, double envergaduraAsas, boolean topete) {
        super(nome, idade, peso, cor, voa, envergaduraAsas);
        this.topete = topete;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está assobiando!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está voando!");
    }

    public void imitar() {
        System.out.println(nome + " está imitando sons!");
    }

    public boolean temTopete() {
        return topete;
    }

    @Override
    public String toString() {
        return super.toString() + ", topete: " + (topete ? "sim" : "não");
    }
}