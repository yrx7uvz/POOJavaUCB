public class Main {
    public static void main(String[] args) {
        //instâncias
        Cachorro cachorro = new Cachorro("rex", 3, 15.5, "marrom", true, 63, "labrador");
        Gato gato = new Gato("luna", 2, 4.2, "preto", true, 60, true);
        Tartaruga tartaruga = new Tartaruga("donatello", 50, 5.0, "verde", true, true, 30.0);
        Iguana iguana = new Iguana("jefferson", 5, 2.5, "verde escuro", true, false, 40.0);
        Galinha galinha = new Galinha("matilde", 1, 2.0, "branca", false, 15.0, true);
        Calopsita calopsita = new Calopsita("pikachu", 1, 0.08, "amarela", true, 20.0, true);
        Pardal pardal = new Pardal("salomão", 2, 0.03, "marrom", true, 12.0, "copas de árvores");
        Arara arara = new Arara("azul", 15, 1.2, "azul", true, 100.0, "arara-azul-grande");
        
        //informações de cada animal
        System.out.println("===== ANIMAIS =====");
        
        System.out.println("\n--- CACHORRO ---");
        System.out.println(cachorro);
        cachorro.emitirSom();
        cachorro.mover();
        cachorro.amamentar();
        cachorro.abanarRabo();
        
        System.out.println("\n--- GATO ---");
        System.out.println(gato);
        gato.emitirSom();
        gato.mover();
        gato.arranhar();
        
        System.out.println("\n--- TARTARUGA ---");
        System.out.println(tartaruga);
        tartaruga.emitirSom();
        tartaruga.mover();
        tartaruga.regularTemperatura();
        tartaruga.retrairParaCasco();
        
        System.out.println("\n--- IGUANA ---");
        System.out.println(iguana);
        iguana.emitirSom();
        iguana.mover();
        iguana.escalar();
        
        System.out.println("\n--- GALINHA ---");
        System.out.println(galinha);
        galinha.emitirSom();
        galinha.mover();
        galinha.botarOvo();
        galinha.ciscar();
        
        System.out.println("\n--- CALOPSITA ---");
        System.out.println(calopsita);
        calopsita.emitirSom();
        calopsita.mover();
        calopsita.imitar();
        
        System.out.println("\n--- PARDAL ---");
        System.out.println(pardal);
        pardal.emitirSom();
        pardal.mover();
        pardal.construirNinho();
        
        System.out.println("\n--- ARARA ---");
        System.out.println(arara);
        arara.emitirSom();
        arara.mover();
        arara.bicar();
    }
}