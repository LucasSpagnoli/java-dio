import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Colletcions {
    public class CaixaNumerica<T extends Number> {
        private T valor;

        public double dobro() {
            return valor.doubleValue() * 2; // só funciona pq T É GARANTIDAMENTE um Number
        }
    }

    public void collections() {
        List<Integer> numberos = new ArrayList<>(); // compila
//      List<int> numberos;      // não compila
        numberos.add(6);           // como .push()
        numberos.get(0);              // como numberos[0]
        numberos.remove(0);           // remove por índice
        numberos.size();               // como .length
        numberos.contains(7);      // como .includes()

        Set<String> convidados = new HashSet<>();
        convidados.add("João");
        convidados.add("Maria");
        convidados.add("João"); // ignorado silenciosamente, já existe
        System.out.println(convidados.size()); // 2, não 3
    }

    public void maps() {
        Map<String, Integer> idades = new HashMap<>();
        idades.put("João", 25);
        idades.put("Maria", 30);
        idades.put("João", 26); // sobrescreve o valor anterior de João, chave é única

        System.out.println(idades.get("João"));        // 26
        System.out.println(idades.containsKey("Pedro")); // false
        System.out.println(idades.getOrDefault("Pedro", 0)); // 0, sem precisar checar antes

        // percorrendo chave e valor juntos
        for (Map.Entry<String, Integer> par : idades.entrySet()) {
            System.out.println(par.getKey() + " tem " + par.getValue() + " anos");
        }

        // só as chaves
        for (String nome : idades.keySet()) {
            System.out.println(nome);
        }

        List<String> palavras = new ArrayList<>(List.of("abc", "def"));

        Map<String, Integer> contagem = new HashMap<>();
        for (String palavra : palavras) {
            contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
        }
    }
}
