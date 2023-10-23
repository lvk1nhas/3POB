package com.marechal.primeira;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(int idProduto, int quantidade) {
        itens.add(new ItemCarrinho(idProduto, quantidade));
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public double calcularValorTotal(List<Produto> produtos) {
        double valorTotal = 0.0;

        for (ItemCarrinho item : itens) {
            int idProduto = item.getIdProduto();
            int quantidade = item.getQuantidade();

            for (Produto produto : produtos) {
                if (produto.getId() == idProduto) {
                    valorTotal += produto.getPreco() * quantidade;
                    break;
                }
            }
        }

        return valorTotal;
    }
}
