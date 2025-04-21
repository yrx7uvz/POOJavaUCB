public class Tartaruga extends Reptil {
    private double tamanhoCasco;

    public Tartaruga(String nome, int idade, double peso, String cor, boolean escamas, boolean aquatico, double tamanhoCasco) {
        super(nome, idade, peso, cor, escamas, aquatico);
        this.tamanhoCasco = tamanhoCasco;
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " está emitindo um som!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " está se movendo lentamente!");
    }

    public void retrairParaCasco() {
        System.out.println(nome + " se retraiu dentro do casco!");
    }

    public double getTamanhoCasco() {
        return tamanhoCasco;
    }

    @Override
    public String toString() {
        return super.toString() + ", tamanho do casco: " + tamanhoCasco + "cm";
    }
}