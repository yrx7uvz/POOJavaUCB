public abstract class Mamifero extends Animal {
    protected boolean pelagem;
    protected int tempGestacao;

    public Mamifero(String nome, int idade, double peso, String cor, boolean pelagem, int tempGestacao) {
        super(nome, idade, peso, cor);
        this.pelagem = pelagem;
        this.tempGestacao = tempGestacao;
    }

    public void amamentar() {
        System.out.println(nome + " está amamentando...");
    }

    public boolean temPelagem() {
        return pelagem;
    }

    public int getTempoGestacao() {
        return tempGestacao;
    }

    @Override
    public String toString() {
        return super.toString() + 
               ", pelagem: " + (pelagem ? "sim" : "não") + 
               ", tempo de gestação: " + tempGestacao + " dias";
    }
}