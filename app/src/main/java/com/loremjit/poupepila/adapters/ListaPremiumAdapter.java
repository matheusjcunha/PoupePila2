package com.loremjit.poupepila.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.view_holders.PremiumViewHolder;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Lista;
import com.loremjit.poupepila.security.Sessao;

public class ListaPremiumAdapter extends RecyclerView.Adapter {
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //1: inflar XML
        ConstraintLayout elementoPrincipalXML = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_lista_produto1, parent, false
        );
        //2: associar os objetos inflados a um novo view holder
        PremiumViewHolder gaveta = new PremiumViewHolder(elementoPrincipalXML);
        //3: retornar o view holder que foi criado no passo 2
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PremiumViewHolder viewHolder = (PremiumViewHolder) holder;
        Lista lista = db.getListasPremium(Sessao.getInstance().getIdSession()).get(position);
        viewHolder.setId(lista.getId());
        viewHolder.setPosicao(position);
        viewHolder.tvTitulo.setText("Lista " + String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return db.getListasPremium(Sessao.getInstance().getIdSession()).size();
    }
}
