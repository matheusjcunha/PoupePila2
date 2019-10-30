package com.loremjit.poupepila.database.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RegistroPendente extends RealmObject {
    @PrimaryKey
    private int id;
    private boolean validado;
    private int registro_i;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public int getRegistro_i() {
        return registro_i;
    }

    public void setRegistro_i(int registro_i) {
        this.registro_i = registro_i;
    }
}
