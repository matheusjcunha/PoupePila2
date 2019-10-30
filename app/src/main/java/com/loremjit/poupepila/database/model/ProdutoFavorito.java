package com.loremjit.poupepila.database.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProdutoFavorito extends RealmObject {
    @PrimaryKey
    private int id;
    private int lista_id;
    private int produto_id;

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

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }
}
