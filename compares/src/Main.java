import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Objeto1> objetos = new ArrayList<Objeto1>();

        Comparator<Objeto1> porNome = new Comparator<Objeto1>() {
            @Override
            public int compare(Objeto1 o1, Objeto1 o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        };

        objetos.sort(porNome); // mesmo que: objetos.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));

// ou, ainda mais idiomático, usando Comparator.comparing:
        objetos.sort(Comparator.comparing(Objeto1::getNome)); // Esse Objeto1::getNome é uma method reference — equivalente a escrever p -> p.getNome()

// ordem decrescente:
        objetos.sort(Comparator.comparing(Objeto1::getAltura).reversed());

// múltiplos critérios (ordena por preço, empate desempata por nome):
        objetos.sort(Comparator.comparing(Objeto1::getAltura).thenComparing(Objeto1::getNome));
    }
}
