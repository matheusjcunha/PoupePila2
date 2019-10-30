package com.loremjit.poupepila.activities.Listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.ListaFavoritoAdapter;
import com.loremjit.poupepila.adapters.ListaPremiumAdapter;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.security.Sessao;

public class ListaFavoritoActivity extends AppCompatActivity {
    private int posicao;
    private ListaFavoritoAdapter adapter;
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private RecyclerView rvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_favorito);

        rvLista = findViewById(R.id.rvListaPremium);
        adapter = new ListaFavoritoAdapter();
        rvLista.setLayoutManager( new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }

    public void removerFavorito(int posicao,int id){
        db.deletarFavorito(Sessao.getInstance().getIdSession(),id);
        adapter.notifyItemRemoved(posicao);
    }
}
