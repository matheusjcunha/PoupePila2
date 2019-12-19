package com.loremjit.poupepila.adapters.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;

public class EstabelecimentoViewHolder extends RecyclerView.ViewHolder {
    public TextView tvNome;
    public TextView tvEndereco;
    private int id;
    private int posicao;

    public EstabelecimentoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvNome = itemView.findViewById(R.id.tvNomeItEstabelecimento);
        tvEndereco = itemView.findViewById(R.id.tvEndItEstabelecimento);
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

    public void setPosition(int posicao) {
        this.posicao = posicao;
    }
}
