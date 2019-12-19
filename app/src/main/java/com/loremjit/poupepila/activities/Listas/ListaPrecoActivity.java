package com.loremjit.poupepila.activities.Listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.ListaPrecoAdapter;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Registro;

import java.util.ArrayList;

public class ListaPrecoActivity extends AppCompatActivity {
    private int posicao;
    private ListaPrecoAdapter adapter;
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private RecyclerView rvLista;
    private ArrayList<Registro> registros;
    private TextView tvEstabelecimento;
    private TextView tvProduto;
    private TextView tvPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_preco);

        rvLista = findViewById(R.id.rvListaPreco);
        tvEstabelecimento = findViewById(R.id.tvLocalAtualPreco);
        tvProduto = findViewById(R.id.tvProdutoPreco);
        tvPreco = findViewById(R.id.tvValorPreco);

        tvEstabelecimento.setText(registros.get(registros.size()-1).getEstabelecimento_id());
        adapter = new ListaPrecoAdapter(registros);
        rvLista.setLayoutManager( new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }

    public void inverterPosicaoRegistros(int posicao){
        Registro registroPrincipalNovo = registros.get(posicao);
        Registro registroPrincipalAtual = registros.get(registros.size()-1);

        //Inverte os registros
        registros.set(posicao,registroPrincipalAtual);
        registros.set(registros.size()-1,registroPrincipalNovo);
    }

    public void setPrincipalLista(){
        String estalecimento = db.getEstabelecimento(registros.get(registros.size()-1).getEstabelecimento_id()).getNome();
        String produto = db.getProduto(registros.get(registros.size()-1).getProduto_id()).getNome();
        String preco = String.valueOf(registros.get(registros.size()-1).getPreco_digitado());
        tvEstabelecimento.setText(estalecimento);
        tvProduto.setText(produto);
        tvPreco.setText(preco);
        tvEstabelecimento.refreshDrawableState();
        tvProduto.refreshDrawableState();
        tvPreco.refreshDrawableState();
    }
}
