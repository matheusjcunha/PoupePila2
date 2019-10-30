package com.loremjit.poupepila.database.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ProdutoPremium extends RealmObject {
    @PrimaryKey
    private int id;
    private int lista_id;
    private int estabelecimento_id;
    private int produto_id;
    private double preco;
    private int quantidade;
}
