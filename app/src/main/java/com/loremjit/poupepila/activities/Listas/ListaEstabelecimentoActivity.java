package com.loremjit.poupepila.activities.Listas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.activities.cadastros.EstabelecimentoCadastroActivity;
import com.loremjit.poupepila.adapters.ListaEstabelecimentoAdapter;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Estabelecimento;

public class ListaEstabelecimentoActivity extends AppCompatActivity{
    private int posicao;
    private ListaEstabelecimentoAdapter adapter;
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private RecyclerView rvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_estabelecimento);


        rvLista = findViewById(R.id.rvListaEstabelecimento);
        adapter = new ListaEstabelecimentoAdapter();
        rvLista.setLayoutManager( new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }

    public void botaoAdicionarEstabelecimento(View v){
        Intent intent = new Intent(this, EstabelecimentoCadastroActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == 3){
                adapter.notifyItemInserted(db.read(Estabelecimento.class).size()-1);
            }
        }
    }
}
