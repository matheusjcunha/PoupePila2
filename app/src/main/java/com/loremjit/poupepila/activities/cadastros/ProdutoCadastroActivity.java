package com.loremjit.poupepila.activities.cadastros;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Produto;
import com.loremjit.poupepila.security.RegraNegocio;

public class ProdutoCadastroActivity extends AppCompatActivity {
    private PoupePilaDAO db = PoupePilaDAO.getInstance();
    private EditText etEan;
    private String codigoEan;
    private Spinner spEstab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_cadastro);
        spEstab = findViewById(R.id.sptEstabCadProduto);
        etEan = findViewById(R.id.etEanCadProduto);

        codigoEan = String.valueOf(getIntent().getIntExtra("ean",0));
        etEan.setText(codigoEan);
        etEan.refreshDrawableState();
    }

    public void botaoCadastrarProduto(View v){
        EditText etNome = findViewById(R.id.etNomeCadProduto);
        EditText etDep = findViewById(R.id.etDepCadProduto);
        EditText etPreco = findViewById(R.id.etPrecoCadProduto);

        Produto produto = new Produto();
        produto.setEan(Integer.parseInt(etEan.getText().toString().trim()));
        produto.setNome(etNome.getText().toString().trim());
        produto.setDepartamento(etDep.getText().toString().trim());
        produto.setPreco(Double.parseDouble(etPreco.getText().toString().trim()));

        RegraNegocio regraNegocio = new RegraNegocio(getApplicationContext());

        if(regraNegocio.prepararCadastroNovoProduto(produto)){
            Toast.makeText(this,"Produto cadastrado com sucesso.",Toast.LENGTH_LONG);
            setResult(3);
            finish();
        }
    }
}
