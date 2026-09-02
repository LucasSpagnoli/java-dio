import java.util.function.Predicate;

public class IPredicate { // recebe um valor e retorna boolean

    Predicate<Integer> ehPar = n -> n % 2 == 0;
    Predicate<Integer> ehPositivo = n -> n > 0;
    Predicate<Integer> ehParEPositivo = ehPar.and(ehPositivo);
    Predicate<Integer> ehParOuPositivo = ehPar.or(ehPositivo);
    Predicate<Integer> ehImpar = ehPar.negate();

    public void sout() {
        System.out.println(ehPar.test(4)); // true
    }
}
