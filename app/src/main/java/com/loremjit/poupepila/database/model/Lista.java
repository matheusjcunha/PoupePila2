package com.loremjit.poupepila.database.model;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Lista extends RealmObject {
    @PrimaryKey
    private int id;
    private int cliente_id;
    private RealmList<ProdutoCompra> lista_produtoCompra;
    private RealmList<ProdutoCarrinho> lista_produtoCarrinho;
    private RealmList<ProdutoFavorito> lista_produtoFavorito;
    private RealmList<ListaPremiumCompra> lista_premiumCompra;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
    public RealmList<ProdutoCompra> getLista_produtoCompra() { return lista_produtoCompra; }
    public void setLista_produtoCompra(RealmList<ProdutoCompra> lista_produtoCompra) { this.lista_produtoCompra = lista_produtoCompra; }
    public RealmList<ProdutoCarrinho> getLista_produtoCarrinho() { return lista_produtoCarrinho; }
    public void setLista_produtoCarrinho(RealmList<ProdutoCarrinho> lista_produtoCarrinho) { this.lista_produtoCarrinho = lista_produtoCarrinho; }
    public RealmList<ProdutoFavorito> getLista_produtoFavorito() { return lista_produtoFavorito; }
    public void setLiista_produtoFavorito(RealmList<ProdutoFavorito> lista_produtoFavorito) { this.lista_produtoFavorito = lista_produtoFavorito; }

    public RealmList<ListaPremiumCompra> getLista_premiumCompra() {
        return lista_premiumCompra;
    }

    public void setLista_premiumCompra(RealmList<ListaPremiumCompra> lista_premiumCompra) {
        this.lista_premiumCompra = lista_premiumCompra;
    }
}
