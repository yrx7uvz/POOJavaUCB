public class Elipse extends Forma {
    private double semiEixoMaior;
    private double semiEixoMenor;
    
    public Elipse(double semiEixoMaior, double semiEixoMenor) {
        this.semiEixoMaior = semiEixoMaior;
        this.semiEixoMenor = semiEixoMenor;
    }
    
    public double getRaioMaior() {
        return semiEixoMaior;
    }
    
    public double getRaioMenor() {
        return semiEixoMenor;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * semiEixoMaior * semiEixoMenor;
    }
    
    @Override
    public double calcularPerimetro() {
        //fórmula de ramanujan (valor aproximado)
        double a = semiEixoMaior;
        double b = semiEixoMenor;
        double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }
}