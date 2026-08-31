public class Types {
    public void example() {
        int a = 5;
        int b = 5;
        System.out.println(a == b); // true — comparando valores puros

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d); // false! — comparando REFERÊNCIAS de objeto, não valores
        System.out.println(c.equals(d)); // true — assim compara o valor de dentro
    }
}
