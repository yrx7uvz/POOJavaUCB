public class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo(5);
        System.out.println("círculo - área: " + circulo.calcularArea() + 
                           ", perímetro: " + circulo.calcularPerimetro() + 
                           ", raio: " + circulo.getRaio());
        
        Quadrado quadrado = new Quadrado(4);
        System.out.println("quadrado - área: " + quadrado.calcularArea() + 
                           ", perímetro: " + quadrado.calcularPerimetro());
        
        Triangulo triangulo = new Triangulo(3, 4, 5);
        System.out.println("triângulo - área: " + triangulo.calcularArea() + 
                           ", perímetro: " + triangulo.calcularPerimetro());
        
        Retangulo retangulo = new Retangulo(5, 3);
        System.out.println("retângulo - área: " + retangulo.calcularArea() + 
                           ", perímetro: " + retangulo.calcularPerimetro());
        
        Elipse elipse = new Elipse(5, 3);
        System.out.println("elipse - área: " + elipse.calcularArea() + 
                           ", perímetro: " + elipse.calcularPerimetro() + 
                           ", raio maior: " + elipse.getRaioMaior() + 
                           ", raio menor: " + elipse.getRaioMenor());
        
        Pentagono pentagono = new Pentagono(4);
        System.out.println("pentágono - área: " + pentagono.calcularArea() + 
                           ", perímetro: " + pentagono.calcularPerimetro());
    }
}