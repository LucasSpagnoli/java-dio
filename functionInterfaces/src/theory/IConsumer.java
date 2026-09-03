package theory;

import java.util.function.Consumer;

public class IConsumer { // recebe um valor e não retorna nada
    Consumer<String> imprimir = s -> System.out.println("Recebi: " + s);

    public void sout() {
        imprimir.accept("oi"); // "Recebi: oi"
    }
}
