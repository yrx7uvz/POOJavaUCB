public class Retangulo extends Forma {
    private double comprimento;
    private double largura;
    
    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }
    
    @Override
    public double calcularArea() {
        return comprimento * largura;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * (comprimento + largura);
    }
}