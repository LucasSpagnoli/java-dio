import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JogadorMain {
    private static void printJogadores(List<Jogador> jogadores) {
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador j = jogadores.get(i);
            System.out.println("Jogador " + (i + 1) + ": " + j.getNome() + " | Pts: " + j.getPontos() + " | Nvl: " + j.getNivel());
        }
    }

    public static void main(String[] args) {
        List<Jogador> jogadores = new ArrayList<Jogador>();
        jogadores.add(new Jogador("Lucas", 29));
        jogadores.add(new Jogador("Tiago", 22));
        jogadores.add(new Jogador("Murilo", 37));

        Collections.sort(jogadores); // ordena jogadores de acordo com o compareTo definido dentro da classe Jogador
        System.out.println("Ordenado por pontos:");
        printJogadores(jogadores);
        jogadores.sort(Comparator.comparing(Jogador::getNivel));
        System.out.println("Ordem por nível:");
        printJogadores(jogadores);
        jogadores.sort(Comparator.comparing(Jogador::getNome));
        System.out.println("Ordem por nome:");
        printJogadores(jogadores);
        jogadores.sort(Comparator.comparing(Jogador::getNivel).thenComparing(Jogador::getPontos).reversed());
        System.out.println("Ordem por nível desempatando nos pontos:");
        printJogadores(jogadores);

    }
}
