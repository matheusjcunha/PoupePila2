package com.loremjit.poupepila.database.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Produto extends RealmObject {
    @PrimaryKey
    private int id;
    private int ean;
    private String nome;
    private String departamento;
    @Ignore
    private double preco;
    @Ignore
    private int quantidade;
    @Ignore
    private int estabelecimento_id;
    @Ignore
    private int cliente_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getEstabelecimento_id() {
        return estabelecimento_id;
    }

    public void setEstabelecimento_id(int estabelecimento_id) {
        this.estabelecimento_id = estabelecimento_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
}
