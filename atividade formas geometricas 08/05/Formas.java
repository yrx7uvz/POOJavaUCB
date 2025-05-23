// interface base para formas geometricas
interface forma {
    double getarea();
    double getperimetro();
    void exibirinformacoes();
}

// classe abstrata para figuras circulares
abstract class figuracircular implements forma {
    protected double raio;
    
    public figuracircular(double raio) {
        this.raio = raio;
    }
    
    public double getraio() {
        return raio;
    }
    
    public double getdiametro() {
        return 2 * raio;
    }
}

// classe triangulo
class triangulo implements forma {
    private double lado1, lado2, lado3;
    
    // construtor com tres lados
    public triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    
    // construtor para triangulo equilatero
    public triangulo(double lado) {
        this.lado1 = this.lado2 = this.lado3 = lado;
    }
    
    @Override
    public double getarea() {
        // formula de heron
        double s = getperimetro() / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
    
    @Override
    public double getperimetro() {
        return lado1 + lado2 + lado3;
    }
    
    // sobrecarga - getarea com base e altura
    public double getarea(double base, double altura) {
        return (base * altura) / 2;
    }
    
    // sobrecarga - getperimetro para triangulo retangulo
    public double getperimetro(double cateto1, double cateto2) {
        double hipotenusa = Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);
        return cateto1 + cateto2 + hipotenusa;
    }
    
    @Override
    public void exibirinformacoes() {
        System.out.println("triangulo - lados: " + lado1 + ", " + lado2 + ", " + lado3);
        System.out.println("area: " + String.format("%.2f", getarea()));
        System.out.println("perimetro: " + String.format("%.2f", getperimetro()));
    }
}

// classe retangulo
class retangulo implements forma {
    private double largura, altura;
    
    // construtor retangulo
    public retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }
    
    // construtor quadrado
    public retangulo(double lado) {
        this.largura = this.altura = lado;
    }
    
    @Override
    public double getarea() {
        return largura * altura;
    }
    
    @Override
    public double getperimetro() {
        return 2 * (largura + altura);
    }
    
    // sobrecarga - getarea com precisao
    public double getarea(int casasdecimais) {
        double area = getarea();
        double fator = Math.pow(10, casasdecimais);
        return Math.round(area * fator) / fator;
    }
    
    // sobrecarga - getperimetro apenas com largura (assumindo quadrado)
    public double getperimetro(double lado) {
        return 4 * lado;
    }
    
    @Override
    public void exibirinformacoes() {
        System.out.println("retangulo - largura: " + largura + ", altura: " + altura);
        System.out.println("area: " + String.format("%.2f", getarea()));
        System.out.println("perimetro: " + String.format("%.2f", getperimetro()));
    }
}

// classe circunferencia
class circunferencia extends figuracircular {
    
    public circunferencia(double raio) {
        super(raio);
    }
    
    @Override
    public double getarea() {
        return Math.PI * raio * raio;
    }
    
    @Override
    public double getperimetro() {
        return 2 * Math.PI * raio;
    }
    
    // sobrecarga - getarea com diametro
    public double getarea(double diametro, boolean usardiametro) {
        if (usardiametro) {
            double r = diametro / 2;
            return Math.PI * r * r;
        }
        return getarea();
    }
    
    // sobrecarga - getperimetro com diametro
    public double getperimetro(double diametro, boolean usardiametro) {
        if (usardiametro) {
            return Math.PI * diametro;
        }
        return getperimetro();
    }
    
    @Override
    public void exibirinformacoes() {
        System.out.println("circunferencia - raio: " + raio);
        System.out.println("area: " + String.format("%.2f", getarea()));
        System.out.println("perimetro: " + String.format("%.2f", getperimetro()));
        System.out.println("diametro: " + String.format("%.2f", getdiametro()));
    }
}

// classe pentagono
class pentagono implements forma {
    private double lado;
    
    public pentagono(double lado) {
        this.lado = lado;
    }
    
    @Override
    public double getarea() {
        // formula para pentagono regular
        return (Math.sqrt(25 + 10 * Math.sqrt(5)) / 4) * lado * lado;
    }
    
    @Override
    public double getperimetro() {
        return 5 * lado;
    }
    
    // sobrecarga - getarea com apotema
    public double getarea(double lado, double apotema) {
        return (getperimetro() * apotema) / 2;
    }
    
    // sobrecarga - getperimetro para poligono regular
    public double getperimetro(double lado, int numlados) {
        return numlados * lado;
    }
    
    @Override
    public void exibirinformacoes() {
        System.out.println("pentagono - lado: " + lado);
        System.out.println("area: " + String.format("%.2f", getarea()));
        System.out.println("perimetro: " + String.format("%.2f", getperimetro()));
    }
}

// classe elipse para demonstrar polimorfismo
class elipse extends figuracircular {
    private double semieixomenor;
    
    public elipse(double semieixomaior, double semieixomenor) {
        super(semieixomaior); // raio sera o semieixo maior
        this.semieixomenor = semieixomenor;
    }
    
    @Override
    public double getarea() {
        return Math.PI * raio * semieixomenor;
    }
    
    @Override
    public double getperimetro() {
        // aproximacao de ramanujan para perimetro da elipse
        double a = raio;
        double b = semieixomenor;
        double h = Math.pow((a - b) / (a + b), 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }
    
    @Override
    public void exibirinformacoes() {
        System.out.println("elipse - semieixo maior: " + raio + ", semieixo menor: " + semieixomenor);
        System.out.println("area: " + String.format("%.2f", getarea()));
        System.out.println("perimetro: " + String.format("%.2f", getperimetro()));
    }
}

// classe principal
public class formasgeometricas {
    
    // funcao que trabalha apenas com figuras circulares (polimorfismo)
    public static void exibirpropriedadescirculares(figuracircular[] figuras) {
        System.out.println("\n=== propriedades de figuras circulares ===");
        for (figuracircular figura : figuras) {
            System.out.println("raio: " + String.format("%.2f", figura.getraio()));
            System.out.println("diametro: " + String.format("%.2f", figura.getdiametro()));
            System.out.println("area: " + String.format("%.2f", figura.getarea()));
            System.out.println("---");
        }
    }
    
    // funcao para calcular area total de um conjunto de formas
    public static double calcularareaTotal(forma[] formas) {
        double total = 0;
        for (forma forma : formas) {
            total += forma.getarea();
        }
        return total;
    }
    
    // funcao para calcular perimetro total de um conjunto de formas
    public static double calcularperimetrototal(forma[] formas) {
        double total = 0;
        for (forma forma : formas) {
            total += forma.getperimetro();
        }
        return total;
    }
    
    // funcao para exibir todas as formas
    public static void exibirtodasformas(forma[] formas) {
        System.out.println("\n=== todas as formas geometricas ===");
        for (int i = 0; i < formas.length; i++) {
            System.out.println("forma " + (i + 1) + ":");
            formas[i].exibirinformacoes();
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // criando diferentes formas geometricas
        triangulo triangulo1 = new triangulo(3, 4, 5); // triangulo retangulo
        triangulo triangulo2 = new triangulo(6); // triangulo equilatero
        
        retangulo retangulo1 = new retangulo(5, 8);
        retangulo quadrado1 = new retangulo(4); // quadrado
        
        circunferencia circulo1 = new circunferencia(3);
        circunferencia circulo2 = new circunferencia(5);
        
        pentagono pentagono1 = new pentagono(4);
        
        elipse elipse1 = new elipse(6, 4);
        
        // array com todas as formas
        forma[] todasformas = {
            triangulo1, triangulo2, retangulo1, quadrado1, 
            circulo1, circulo2, pentagono1, elipse1
        };
        
        // array apenas com figuras circulares para demonstrar polimorfismo
        figuracircular[] figurascirculares = {circulo1, circulo2, elipse1};
        
        // exibindo informacoes de todas as formas
        exibirtodasformas(todasformas);
        
        // demonstrando polimorfismo com figuras circulares
        exibirpropriedadescirculares(figurascirculares);
        
        // calculando totais
        System.out.println("\n=== totais ===");
        System.out.println("area total de todas as formas: " + 
                         String.format("%.2f", calcularareaTotal(todasformas)));
        System.out.println("perimetro total de todas as formas: " + 
                         String.format("%.2f", calcularperimetrototal(todasformas)));
        
        // demonstrando sobrecarga de metodos
        System.out.println("\n=== demonstracao de sobrecarga ===");
        System.out.println("area do triangulo (formula heron): " + 
                         String.format("%.2f", triangulo1.getarea()));
        System.out.println("area do triangulo (base x altura): " + 
                         String.format("%.2f", triangulo1.getarea(3, 4)));
        
        System.out.println("area do circulo (raio): " + 
                         String.format("%.2f", circulo1.getarea()));
        System.out.println("area do circulo (diametro): " + 
                         String.format("%.2f", circulo1.getarea(6, true)));
    }
}