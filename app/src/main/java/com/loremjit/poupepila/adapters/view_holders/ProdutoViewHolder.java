package com.loremjit.poupepila.adapters.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;

public class ProdutoViewHolder extends RecyclerView.ViewHolder {
    public ImageView tvFoto;
    public TextView tvTitulo;


    public ProdutoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitulo = itemView.findViewById(R.id.tvTituloItProduto);

    }
}
