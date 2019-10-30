package com.loremjit.poupepila.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.view_holders.FavoritoViewHolder;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Produto;
import com.loremjit.poupepila.database.model.ProdutoFavorito;
import com.loremjit.poupepila.security.Sessao;

public class ListaFavoritoAdapter extends RecyclerView.Adapter {
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //1: inflar XML
        ConstraintLayout elementoPrincipalXML = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_lista_favorito, parent, false
        );
        //2: associar os objetos inflados a um novo view holder
        FavoritoViewHolder gaveta = new FavoritoViewHolder(elementoPrincipalXML);
        //3: retornar o view holder que foi criado no passo 2
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FavoritoViewHolder viewHolder = (FavoritoViewHolder) holder;
        ProdutoFavorito favorito = (ProdutoFavorito) db.getLista(Sessao.getInstance().getIdSession(),"favorito").get(position);
        Produto produto = db.getProduto(favorito.getProduto_id());

        viewHolder.tvTitulo.setText(produto.getNome());
        viewHolder.setId(favorito.getId());
        viewHolder.setPosicao(position);
    }

    @Override
    public int getItemCount() {
        return db.getLista(Sessao.getInstance().getIdSession(),"favorito").size();
    }
}
