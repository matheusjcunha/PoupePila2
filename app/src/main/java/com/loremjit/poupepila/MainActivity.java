package com.loremjit.poupepila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.loremjit.poupepila.activities.Login.LoginActivity;
import com.loremjit.poupepila.activities.MenuPrincipalActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    public void botaoMenuPrincipal(View v){
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);
    }
}
