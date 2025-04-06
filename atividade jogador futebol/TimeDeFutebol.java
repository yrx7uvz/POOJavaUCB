import java.util.ArrayList;

/** Classe do time de futebol*/

public class TimeDeFutebol {
    private String nome;
    private String cidade;
    private int anoFundacao;
    private String estadio;
    private ArrayList<Jogador> jogadores;
    private ArrayList<Premiacao> premiacoes;

    // Construtor
    public TimeDeFutebol(String nome, String cidade, int anoFundacao, String estadio) {
        this.nome = nome;
        this.cidade = cidade;
        this.anoFundacao = anoFundacao;
        this.estadio = estadio;
        this.jogadores = new ArrayList<>();
        this.premiacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    // Métodos para adicionar e remover jogadores
    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public boolean removerJogador(String nomeJogador) {
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getNome().equals(nomeJogador)) {
                jogadores.remove(i);
                return true;
            }
        }
        return false;
    }

    // Métodos para adicionar e remover premiações
    public void adicionarPremiacao(Premiacao premiacao) {
        premiacoes.add(premiacao);
    }

    public boolean removerPremiacao(String nomePremiacao, int ano) {
        for (int i = 0; i < premiacoes.size(); i++) {
            Premiacao premiacao = premiacoes.get(i);
            if (premiacao.getNome().equals(nomePremiacao) && premiacao.getAno() == ano) {
                premiacoes.remove(i);
                return true;
            }
        }
        return false;
    }

    // Obter lista de jogadores
    public ArrayList<Jogador> getJogadores() {
        return new ArrayList<>(jogadores);
    }

    // Obter lista de premiações
    public ArrayList<Premiacao> getPremiacoes() {
        return new ArrayList<>(premiacoes);
    }

    // Método para contar o número de títulos de um determinado tipo
    public int contarTitulosPorTipo(String tipo) {
        int contador = 0;
        for (Premiacao premiacao : premiacoes) {
            if (premiacao.getTipo().equals(tipo)) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public String toString() {
        return "TimeDeFutebol{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", anoFundacao=" + anoFundacao +
                ", estadio='" + estadio + '\'' +
                ", jogadores=" + jogadores.size() +
                ", premiacoes=" + premiacoes.size() +
                '}';
    }
}