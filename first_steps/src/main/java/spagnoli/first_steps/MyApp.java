package spagnoli.first_steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class MyApp implements CommandLineRunner {

    @Autowired
    private Calculadora calculadora;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("resultado: " + calculadora.somar(6, 7));

    }
}
