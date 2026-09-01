import java.util.Objects;

public class Musica {
    private String titulo;
    private String artista;
    private int duracaoSeg;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Musica musica = (Musica) o;
        return Objects.equals(titulo, musica.titulo) && Objects.equals(artista, musica.artista);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracaoSeg() {
        return duracaoSeg;
    }

    public void setDuracaoSeg(int duracaoSeg) {
        this.duracaoSeg = duracaoSeg;
    }

    public Musica(String titulo, String artista, int duracaoSeg) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSeg = duracaoSeg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, artista);
    }

    @Override
    public String toString() {
        return String.format(
                "Música: %s | Artista: %s | Duração: %ds ",
                titulo, artista, duracaoSeg
        );
    }
}
