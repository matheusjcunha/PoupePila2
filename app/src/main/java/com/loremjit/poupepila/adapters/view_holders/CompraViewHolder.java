package com.loremjit.poupepila.adapters.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;

public class CompraViewHolder extends RecyclerView.ViewHolder {
    public TextView tvMercado;
    public TextView tvProduto;
    public TextView tvPreco;
    public ImageView ivAdd;
    public ImageView ivRemove;
    private int posicao;
    private int id;

    public CompraViewHolder(@NonNull View itemView) {
        super(itemView);

        tvMercado = itemView.findViewById(R.id.tvProdutoEstabProd1);
        tvProduto = itemView.findViewById(R.id.tvProdAdicioProd1);
        tvPreco = itemView.findViewById(R.id.tvPrecoProd1);
        ivAdd = itemView.findViewById(R.id.ivAddProd1);
        ivRemove = itemView.findViewById(R.id.ivRemoveProd1);

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
