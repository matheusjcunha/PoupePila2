package com.loremjit.poupepila.activities.Listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.ListaCompraAdapter;
import com.loremjit.poupepila.database.PoupePilaDAO;

public class ListaCompraActivity extends AppCompatActivity {
    private int posicao;
    private ListaCompraAdapter adapter;
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private RecyclerView rvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_compra);

        rvLista = findViewById(R.id.rvListaCompra);
        adapter = new ListaCompraAdapter();
        rvLista.setLayoutManager( new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }

    public void alterarQuantidade(int posicao, int id){

    }
}
