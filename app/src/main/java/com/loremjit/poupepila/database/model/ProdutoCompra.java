package com.loremjit.poupepila.database.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProdutoCompra extends RealmObject {
    @PrimaryKey
    private int id;
    private int lista_id;
    private int estabelecimento_id;
    private int produto_id;
    private double preco;
    private double quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLista_id() {
        return lista_id;
    }

    public void setLista_id(int lista_id) {
        this.lista_id = lista_id;
    }

    public int getEstabelecimento_id() {
        return estabelecimento_id;
    }

    public void setEstabelecimento_id(int estabelecimento_id) {
        this.estabelecimento_id = estabelecimento_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
