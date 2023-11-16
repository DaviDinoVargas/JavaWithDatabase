package classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jbdc jbdc = new Jbdc();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Listar todos os produtos");
            System.out.println("4 - Exibir produto por Código Próprio");
            System.out.println("5 - Comprar produto por Código Próprio");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto(jbdc, scanner);
                    break;
                case 2:
                    removerProduto(jbdc, scanner);
                    break;
                case 3:
                    jbdc.listarTodosProdutos();
                    break;
                case 4:
                    exibirProdutoPorCodigoProprio(jbdc, scanner);
                    break;
                case 5:
                    comprarProdutoPorCodigoProprio(jbdc, scanner);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void adicionarProduto(Jbdc jbdc, Scanner scanner) {
        System.out.print("Descrição: ");
        scanner.nextLine();
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Estoque: ");
        int estoque = scanner.nextInt();
        System.out.print("Código Próprio: ");
        int codigoProprio = scanner.nextInt();

        Produto novoProduto = new Produto(descricao, preco, estoque, codigoProprio);
        jbdc.adicionarProduto(novoProduto);
    }

    private static void removerProduto(Jbdc jbdc, Scanner scanner) {
        System.out.print("Código do produto a ser removido: ");
        int codigoRemover = scanner.nextInt();
        jbdc.removerProduto(codigoRemover);
    }

    private static void exibirProdutoPorCodigoProprio(Jbdc jbdc, Scanner scanner) {
        System.out.print("Código Próprio do produto a ser exibido: ");
        int codigoExibir = scanner.nextInt();
        jbdc.exibirProdutoPorCodigoProprio(codigoExibir);
    }

    private static void comprarProdutoPorCodigoProprio(Jbdc jbdc, Scanner scanner) {
        System.out.print("Código Próprio do produto a ser comprado: ");
        int codigoCompra = scanner.nextInt();
        System.out.print("Quantidade a ser comprada: ");
        int quantidadeCompra = scanner.nextInt();
        Compra.comprarProdutoPorCodigoProprio(jbdc, codigoCompra, quantidadeCompra);
    }
}
