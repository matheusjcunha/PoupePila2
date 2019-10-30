package com.loremjit.poupepila.adapters.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.activities.Listas.ListaFavoritoActivity;

public class FavoritoViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitulo;
    public ImageView ivRemove;
    private int posicao;
    private int id;

    public FavoritoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitulo = itemView.findViewById(R.id.tvTituloFavorito);
        ivRemove = itemView.findViewById(R.id.ivRemoveFavorito);

        ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListaFavoritoActivity) view.getContext()).removerFavorito(posicao,id);
            }
        });
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
