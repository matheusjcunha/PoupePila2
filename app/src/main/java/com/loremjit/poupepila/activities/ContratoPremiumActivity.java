package com.loremjit.poupepila.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.loremjit.poupepila.R;

public class ContratoPremiumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contrato_premium);
    }
}
