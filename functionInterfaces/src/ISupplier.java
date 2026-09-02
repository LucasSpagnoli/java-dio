import java.util.function.Supplier;

public class ISupplier { // não recebe nada mas retorna um valor
    Supplier<String> gerador = () -> "valor gerado na hora";

    public void sout() {
        System.out.println(gerador.get());
    }
}
