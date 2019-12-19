package com.loremjit.poupepila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.loremjit.poupepila.activities.Listas.ListaPrecoActivity;
import com.loremjit.poupepila.activities.Login.LoginActivity;
import com.loremjit.poupepila.activities.MenuPrincipalActivity;
import com.loremjit.poupepila.activities.cadastros.ProdutoCadastroActivity;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Registro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    EditText etProduto;
    public ArrayList<Registro> registros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        etProduto = findViewById(R.id.etProduto);
        etProduto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ((MainActivity) getApplicationContext()).registros = db.getRegistroProduto(editable.toString().trim());

                if(!registros.isEmpty()){
                    Intent intent = new Intent(((MainActivity) getApplicationContext()), ListaPrecoActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    public void botaoMenuPrincipal(View v){
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);
    }
}
