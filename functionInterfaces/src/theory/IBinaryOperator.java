package theory;

import java.util.function.BinaryOperator;

public class IBinaryOperator { // recebe dois valores <T> e retorna um valor <T>. Caso queira que tenham tipos diferentes, pode usar BiFunction
    BinaryOperator<Integer> soma = (a, b) -> a + b;

    public void sout() {
        System.out.println(soma.apply(3, 4)); // 7
    }
}
