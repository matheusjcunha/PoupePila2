package com.loremjit.poupepila.activities.Listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.TextView;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.adapters.ListaCarrinhoAdapter;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.ProdutoCarrinho;
import com.loremjit.poupepila.security.Sessao;

public class CarrinhoCompraActivity extends AppCompatActivity {
    private int posicao;
    private ListaCarrinhoAdapter adapter;
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private RecyclerView rvLista;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_carrinho_compra);

        tvTotal = findViewById(R.id.tvTotalCarrinho);
        rvLista = findViewById(R.id.rvListaCarrinho);

        adapter = new ListaCarrinhoAdapter();
        rvLista.setLayoutManager( new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);

        //Seta o total
        atualizarTotal();
    }

    public void alterarQuatidade(int posicao, int idProdutoCarrinho,String operacao){
        ProdutoCarrinho produto = db.getProdutoCarrinho(idProdutoCarrinho);
        if(operacao == "+") {
            produto.setQuantidade(produto.getQuantidade()+1);
        }else{
            if(produto.getQuantidade() > 0){
                produto.setQuantidade(produto.getQuantidade()-1);
            }
        }
        adapter.notifyItemChanged(posicao);
        db.update(produto);
        atualizarTotal();
    }

    public void atualizarTotal(){
        tvTotal.setText(String.valueOf(db.getTotalCarrinho(Sessao.getInstance().getIdSession())));
        tvTotal.refreshDrawableState();
    }
}
