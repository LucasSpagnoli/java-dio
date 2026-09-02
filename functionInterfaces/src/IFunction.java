import java.util.function.Function;

public class IFunction { // recebe um valor e devolve outro
    Function<String, Integer> tamanho = String::length;
//    Function<String, Integer> tamanho = s -> s.length();

    public void sout() {
        System.out.println(tamanho.apply("Java"));
    }

    // é possível combinar Functions também:
    //    Function<Integer, Integer> dobrar = n -> n * 2;
    //    Function<Integer, Integer> somarUm = n -> n + 1;
    //
    //    Function<Integer, Integer> combinada = dobrar.andThen(somarUm);
    //System.out.println(combinada.apply(5)); // (5*2)+1 = 11
    //
    //    Function<Integer, Integer> combinada2 = dobrar.compose(somarUm);
    //System.out.println(combinada2.apply(5)); // (5+1)*2 = 12

}
