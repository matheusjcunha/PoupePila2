package com.loremjit.poupepila.database;
/*
Classe responsável pela persistência de dados
no banco Realm
 */
import com.loremjit.poupepila.database.model.Cliente;
import com.loremjit.poupepila.database.model.Estabelecimento;
import com.loremjit.poupepila.database.model.Lista;
import com.loremjit.poupepila.database.model.ListaPremiumCompra;
import com.loremjit.poupepila.database.model.Produto;
import com.loremjit.poupepila.database.model.ProdutoCarrinho;
import com.loremjit.poupepila.database.model.ProdutoFavorito;
import com.loremjit.poupepila.database.model.Registro;
import java.util.ArrayList;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;

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

    public ArrayList read(Class classe){
        ArrayList objetos = new ArrayList();
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

    public Cliente getCliente(int id){
        return db.where(Cliente.class).equalTo("id",id).findFirst();
    }



     /*--------------------------------------------------------
    --------------------Tabela Estabelecimento-----------------
    * --------------------------------------------------------*/
     public Estabelecimento getEstabelecimento(int id){
         return db.where(Estabelecimento.class).equalTo("id",id).findFirst();
     }

     /*--------------------------------------------------------
    ------------------------Tabela Produto---------------------
    * --------------------------------------------------------*/
     public Produto getProduto(int id){
         return db.where(Produto.class).equalTo("id",id).findFirst();
     }

    public Produto getProdutoEan(int ean){
        return db.where(Produto.class).equalTo("ean",ean).findFirst();
    }

     public ProdutoCarrinho getProdutoCarrinho(int id){
         return db.where(ProdutoCarrinho.class).equalTo("id",id).findFirst();
     }


     /*--------------------------------------------------------
    ------------------------Tabela Lista-----------------------
    * --------------------------------------------------------*/
     public Lista getListaCliente(int codigoCliente){
         return db.where(Lista.class).equalTo("cliente_id",codigoCliente).findFirst();
     }

     //Retorna todos os dados de uma lista de acordo com o tipo
     //carrinho - retorna a lista do carrinho
     //favorito - retorna a lista de favorito
     //compra - retorna a lista de compra do item do premium
     //premium - retorna as listas de compra premium
     public ArrayList<RealmObject> getLista(int codigoCiente,String tipo){
         ArrayList produtos = new ArrayList();

         Lista lista = db.where(Lista.class).equalTo("cliente_id",codigoCiente).findFirst();

         if(lista != null) {
             switch (tipo){
                 case "carrinho":
                     produtos.addAll(lista.getLista_produtoCarrinho());
                     break;
                 case "favorito":
                     produtos.addAll(lista.getLista_produtoFavorito());
                     break;
                 case "compra":
                     produtos.addAll(lista.getLista_produtoCompra());
                     break;
                 case "premium":
                     produtos.addAll(lista.getLista_premiumCompra());
                     break;
             }
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

     public void addListaPremiumCompra(int codigoUsuario,ListaPremiumCompra l){
         if(create(l)) {
             Lista listaCliente = getListaCliente(codigoUsuario);
             db.beginTransaction();
             listaCliente.getLista_premiumCompra().add(l);
             db.insertOrUpdate(l);
             db.commitTransaction();
         }
     }


     /*--------------------------------------------------------
    --------------------Tabela Registros-----------------------
    * --------------------------------------------------------*/
     //Resgata todos os produtos de registro que estejam verificado com o EAN informado
     public ArrayList<Registro> getRegistroProduto(int codigoEan){
         ArrayList<Produto> produtos = new ArrayList();
         ArrayList<Registro> registros = new ArrayList();
         //Resgata todos os produtos com o EAN especificado
         produtos.addAll(db.where(Produto.class).equalTo("ean",codigoEan).findAll().sort("preco_digitado", Sort.DESCENDING));
         //Percorre os produtos
         for (Produto p: produtos) {
             //Verifica se o produto está verificado
             Registro registro = db.where(Registro.class).equalTo("produto_id",p.getId()).
                     and().equalTo("preco_verificado",true).findFirst();

             //Se estiver OK, adiciona na array de retorno
             if(registro != null){
                registros.add(registro);
             }
         }
         return registros;
     }

    //Resgata todos os produtos de registro que estejam verificado com o nome informado do produto
    public ArrayList<Registro> getRegistroProduto(String nomeProduto){
        ArrayList<Produto> produtos = new ArrayList();
        ArrayList<Registro> registros = new ArrayList();
        //Resgata todos os produtos com o EAN especificado
        produtos.addAll(db.where(Produto.class).contains("nome",nomeProduto).findAll().sort("preco_digitado", Sort.DESCENDING));
        //Percorre os produtos
        for (Produto p: produtos) {
            //Verifica se o produto está verificado
            Registro registro = db.where(Registro.class).equalTo("produto_id",p.getId()).
                    and().equalTo("preco_verificado",true).findFirst();

            //Se estiver OK, adiciona na array de retorno
            if(registro != null){
                registros.add(registro);
            }
        }
        return registros;
    }


}
