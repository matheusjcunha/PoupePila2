package com.loremjit.poupepila.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.view_holders.CarrinhoViewHolder;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Produto;
import com.loremjit.poupepila.database.model.ProdutoCarrinho;
import com.loremjit.poupepila.security.Sessao;

public class ListaCarrinhoAdapter extends RecyclerView.Adapter {
    private PoupePilaDAO db = PoupePilaDAO.getInstance();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //1: inflar XML
        ConstraintLayout elementoPrincipalXML = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_lista_produto1, parent, false
        );
        //2: associar os objetos inflados a um novo view holder
        CarrinhoViewHolder gaveta = new CarrinhoViewHolder(elementoPrincipalXML);
        //3: retornar o view holder que foi criado no passo 2
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CarrinhoViewHolder viewHolder = (CarrinhoViewHolder) holder;
        ProdutoCarrinho carrinho = (ProdutoCarrinho) db.getLista(Sessao.getInstance().getIdSession(),"carrinho").get(position);
        Produto produto = db.getProduto(carrinho.getProduto_id());
        viewHolder.setPosicao(position);
        viewHolder.setId(carrinho.getId());
        viewHolder.tvProduto.setText(produto.getNome());
        viewHolder.tvQuantidade.setText(String.valueOf(carrinho.getQuantidade()));
        viewHolder.tvPreco.setText(String.valueOf(carrinho.getPreco()));
    }

    @Override
    public int getItemCount() {
        return db.getLista(Sessao.getInstance().getIdSession(),"carrinho").size();
    }
}
