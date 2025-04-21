public abstract class Ave extends Animal {
    protected boolean voa;
    protected double envergaduraAsas;

    public Ave(String nome, int idade, double peso, String cor, boolean voa, double envergaduraAsas) {
        super(nome, idade, peso, cor);
        this.voa = voa;
        this.envergaduraAsas = envergaduraAsas;
    }

    public void botarOvo() {
        System.out.println(nome + " está botando ovo...");
    }

    public boolean podeVoar() {
        return voa;
    }

    public double getEnvergaduraAsas() {
        return envergaduraAsas;
    }

    @Override
    public String toString() {
        return super.toString() + 
               ", voa: " + (voa ? "sim" : "não") + 
               ", envergadura das asas: " + envergaduraAsas + "cm";
    }
}