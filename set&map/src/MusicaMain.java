import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MusicaMain {
    private static List<Musica> musicas = new ArrayList<>();

    public static void main(String[] args) {
        musicas.add(new Musica("Numb", "Linkin Park", 185));
        musicas.add(new Musica("Numb", "Linkin Park", 190));
        musicas.add(new Musica("Lost", "Linkin Park", 197));
        musicas.add(new Musica("Lost in the Echo", "Linkin Park", 205));
        musicas.add(new Musica("King for a Day", "Pierce the Veil", 216));
        musicas.add(new Musica("King for a Day", "Pierce the Veil", 220));
        musicas.add(new Musica("Caraphernelia", "Pierce the Veil", 241));
        musicas.add(new Musica("Circles", "Pierce the Veil", 208));

        Set<Musica> musicaSet = new HashSet<>(musicas);
//        System.out.println("Set de músicas: \n" + musicaSet);

        Map<String, List<Musica>> musicasMap = new HashMap<>();
        for (Musica m : musicaSet) {
            musicasMap
                    .computeIfAbsent(m.getArtista(), ms -> new ArrayList<>())
                    .add(m);
        }
        for (Map.Entry<String, List<Musica>> entrada : musicasMap.entrySet()) {
            String artista = entrada.getKey();
            List<Musica> musicasDoArtista = entrada.getValue();

            System.out.println("Artista: " + artista + " | Músicas: \n" + musicasDoArtista);
        }
    }
}
