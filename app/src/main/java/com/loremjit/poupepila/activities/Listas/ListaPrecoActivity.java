package com.loremjit.poupepila.activities.Listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.loremjit.poupepila.R;

public class ListaPrecoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lista_preco);
    }
}
