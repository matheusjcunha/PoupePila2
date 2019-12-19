package com.loremjit.poupepila.database.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ListaPremiumCompra extends RealmObject {
    @PrimaryKey
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
