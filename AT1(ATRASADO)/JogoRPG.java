import java.util.Scanner;
import java.util.Random;

public class JogoRPG {
    private static Scanner entrada = new Scanner(System.in);
    private static Random aleatorio = new Random();
    
    public static void main(String[] args) {
        // bem-vindo ao nosso pequeno mundo de aventuras
        System.out.println("=== BEM-VINDO AO RPG DE TERMINAL ===\n");
        
        // vamos criar nosso herói
        Jogador heroi = criarJogador();
        
        // agora a aventura começa de verdade
        iniciarAventura(heroi);
    }
    
    // aqui criamos nosso personagem principal
    private static Jogador criarJogador() {
        System.out.print("Digite o nome do seu herói: ");
        String nome = entrada.nextLine();
        
        Jogador jogador = new Jogador(nome);
        
        System.out.println("\n" + nome + " foi criado com sucesso!");
        jogador.mostrarStatus();
        
        return jogador;
    }
    
    // o coração da nossa aventura
    private static void iniciarAventura(Jogador heroi) {
        System.out.println("\n=== SUA JORNADA COMEÇA AGORA ===");
        System.out.println("Você se encontra em uma floresta misteriosa...");
        
        // loop principal do jogo - enquanto o herói estiver vivo
        while (heroi.estaVivo()) {
            System.out.println("\n--- NOVA SITUAÇÃO ---");
            
            // vamos ver que tipo de encontro teremos
            int tipoEncontro = aleatorio.nextInt(3);
            
            if (tipoEncontro == 0) {
                // oh não, um inimigo apareceu!
                enfrentarInimigo(heroi);
            } else if (tipoEncontro == 1) {
                // que sorte, encontramos algo bom
                encontrarTesouro(heroi);
            } else {
                // momento de descanso e reflexão
                descansar(heroi);
            }
            
            // pergunta se quer continuar a jornada
            if (!heroi.estaVivo()) {
                System.out.println("\nGAME OVER! Sua aventura chegou ao fim...");
                break;
            }
            
            System.out.print("\nDeseja continuar sua jornada? (s/n): ");
            String continuar = entrada.nextLine().toLowerCase();
            
            if (continuar.equals("n") || continuar.equals("não")) {
                System.out.println("Você decide voltar para casa. Até a próxima aventura!");
                break;
            }
        }
    }
    
    // hora do combate - prepare-se para a batalha!
    private static void enfrentarInimigo(Jogador heroi) {
        Inimigo monstro = new Inimigo();
        
        System.out.println("Um " + monstro.nome + " aparece diante de você!");
        System.out.println("Prepare-se para o combate!\n");
        
        // batalha continua até alguém cair
        while (heroi.estaVivo() && monstro.estaVivo()) {
            // turno do jogador
            System.out.println("=== SEU TURNO ===");
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.print("Escolha sua ação: ");
            
            try {
                int acao = Integer.parseInt(entrada.nextLine());
                
                if (acao == 1) {
                    // vamos atacar com tudo!
                    int dano = heroi.atacar();
                    monstro.receberDano(dano);
                    System.out.println("Você causou " + dano + " de dano no " + monstro.nome + "!");
                } else if (acao == 2) {
                    // melhor se proteger um pouco
                    heroi.defender();
                    System.out.println("Você se prepara para defender!");
                } else {
                    System.out.println("Ação inválida! Você perdeu sua vez.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números!");
                continue;
            }
            
            // se o monstro ainda estiver vivo, é a vez dele
            if (monstro.estaVivo()) {
                System.out.println("\n=== TURNO DO " + monstro.nome.toUpperCase() + " ===");
                int danoInimigo = monstro.atacar();
                heroi.receberDano(danoInimigo);
                System.out.println("O " + monstro.nome + " te causou " + danoInimigo + " de dano!");
            }
            
            // vamos ver como estão as coisas
            System.out.println("\n--- STATUS ATUAL ---");
            heroi.mostrarStatus();
            monstro.mostrarStatus();
        }
        
        // quem ganhou a batalha?
        if (!monstro.estaVivo()) {
            System.out.println("\nVitória! Você derrotou o " + monstro.nome + "!");
            heroi.ganharExperiencia(20);
        }
    }
    
    // que sorte, encontramos algo valioso!
    private static void encontrarTesouro(Jogador heroi) {
        int tipoTesouro = aleatorio.nextInt(2);
        
        if (tipoTesouro == 0) {
            // poção de cura - sempre útil
            int cura = aleatorio.nextInt(30) + 10;
            heroi.curar(cura);
            System.out.println("Você encontrou uma poção de cura!");
            System.out.println("Recuperou " + cura + " pontos de vida!");
        } else {
            // experiência extra - conhecimento é poder
            int exp = aleatorio.nextInt(15) + 5;
            heroi.ganharExperiencia(exp);
            System.out.println("Você encontrou um pergaminho antigo!");
            System.out.println("Ganhou " + exp + " pontos de experiência!");
        }
        
        heroi.mostrarStatus();
    }
    
    // momento de paz para recuperar as forças
    private static void descansar(Jogador heroi) {
        System.out.println("Você encontra um local tranquilo para descansar.");
        System.out.println("O som da natureza acalma sua mente...");
        
        int cura = aleatorio.nextInt(15) + 5;
        heroi.curar(cura);
        
        System.out.println("Você se sente revigorado!");
        System.out.println("Recuperou " + cura + " pontos de vida.");
        
        heroi.mostrarStatus();
    }
}

// nossa classe principal - o herói da história
class Jogador {
    String nome;
    int pontosVida;
    int pontosVidaMaximos;
    int nivel;
    int experiencia;
    int ataque;
    int defesa;
    boolean defendendo;
    
    // criando nosso herói com valores iniciais
    public Jogador(String nome) {
        this.nome = nome;
        this.pontosVidaMaximos = 100;
        this.pontosVida = pontosVidaMaximos;
        this.nivel = 1;
        this.experiencia = 0;
        this.ataque = 15;
        this.defesa = 5;
        this.defendendo = false;
    }
    
    // hora de partir para o ataque!
    public int atacar() {
        Random aleatorio = new Random();
        int danoBase = ataque + aleatorio.nextInt(10);
        this.defendendo = false; // não dá pra atacar e defender ao mesmo tempo
        return danoBase;
    }
    
    // melhor se proteger quando as coisas ficam perigosas
    public void defender() {
        this.defendendo = true;
        System.out.println(nome + " assume postura defensiva!");
    }
    
    // ai, isso doeu! vamos calcular o ferimento
    public void receberDano(int dano) {
        if (defendendo) {
            // a defesa ajuda a reduzir o dano
            dano = Math.max(1, dano - (defesa * 2));
            System.out.println("Sua defesa reduziu o dano!");
        } else {
            // sem defesa, levamos o dano normal menos nossa defesa básica
            dano = Math.max(1, dano - defesa);
        }
        
        pontosVida -= dano;
        defendendo = false; // defesa só vale por um turno
        
        if (pontosVida < 0) {
            pontosVida = 0;
        }
    }
    
    // nada como uma boa cura quando precisamos
    public void curar(int quantidade) {
        pontosVida += quantidade;
        if (pontosVida > pontosVidaMaximos) {
            pontosVida = pontosVidaMaximos;
        }
    }
    
    // experiência é tudo - vamos evoluir!
    public void ganharExperiencia(int exp) {
        experiencia += exp;
        System.out.println("+" + exp + " XP!");
        
        // será que chegou a hora de subir de nível?
        int expNecessaria = nivel * 50;
        if (experiencia >= expNecessaria) {
            subirDeNivel();
        }
    }
    
    // que emoção, nosso herói está ficando mais forte!
    private void subirDeNivel() {
        nivel++;
        experiencia = 0; // resetamos a experiência para o próximo nível
        
        // ficamos mais poderosos a cada nível
        int aumentoVida = 20;
        int aumentoAtaque = 3;
        int aumentoDefesa = 2;
        
        pontosVidaMaximos += aumentoVida;
        pontosVida = pontosVidaMaximos; // level up restaura toda a vida
        ataque += aumentoAtaque;
        defesa += aumentoDefesa;
        
        System.out.println("\n*** LEVEL UP! ***");
        System.out.println(nome + " subiu para o nível " + nivel + "!");
        System.out.println("Vida máxima: +" + aumentoVida);
        System.out.println("Ataque: +" + aumentoAtaque);
        System.out.println("Defesa: +" + aumentoDefesa);
        System.out.println("Vida restaurada completamente!");
    }
    
    // será que nosso herói ainda está na luta?
    public boolean estaVivo() {
        return pontosVida > 0;
    }
    
    // vamos ver como estão as coisas
    public void mostrarStatus() {
        System.out.println("\n--- STATUS DE " + nome.toUpperCase() + " ---");
        System.out.println("Nível: " + nivel);
        System.out.println("Vida: " + pontosVida + "/" + pontosVidaMaximos);
        System.out.println("Experiência: " + experiencia + "/" + (nivel * 50));
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
    }
}

// os vilões da nossa história
class Inimigo {
    String nome;
    int pontosVida;
    int ataque;
    
    // tipos diferentes de inimigos para variar a aventura
    private static String[] tiposInimigos = {
        "Goblin", "Orc", "Esqueleto", "Lobo Selvagem", "Bandido"
    };
    
    // criamos um inimigo aleatório
    public Inimigo() {
        Random aleatorio = new Random();
        
        this.nome = tiposInimigos[aleatorio.nextInt(tiposInimigos.length)];
        this.pontosVida = aleatorio.nextInt(40) + 30; // entre 30 e 70 de vida
        this.ataque = aleatorio.nextInt(8) + 8; // entre 8 e 16 de ataque
    }
    
    // inimigos não são muito espertos, só atacam
    public int atacar() {
        Random aleatorio = new Random();
        return ataque + aleatorio.nextInt(5);
    }
    
    // o inimigo também pode se machucar
    public void receberDano(int dano) {
        pontosVida -= dano;
        if (pontosVida < 0) {
            pontosVida = 0;
        }
    }
    
    // ainda está causando problemas?
    public boolean estaVivo() {
        return pontosVida > 0;
    }
    
    // vamos ver como está o inimigo
    public void mostrarStatus() {
        System.out.println(nome + " - Vida: " + pontosVida + " | Ataque: " + ataque);
    }
}