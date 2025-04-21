public class Arara extends Ave {
    private String especieArara;

    public Arara(String nome, int idade, double peso, String cor, boolean voa, double envergaduraAsas, String especieArara) {
        super(nome, idade, peso, cor, voa, envergaduraAsas);
        this.especieArara = especieArara;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está gritando alto!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está planando com suas asas!");
    }

    public void bicar() {
        System.out.println(nome + " está bicando frutos!");
    }

    public String getEspecieArara() {
        return especieArara;
    }

    @Override
    public String toString() {
        return super.toString() + ", espécie de arara: " + especieArara;
    }
}