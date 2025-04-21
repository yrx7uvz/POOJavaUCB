public class Pentagono extends Forma {
    private double ladoTamanho;
    
    public Pentagono(double ladoTamanho) {
        this.ladoTamanho = ladoTamanho;
    }
    
    @Override
    public double calcularArea() {
        //area do pentagono regular
        return (5 * ladoTamanho * ladoTamanho) / (4 * Math.tan(Math.PI / 5));
    }
    
    @Override
    public double calcularPerimetro() {
        return 5 * ladoTamanho;
    }
}