public class Pardal extends Ave {
    private String tipoNinho;

    public Pardal(String nome, int idade, double peso, String cor, boolean voa, double envergaduraAsas, String tipoNinho) {
        super(nome, idade, peso, cor, voa, envergaduraAsas);
        this.tipoNinho = tipoNinho;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está piando!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está voando rapidamente!");
    }

    public void construirNinho() {
        System.out.println(nome + " está construindo um ninho do tipo " + tipoNinho);
    }

    public String getTipoNinho() {
        return tipoNinho;
    }

    @Override
    public String toString() {
        return super.toString() + ", tipo de ninho: " + tipoNinho;
    }
}