package com.loremjit.poupepila.activities.cadastros;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.loremjit.poupepila.R;
import com.loremjit.poupepila.database.model.Estabelecimento;
import com.loremjit.poupepila.security.RegraNegocio;

public class EstabelecimentoCadastroActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estabelecimento_cadastro);
    }

    public void botaoCadastrarEstabelecimento(View v){
        EditText etNome = findViewById(R.id.etNomeEstabelecimento);
        EditText etUf = findViewById(R.id.etUfEstabelecimento);
        EditText etCidade = findViewById(R.id.etCidadeEstabelecimento);
        EditText etBairro = findViewById(R.id.etBairroEstabelecimento);
        EditText etEndereco = findViewById(R.id.etEnderecoEstabelecimento);
        EditText etTelefone = findViewById(R.id.etTelefoneEstabelecimento);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setNome(etNome.getText().toString().trim());
        estabelecimento.setUf(etUf.getText().toString().trim());
        estabelecimento.setCidade(etCidade.getText().toString().trim());
        estabelecimento.setBairro(etBairro.getText().toString().trim());
        estabelecimento.setEndereço(etEndereco.getText().toString().trim());
        estabelecimento.setTelefone(etTelefone.getText().toString().trim());

        RegraNegocio regraNegocio = new RegraNegocio(getApplicationContext());
        if(regraNegocio.prepararCadastroNovoEstabelecimento(estabelecimento)) {
            setResult(3);
            finish();
        }else{
            Toast.makeText(this,"Não foi possível efetuar o cadastro, tente novamente.",Toast.LENGTH_LONG).show();
        }

    }
}
