import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Estoque<T> {
    private Map<T, Integer> estoque = new HashMap<>();

    public void adicionar(T item, int quantidade) {
        if (estoque.containsKey(item)) {
            estoque.put(item, estoque.get(item) + quantidade);
        } else {
            estoque.put(item, quantidade);
        }
    }

    public void remover(T item, int quantidade) {
        if (estoque.get(item) == null) {
            return;
        }
        int newQ = estoque.get(item) - quantidade;
        if (newQ <= 0) {
            estoque.remove(item);
        } else {
            estoque.put(item, newQ);
        }
    }

    public int consultar(T item) {
        if (estoque.get(item) != null) {
            return estoque.get(item);
        } else {
            return 0;
        }
    }

    public Set<T> itensUnicos() {
        return estoque.keySet();
    }

    public int totalDeItens() {
        int sum = 0;
        for (int valor : estoque.values()) {
            sum += valor;
        }
        return sum;
    }
}
