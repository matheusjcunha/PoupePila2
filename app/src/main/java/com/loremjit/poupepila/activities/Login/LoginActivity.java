package com.loremjit.poupepila.activities.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.loremjit.poupepila.MainActivity;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.security.Autenticacao;
import com.loremjit.poupepila.security.Sessao;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
    }

    public void botaoEntrar(View v){
        Autenticacao autenticacao = new Autenticacao();
        EditText etLogin = findViewById(R.id.etLogin);
        EditText etSenha = findViewById(R.id.etSenha);

        //Autentica o usuário
        if(autenticacao.connect(etLogin.getText().toString(),etSenha.getText().toString())) {
            startActivity(new Intent(this, MainActivity.class));
        }else{
            Toast.makeText(this,"Usuário ou Senha inválido.",Toast.LENGTH_LONG).show();
        }
    }

    public void botaoCadastro(View v){
        startActivity(new Intent(this,LoginCadastroActivity.class));

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Se já está logado, finaliza a aplicação
        if(Sessao.getInstance().getUsuario() != null){
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
