package com.loremjit.poupepila.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.loremjit.poupepila.MainActivity;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.activities.Listas.CarrinhoCompraActivity;
import com.loremjit.poupepila.activities.Listas.ListaEstabelecimentoActivity;
import com.loremjit.poupepila.activities.Listas.ListaFavoritoActivity;
import com.loremjit.poupepila.activities.Listas.ListaPremiumActivity;
import com.loremjit.poupepila.activities.Listas.ListaProdutoActivity;
import com.loremjit.poupepila.classes.Premium;
import com.loremjit.poupepila.security.Sessao;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu_principal);
    }

    public void botaoConsultarProduto(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void botaoCarrinho(View v){
        startActivity(new Intent(this, CarrinhoCompraActivity.class));
    }

    public void botaoFavoritos(View v){
        startActivity( new Intent(this, ListaFavoritoActivity.class));
    }

    public void botaoPremium(View v){
        Class classe = ContratoPremiumActivity.class;

        //Verifica se é usuário premium
        if(Sessao.getInstance().getUsuario() instanceof Premium) {
            classe = ListaPremiumActivity.class;
        }
        Intent intent = new Intent(this,classe);
        startActivity(intent);
    }

    public void botaoEstabelecimentos(View v){
        startActivity(new Intent(this, ListaEstabelecimentoActivity.class));
    }

    public void botaoProdutos(View v){
        startActivity(new Intent(this, ListaProdutoActivity.class));
    }
}
