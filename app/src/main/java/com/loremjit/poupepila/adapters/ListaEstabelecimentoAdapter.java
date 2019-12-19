package com.loremjit.poupepila.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.view_holders.EstabelecimentoViewHolder;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Estabelecimento;

public class ListaEstabelecimentoAdapter extends RecyclerView.Adapter {
    PoupePilaDAO db = PoupePilaDAO.getInstance();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //1: inflar XML
        ConstraintLayout elementoPrincipalXML = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_lista_estabelecimento, parent, false
        );
        //2: associar os objetos inflados a um novo view holder
        EstabelecimentoViewHolder gaveta = new EstabelecimentoViewHolder(elementoPrincipalXML);
        //3: retornar o view holder que foi criado no passo 2
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EstabelecimentoViewHolder viewHolder = (EstabelecimentoViewHolder) holder;
        Estabelecimento estabelecimento = (Estabelecimento) db.read(Estabelecimento.class).get(position);
        viewHolder.tvNome.setText(estabelecimento.getNome());
        viewHolder.tvEndereco.setText("Cidade: " + estabelecimento.getCidade() + " / Bairro: " + estabelecimento.getBairro());
        viewHolder.setId(estabelecimento.getId());
        viewHolder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return db.read(Estabelecimento.class).size();
    }
}
