package com.loremjit.poupepila.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.loremjit.poupepila.R;
import com.loremjit.poupepila.classes.Premium;
import com.loremjit.poupepila.classes.Usuario;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Cliente;
import com.loremjit.poupepila.security.Sessao;

import io.realm.Realm;

public class ContratoPremiumActivity extends AppCompatActivity {
    CheckBox cbTermosContrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contrato_premium);

        TextView tvContrato = findViewById(R.id.tvTextoContrato);
        cbTermosContrato = findViewById(R.id.cbTermosContrato);

        tvContrato.setText(getTextContrato());
        tvContrato.refreshDrawableState();
    }

    public void botaoAdquirirPremium(View v){
        if(cbTermosContrato.isChecked()){
            //Atualiza o registro do usuário no banco
            PoupePilaDAO db = PoupePilaDAO.getInstance();
            Cliente cliente = db.getCliente(Sessao.getInstance().getIdSession());
            Cliente cliente2 = new Cliente();
            cliente2.setId(cliente.getId());
            cliente2.setPremium(true);
            cliente2.setEmail(cliente.getEmail());
            cliente2.setSenha(cliente.getSenha());
            cliente2.setBairro(cliente.getBairro());
            cliente2.setCidade(cliente.getCidade());
            cliente2.setTelefone(cliente.getTelefone());
            cliente2.setUf(cliente.getUf());
            cliente2.setNome(cliente.getNome());

            if(db.update(cliente2)) {
                //Altera a instância da sessão como premium
                Usuario premium = new Premium();
                premium.setNome(Sessao.getInstance().getUsuario().getNome());
                premium.setSenha(Sessao.getInstance().getUsuario().getSenha());
                premium.setTelefone(Sessao.getInstance().getUsuario().getTelefone());
                premium.setEmail(Sessao.getInstance().getUsuario().getEmail());
                Sessao.getInstance().setUsuario(premium);
                finish();
            }
        }
    }


    public String getTextContrato(){
        String texto = "";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        texto += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque fermentum erat id ipsum cursus, eu tristique erat iaculis. Integer vel mattis neque, eu gravida tellus. Phasellus eu dolor et nisl iaculis euismod. Praesent finibus metus a dolor placerat ultricies. Nunc sodales lorem purus, et ultricies ipsum euismod non. Pellentesque auctor quam ut turpis interdum aliquam eget eget justo. Fusce efficitur luctus neque et aliquet.";
        texto += "Etiam non mattis mi, ultricies porta dui. Nam interdum aliquam elit. Integer vel massa tempus, fringilla tellus at, efficitur sem. Nam non ante fermentum, sodales arcu sed, fringilla tellus. Sed lacus tortor, iaculis sed efficitur vitae, euismod id massa. Duis odio enim, interdum et pulvinar a, tristique sit amet elit. Ut non felis ac purus luctus imperdiet. Phasellus commodo augue in magna cursus, sit amet luctus enim facilisis.";
        return texto;
    }
}

