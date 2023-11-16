package classes;

import java.util.List;

public class Compra {
    public static void comprarProdutoPorCodigoProprio(Jbdc jbdc, int codigoProprio, int quantidade) {
        List<Produto> produtos = jbdc.getListaProdutos();

        for (Produto produto : produtos) {
            if (produto.getCodigoProprio() == codigoProprio) {
                if (produto.getEstoque() >= quantidade) {
                    double precoTotal = produto.getPreco() * quantidade;
                    System.out.println("Compra realizada com sucesso.");
                    System.out.println("Produto: " + produto.getDescricao());
                    System.out.println("Quantidade: " + quantidade);
                    System.out.println("Preço Total: " + precoTotal);

                    produto.setEstoque(produto.getEstoque() - quantidade);

                    
                    jbdc.atualizarEstoqueNoBanco(produto);

                } else {
                    System.out.println("Estoque insuficiente.");
                }
                return;
            }
        }

        System.out.println("Produto não encontrado para o Código Próprio fornecido.");
    }
}