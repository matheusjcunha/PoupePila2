package com.loremjit.poupepila.activities.Produto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.loremjit.poupepila.R;

public class LeituraEanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_leitura_ean);
    }
}
