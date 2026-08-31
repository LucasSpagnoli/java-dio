public class Jogador implements Comparable<Jogador> {
    private String nome;
    private int pontos;
    private int nivel;

    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.nivel = pontos / 10;
    }

    @Override
    public int compareTo(Jogador other) {
        return Integer.compare(this.pontos, other.pontos);
    }
}
