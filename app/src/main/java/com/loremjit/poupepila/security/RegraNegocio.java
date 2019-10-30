package com.loremjit.poupepila.security;

import android.content.Context;
import android.widget.Toast;

import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Cliente;

public class RegraNegocio {
    private PoupePilaDAO db;
    private Context contexto;

    public RegraNegocio(Context contexto){
        this.contexto = contexto;
        db = PoupePilaDAO.getInstance();
    }

    //Cliente
    public boolean prepararCadastroNovoCliente(Cliente cliente){

        if(cliente.getNome().isEmpty()){
            Toast.makeText(contexto,"O campo Nome não foi preenchido.",Toast.LENGTH_LONG).show();
            return false;
        }

        if(cliente.getEmail().isEmpty()){
            Toast.makeText(contexto,"O campo E-mail não foi preenchido.",Toast.LENGTH_LONG).show();
            return false;
        }

        if(cliente.getSenha().isEmpty()){
            Toast.makeText(contexto,"O campo Senha não foi preenchido.",Toast.LENGTH_LONG).show();
            return false;
        }

        cliente.setId(db.nextIdObjectRealm(Cliente.class));
        return db.create(cliente);
    }

    //-----------------------------------------------------------------------
    //Lista




}
