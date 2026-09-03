package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static practice.LojaUtils.disponivel;
import static practice.LojaUtils.imprimirProduto;
import static practice.LojaUtils.maisCaro;
import static practice.LojaUtils.precoComImposto;
import static practice.LojaUtils.produtoPadrao;

public class Main {
    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Notebook", 3500.00, 5));
        produtos.add(new Produto("Mouse", 80.00, 0));
        produtos.add(new Produto("Teclado", 150.00, 10));
        produtos.add(new Produto("Monitor", 1200.00, 0));
        produtos.add(new Produto("Headset", 300.00, 3));

        List<Produto> availableProducts = produtos.stream().filter(disponivel).toList();

        availableProducts.forEach(p -> {
            precoComImposto.apply(p);
            imprimirProduto.accept(p);
        });

        maisCaro.apply(availableProducts.get(0), availableProducts.get(1));

        LojaUtils loja = new LojaUtils();
        Produto pFound = loja.buscarPorNome(produtos, "Notebook").orElseGet(produtoPadrao);
        Produto pNotFound = loja.buscarPorNome(produtos, "Maçã").orElseGet(produtoPadrao);

    }
}