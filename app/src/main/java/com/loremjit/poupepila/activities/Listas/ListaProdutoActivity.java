package com.loremjit.poupepila.activities.Listas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.activities.cadastros.ProdutoCadastroActivity;
import com.loremjit.poupepila.adapters.ListaProdutoAdapter;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Produto;

public class ListaProdutoActivity extends AppCompatActivity {
    private int posicao;
    private ListaProdutoAdapter adapter;
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private RecyclerView rvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produto);

        rvLista = findViewById(R.id.rvListaProduto);
        adapter = new ListaProdutoAdapter();
        rvLista.setLayoutManager( new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }

    public void botaoCadastrarProduto(View v){
        Intent intent = new Intent(this, ProdutoCadastroActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 1){
            if(resultCode == 3){
                adapter.notifyItemInserted(db.read(Produto.class).size()-1);
            }
        }
    }
}
