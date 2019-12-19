package com.loremjit.poupepila.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.view_holders.PrecoViewHolder;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Estabelecimento;
import com.loremjit.poupepila.database.model.Registro;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ListaPrecoAdapter extends RecyclerView.Adapter {
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private ArrayList<Registro> registros;

    public ListaPrecoAdapter(ArrayList<Registro> registros){
        this.registros = registros;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //1: inflar XML
        ConstraintLayout elementoPrincipalXML = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_lista_produto1, parent, false
        );
        //2: associar os objetos inflados a um novo view holder
        PrecoViewHolder gaveta = new PrecoViewHolder(elementoPrincipalXML);
        //3: retornar o view holder que foi criado no passo 2
        return gaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PrecoViewHolder viewHolder = (PrecoViewHolder) holder;
        Registro registro = registros.get(position);
        Estabelecimento estabelecimento = db.getEstabelecimento(registro.getEstabelecimento_id());

        viewHolder.tvMercado.setText(estabelecimento.getNome());
        viewHolder.tvUltAtu.setText(SimpleDateFormat.getInstance().format(registro.getData_hora()));
        viewHolder.tvPreco.setText(String.valueOf(registro.getPreco_digitado()));
    }

    @Override
    public int getItemCount() {
        return registros.size()-1;
    }
}
