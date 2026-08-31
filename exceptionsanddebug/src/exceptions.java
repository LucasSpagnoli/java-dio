import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class exceptions {
    public static void main(String[] args) {
        test(); // a chamada da função também tem responsabilidade de tratar a exceção
        mathError();
        System.out.println("Não chegará nesta mensagem se não tiver tratamento de exception");
    }

    private static void test() throws FileNotFoundException { // fala que o metodo abaixo pode jogar essa exceção/erro
        var stream = new FileOutputStream(""); // tem uma exception verificada que precisa ser tratada
    }


    // RuntimeException é uma exceção não verificada (erro que acontece durante execução que devemos prever)
    // outras exceptions que são verificadas, já acompanham erros específicos

    private static void mathError() {
        System.out.println((10 / 0)); // vai dar runtime exception
    }
}

