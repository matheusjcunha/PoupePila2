package com.loremjit.poupepila.database;
/*
Classe responsável pela persistência de dados
no banco Realm
 */
import com.loremjit.poupepila.database.model.Cliente;
import com.loremjit.poupepila.database.model.Lista;
import com.loremjit.poupepila.database.model.Produto;
import com.loremjit.poupepila.database.model.ProdutoCarrinho;
import com.loremjit.poupepila.database.model.ProdutoFavorito;

import java.util.ArrayList;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class PoupePilaDAO {
    private Realm db;
    private static PoupePilaDAO Instance;

    private PoupePilaDAO(){
        db = Realm.getDefaultInstance();
    }

    public static synchronized PoupePilaDAO getInstance() {
        if (Instance == null)
            Instance = new PoupePilaDAO();

        return Instance;
    }

    //CRUD genérico
    public boolean create(RealmObject objeto){
        db.beginTransaction();
        db.insert(objeto);
        db.commitTransaction();
        return existsObjectInRealm(objeto);
    }

    public ArrayList<Object> read(Class classe){
        ArrayList<Object> objetos = new ArrayList();
        RealmResults results = db.where(classe).findAll();
        objetos.addAll(results);
        return objetos;
    }

    public boolean update(RealmObject objeto){
        db.beginTransaction();
        db.insertOrUpdate(objeto);
        db.commitTransaction();
        return existsObjectInRealm(objeto);
    }

    public void delete(int id,Class classe, String fieldPrimaryKey){
        db.beginTransaction();
        db.where(classe).equalTo(fieldPrimaryKey,id).findAll().deleteAllFromRealm();
        db.commitTransaction();
    }

    public boolean existsObjectInRealm(RealmObject objeto){
        boolean sucess = false;
        if(db.where(objeto.getClass()).findFirst() != null){
            sucess = true;
        }
        return sucess;
    }

    public int nextIdObjectRealm(Class classe){
        int next = 1;
        if(db.where(classe).findFirst() != null ){
            next = db.where(classe).max("id").intValue()+1;
        }
        return next;
    }

    /*--------------------------------------------------------
    ----------------------Tabela Cliente----------------------
    * --------------------------------------------------------*/
    public Cliente getCliente(String email,String senha){
        return db.where(Cliente.class).equalTo("email",email).
                and().equalTo("senha",senha).findFirst();
    }




     /*--------------------------------------------------------
    --------------------Tabela Estabelecimento-----------------
    * --------------------------------------------------------*/


     /*--------------------------------------------------------
    ------------------------Tabela Produto---------------------
    * --------------------------------------------------------*/
     public Produto getProduto(int id){
         return db.where(Produto.class).equalTo("id",id).findFirst();
     }

     public ProdutoCarrinho getProdutoCarrinho(int id){
         return db.where(ProdutoCarrinho.class).equalTo("id",id).findFirst();
     }


     /*--------------------------------------------------------
    ------------------------Tabela Lista-----------------------
    * --------------------------------------------------------*/
     public ArrayList<RealmObject> getLista(int codigoCiente,String tipo){
         ArrayList produtos = new ArrayList();

         Lista lista = db.where(Lista.class).equalTo("cliente_id",codigoCiente).
                 and().equalTo("tipo",tipo).findFirst();

         if(lista != null) {
             produtos.addAll(lista.getLista_produto());
         }

        return produtos;
     }

     public ArrayList<Lista> getListasPremium(int codigoCliente){
         ArrayList<Lista> listas = new ArrayList();
         RealmResults results = db.where(Lista.class).equalTo("cliente_id",codigoCliente).findAll();
         if(results != null) {
             listas.addAll(results);
         }

         return listas;
     }

     public double getTotalCarrinho(int codigoCliente){
         double total = 0;
         ArrayList<RealmObject> lista = getLista(codigoCliente,"carrinho");

         //Verifica se existe produtos na lista
         if(!lista.isEmpty()){
             //Percorre efetuando cast para ProdutoCarrinho
             for (RealmObject l: lista) {
                 ProdutoCarrinho produto = (ProdutoCarrinho) l;
                 total += produto.getPreco()*produto.getQuantidade();
             }
         }

         return total;
     }

     public void deletarFavorito(int codigoCliente,int id){
         db.beginTransaction();
         db.where(ProdutoFavorito.class).equalTo("id",id).findAll().deleteFirstFromRealm();
         db.commitTransaction();
     }

}
