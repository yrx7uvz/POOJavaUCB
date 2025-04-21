public abstract class Reptil extends Animal {
    protected boolean escamas;
    protected boolean aquatico;

    public Reptil(String nome, int idade, double peso, String cor, boolean escamas, boolean aquatico) {
        super(nome, idade, peso, cor);
        this.escamas = escamas;
        this.aquatico = aquatico;
    }

    public void regularTemperatura() {
        System.out.println(nome + " está regulando sua temperatura corporal...");
    }

    public boolean temEscamas() {
        return escamas;
    }

    public boolean ehAquatico() {
        return aquatico;
    }

    @Override
    public String toString() {
        return super.toString() + 
               ", escamas: " + (escamas ? "sim" : "não") + 
               ", aquático: " + (aquatico ? "sim" : "não");
    }
}