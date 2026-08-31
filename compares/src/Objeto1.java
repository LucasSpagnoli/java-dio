public class Objeto1 implements Comparable<Objeto1> {

    private String nome;
    private int altura;

    public String getNome() {
        return nome;
    }

    public int getAltura() {
        return altura;
    }

    public Objeto1(String nome, int altura) {
        this.nome = nome;
        this.altura = altura;
    }

    @Override
    public int compareTo(Objeto1 outro) {
        return Integer.compare(this.altura, outro.altura); // retorna negativo se this for menor que outro,
    }
}
