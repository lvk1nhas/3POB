package com.marechal.primeira;

public class ItemCarrinho {
    private int idProduto;
    private int quantidade;

    public ItemCarrinho(int idProduto, int quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
