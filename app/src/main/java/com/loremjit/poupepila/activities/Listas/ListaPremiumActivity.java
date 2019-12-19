package com.loremjit.poupepila.activities.Listas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.ListaPremiumAdapter;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.ListaPremiumCompra;
import com.loremjit.poupepila.security.Sessao;

public class ListaPremiumActivity extends AppCompatActivity {
    private int posicao;
    private ListaPremiumAdapter adapter;
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private RecyclerView rvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_premium);

        rvLista = findViewById(R.id.rvListaPremium);
        adapter = new ListaPremiumAdapter();
        rvLista.setLayoutManager( new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }

    public void abrirLista(int posicao,int id){
        Intent intent = new Intent(this,ListaCompraActivity.class);
        intent.putExtra("listaId",id);
        this.posicao = posicao;
        startActivityForResult(intent,1);
    }

    public void botaoAdicionarListaPremium(View v){
        final EditText txtUrl = new EditText(this);

        new AlertDialog.Builder(this)
                .setTitle("Nome da Lista")
                .setMessage("")
                .setView(txtUrl)
                .setPositiveButton("Criar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String titulo = txtUrl.getText().toString();
                        if(!titulo.trim().isEmpty()){
                            ListaPremiumCompra lista = new ListaPremiumCompra();
                            lista.setId(db.nextIdObjectRealm(ListaPremiumCompra.class));
                            lista.setNome(titulo);
                            db.addListaPremiumCompra(Sessao.getInstance().getIdSession(),lista);
                            adapter.notifyItemInserted(db.getLista(Sessao.getInstance().getIdSession(),"premium").size()-1);
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            //Alteração
            if(resultCode == 4){
                adapter.notifyItemChanged(posicao);
            }
            //Inserção
            if(resultCode == 3){
                adapter.notifyItemInserted(db.getListasPremium(Sessao.getInstance().getIdSession()).size()-1);
            }
        }
    }
}
