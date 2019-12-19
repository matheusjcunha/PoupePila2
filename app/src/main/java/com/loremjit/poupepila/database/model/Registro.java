package com.loremjit.poupepila.database.model;

import java.util.Date;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Registro extends RealmObject {
    @PrimaryKey
    private int id;
    private Date data_hora;
    private int cliente_id;
    private int estabelecimento_id;
    private String novo_estabelecimento;
    private int produto_id;
    private double preco_digitado;
    private int base_id;
    private boolean preco_verificado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getEstabelecimento_id() {
        return estabelecimento_id;
    }

    public void setEstabelecimento_id(int estabelecimento_id) {
        this.estabelecimento_id = estabelecimento_id;
    }

    public String getNovo_estabelecimento() {
        return novo_estabelecimento;
    }

    public void setNovo_estabelecimento(String novo_estabelecimento) {
        this.novo_estabelecimento = novo_estabelecimento;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public double getPreco_digitado() {
        return preco_digitado;
    }

    public void setPreco_digitado(double preco_digitado) {
        this.preco_digitado = preco_digitado;
    }

    public int getBase_id() {
        return base_id;
    }

    public void setBase_id(int base_id) {
        this.base_id = base_id;
    }

    public boolean isPreco_verificado() {
        return preco_verificado;
    }

    public void setPreco_verificado(boolean preco_verificado) {
        this.preco_verificado = preco_verificado;
    }
}
