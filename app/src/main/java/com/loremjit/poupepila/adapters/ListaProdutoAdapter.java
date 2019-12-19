package com.loremjit.poupepila.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.view_holders.ProdutoViewHolder;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Produto;

public class ListaProdutoAdapter extends RecyclerView.Adapter {
    PoupePilaDAO db = PoupePilaDAO.getInstance();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //1: inflar XML
        ConstraintLayout elementoPrincipalXML = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_lista_produto, parent, false
        );
        //2: associar os objetos inflados a um novo view holder
        ProdutoViewHolder gaveta = new ProdutoViewHolder(elementoPrincipalXML);
        //3: retornar o view holder que foi criado no passo 2
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Produto produto = (Produto) db.read(Produto.class).get(position);
        ProdutoViewHolder viewHolder = (ProdutoViewHolder) holder;

        viewHolder.tvTitulo.setText(produto.getNome());

    }

    @Override
    public int getItemCount() {
        return db.read(Produto.class).size();
    }
}
