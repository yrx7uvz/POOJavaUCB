/**Classe principal que demonstra o funcionamento do sistema*/

public class SistemaTimesDeFutebol {
    public static void main(String[] args) {
        // Criando um time
        TimeDeFutebol flamengo = new TimeDeFutebol("Flamengo", "Rio de Janeiro", 1895, "Maracanã");
        
        // Adicionando jogadores ao time
        flamengo.adicionarJogador(new Jogador("Gabigol", 27, "Atacante", 10));
        flamengo.adicionarJogador(new Jogador("Bruno Henrique", 29, "Atacante", 27));
        flamengo.adicionarJogador(new Jogador("Arrascaeta", 30, "Meia", 14));
        
        // Adicionando premiações ao time
        flamengo.adicionarPremiacao(new Premiacao("Campeonato Brasileiro", 2019, "Nacional"));
        flamengo.adicionarPremiacao(new Premiacao("Copa Libertadores", 2019, "Internacional"));
        flamengo.adicionarPremiacao(new Premiacao("Campeonato Brasileiro", 2020, "Nacional"));
        
        // Exibindo informações do time
        System.out.println(flamengo);
        
        // Exibindo todos os jogadores
        System.out.println("\nJogadores:");
        for (Jogador jogador : flamengo.getJogadores()) {
            System.out.println(jogador);
        }
        
        // Exibindo todas as premiações
        System.out.println("\nPremiações:");
        for (Premiacao premiacao : flamengo.getPremiacoes()) {
            System.out.println(premiacao);
        }
        
        // Contando títulos nacionais
        System.out.println("\nTítulos Nacionais: " + flamengo.contarTitulosPorTipo("Nacional"));
        
        // Contando títulos internacionais
        System.out.println("Títulos Internacionais: " + flamengo.contarTitulosPorTipo("Internacional"));
        
        // Removendo um jogador
        System.out.println("\nRemovendo jogador 'Gabigol': " + flamengo.removerJogador("Gabigol"));
        
        // Exibindo jogadores após a remoção
        System.out.println("\nJogadores após remoção:");
        for (Jogador jogador : flamengo.getJogadores()) {
            System.out.println(jogador);
        }
    }
}