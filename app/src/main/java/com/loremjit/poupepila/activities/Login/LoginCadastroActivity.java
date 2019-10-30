package com.loremjit.poupepila.activities.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.database.model.Cliente;
import com.loremjit.poupepila.security.RegraNegocio;
import com.loremjit.poupepila.security.Sessao;

public class LoginCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login_cadastro);
    }

    public void botaoCadastrar(View v){
        RegraNegocio regraNegocio = new RegraNegocio(getApplicationContext());
        EditText etNomeCad = findViewById(R.id.etNomeCad);
        EditText etEmailCad = findViewById(R.id.etEmailCad);
        EditText etSenhaCad = findViewById(R.id.etSenhaCad);
        Cliente cliente = new Cliente();
        cliente.setNome(etNomeCad.getText().toString().trim());
        cliente.setEmail(etEmailCad.getText().toString().trim());
        cliente.setSenha(etSenhaCad.getText().toString());

        if(regraNegocio.prepararCadastroNovoCliente(cliente)){
            finish();
        }
    }
}
