public class Iguana extends Reptil {
    private double tamanhoCauda;

    public Iguana(String nome, int idade, double peso, String cor, boolean escamas, boolean aquatico, double tamanhoCauda) {
        super(nome, idade, peso, cor, escamas, aquatico);
        this.tamanhoCauda = tamanhoCauda;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está sibilando suavemente!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está se arrastando rapidamente!");
    }

    public void escalar() {
        System.out.println(nome + " está escalando uma superfície com suas garras!");
    }

    public double getTamanhoCauda() {
        return tamanhoCauda;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tamanho da Cauda: " + tamanhoCauda + "cm";
    }
}