public class Jogador implements Comparable<Jogador> {
    private String nome;
    private int pontos;
    private int nivel;

    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos % 10;
        this.nivel = pontos / 10;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public int compareTo(Jogador other) {
        return Integer.compare(other.pontos, this.pontos);
    }
}
