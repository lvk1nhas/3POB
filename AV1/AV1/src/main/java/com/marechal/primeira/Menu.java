package com.marechal.primeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Produto> produtos = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();
    private int opcao = 0;

    public void Processamento() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Escolha sua opção:");
            System.out.println("1- Incluir Produto");
            System.out.println("2- Adicionar Produto ao Carrinho");
            System.out.println("3- Listar Produtos");
            System.out.println("4- Listar Carrinho");
            System.out.println("5- Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    IncluirProduto();
                    break;
                case 2:
                    AdicionarProdutoAoCarrinho();
                    break;
                case 3:
                    ListarProdutos();
                    break;
                case 4:
                    ListarCarrinho();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 5);
    }

    public void IncluirProduto() {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Digite o ID do produto: ");
        int id = sc.nextInt();
    
        // Verifique se o ID já existe
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                System.out.println("ID já existe. Tente novamente.");
                return;
            }
        }
    
        System.out.println("Digite o nome do produto: ");
        String nome = sc.next();
    
        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();
    
        Produto produto = new Produto(id, nome, preco);
        produtos.add(produto);
    }

   public void AdicionarProdutoAoCarrinho() {
    Scanner sc = new Scanner(System.in);

    do {
        System.out.println("Digite o ID do produto que deseja adicionar ao carrinho: ");
        int idProduto = sc.nextInt();

        System.out.println("Digite a quantidade desejada: ");
        int quantidade = sc.nextInt();

        carrinho.adicionarItem(idProduto, quantidade);

        System.out.println("Deseja adicionar outro produto ao carrinho? (1 - Sim, 2 - Não)");
        int opcao = sc.nextInt();

        if (opcao != 1) {
            break; // Sair do loop se o usuário não quiser adicionar mais produtos
        }
    } while (true);
}


    public void ListarProdutos() {
        System.out.println("Lista de Produtos:");
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println();
        }
    }

    public void ListarCarrinho() {
        List<ItemCarrinho> itens = carrinho.getItens();

        for (ItemCarrinho item : itens) {
            int idProduto = item.getIdProduto();
            int quantidade = item.getQuantidade();

            for (Produto produto : produtos) {
                if (produto.getId() == idProduto) {
                    System.out.println("Produto: " + produto.getNome());
                    System.out.println("Quantidade: " + quantidade);
                }
            }
        }

        double valorTotal = carrinho.calcularValorTotal(produtos);
        System.out.println("Valor Total do Carrinho: R$" + valorTotal);
    }
}
