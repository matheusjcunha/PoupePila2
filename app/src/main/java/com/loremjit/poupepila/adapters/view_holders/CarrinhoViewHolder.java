package com.loremjit.poupepila.adapters.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.activities.Listas.CarrinhoCompraActivity;

public class CarrinhoViewHolder extends RecyclerView.ViewHolder {
    public TextView tvProduto;
    public TextView tvPreco;
    public TextView tvQuantidade;
    public ImageView ivAdd;
    public ImageView ivRemove;
    private int posicao;
    private int id;

    public CarrinhoViewHolder(@NonNull View itemView) {
        super(itemView);

        //Resgata as ids
        tvProduto = itemView.findViewById(R.id.tvProdutoEstabProd1);
        tvPreco = itemView.findViewById(R.id.tvProdAdicioProd1);
        tvQuantidade = itemView.findViewById(R.id.tvQtdProd1);
        ivAdd = itemView.findViewById(R.id.ivAddProd1);
        ivRemove = itemView.findViewById(R.id.ivRemoveProd1);

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((CarrinhoCompraActivity) view.getContext()).alterarQuatidade(posicao,id,"+");
            }
        });

        ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((CarrinhoCompraActivity) view.getContext()).alterarQuatidade(posicao,id,"-");
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
