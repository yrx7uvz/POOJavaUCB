public class Galinha extends Ave {
    private boolean crista;

    public Galinha(String nome, int idade, double peso, String cor, boolean voa, double envergaduraAsas, boolean crista) {
        super(nome, idade, peso, cor, voa, envergaduraAsas);
        this.crista = crista;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está cacarejando!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está ciscando!");
    }

    public void ciscar() {
        System.out.println(nome + " está ciscando em busca de comida!");
    }

    public boolean temCrista() {
        return crista;
    }

    @Override
    public String toString() {
        return super.toString() + ", crista: " + (crista ? "sim" : "não");
    }
}