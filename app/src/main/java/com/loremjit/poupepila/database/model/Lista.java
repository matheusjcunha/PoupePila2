package com.loremjit.poupepila.database.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Lista extends RealmObject {
    @PrimaryKey
    private int id;
    private int cliente_id;
    private String tipo;
    private RealmList<RealmObject> lista_produto;

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

    public RealmList<RealmObject> getLista_produto() {
        return lista_produto;
    }

    public void setLista_produto(RealmList<RealmObject> lista_produto) {
        this.lista_produto = lista_produto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
