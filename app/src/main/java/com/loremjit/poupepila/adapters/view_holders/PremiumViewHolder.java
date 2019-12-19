package com.loremjit.poupepila.adapters.view_holders;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.activities.Listas.ListaPremiumActivity;

public class PremiumViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitulo;
    private int id;
    private int posicao;

    public PremiumViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitulo = itemView.findViewById(R.id.tvTituloItPremium);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ListaPremiumActivity) view.getContext()).abrirLista(posicao,id);
            }
        });
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
