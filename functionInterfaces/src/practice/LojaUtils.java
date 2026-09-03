package practice;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LojaUtils {
    public static Predicate<Produto> disponivel = p -> p.getEstoque() > 0;
    public static Function<Produto, Double> precoComImposto = p -> p.getPreco() * 1.1;
    public static Consumer<Produto> imprimirProduto = p -> System.out.println("Preço: R$" + p.getPreco() + " | Estoque: " + p.getEstoque());
    public static BinaryOperator<Produto> maisCaro = (p1, p2) -> p1.getPreco() > p2.getPreco() ? p1 : p2;
    public static Supplier<Produto> produtoPadrao = () -> new Produto("Produto Indisponível", 0, 0);

    public Optional<Produto> buscarPorNome(List<Produto> produtos, String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equals(nome))
                .findFirst();
    }
}
