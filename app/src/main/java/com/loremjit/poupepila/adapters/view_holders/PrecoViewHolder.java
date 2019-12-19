package com.loremjit.poupepila.adapters.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;

public class PrecoViewHolder extends RecyclerView.ViewHolder {
    public TextView tvMercado;
    public TextView tvUltAtu;
    public TextView tvPreco;

    public PrecoViewHolder(@NonNull View itemView) {
        super(itemView);

        tvMercado = itemView.findViewById(R.id.tvEstabPreco);
        tvUltAtu = itemView.findViewById(R.id.tvDataAtuPreco);
        tvPreco = itemView.findViewById(R.id.tvValorItPreco);
    }
}
