import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    private Map<String, Integer> hash = new HashMap<>();
    private Map<String, Integer> linked = new LinkedHashMap<>();
    private Map<String, Integer> tree = new TreeMap<>();


    private void mapUses() {
        for (String chave : hash.keySet()) {
        }           // só chaves
        for (Integer valor : hash.values()) {
        }            // só valores
        for (Map.Entry<String, Integer> par : hash.entrySet()) { // par completo, mais eficiente
            par.getKey();
            par.getValue();
        }
    }
}
