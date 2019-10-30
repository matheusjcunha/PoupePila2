package com.loremjit.poupepila.database.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Base extends RealmObject {
    @PrimaryKey
    private int id;
    private double preco_oficial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco_oficial() {
        return preco_oficial;
    }

    public void setPreco_oficial(double preco_oficial) {
        this.preco_oficial = preco_oficial;
    }
}
