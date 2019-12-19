package com.loremjit.poupepila.security;

import android.content.Context;
import android.widget.Toast;

import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Cliente;
import com.loremjit.poupepila.database.model.Estabelecimento;
import com.loremjit.poupepila.database.model.Produto;
import com.loremjit.poupepila.database.model.Registro;
import com.loremjit.poupepila.database.model.RegistroPendente;

import java.util.Calendar;

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

    //-----------------------------------------------------------------------
    //Estabelecimento
    public boolean prepararCadastroNovoEstabelecimento(Estabelecimento estabelecimento){

        if(estabelecimento.getNome().isEmpty()){
            Toast.makeText(contexto,"O campo Nome não foi preenchido.",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(estabelecimento.getCidade().isEmpty()){
            Toast.makeText(contexto,"O campo Cidade não foi preenchido.",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(estabelecimento.getUf().isEmpty()){
            Toast.makeText(contexto,"O campo UF não foi preenchido.",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(estabelecimento.getEndereço().isEmpty()){
            Toast.makeText(contexto,"O campo Endereço não foi preenchido.",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(estabelecimento.getTelefone().isEmpty()){
            estabelecimento.setTelefone("");
        }

        estabelecimento.setId(db.nextIdObjectRealm(Estabelecimento.class));
        prepararNovoRegistro(estabelecimento);

        return db.create(estabelecimento);
    }

    //-----------------------------------------------------------------------
    //Produto
    public boolean prepararCadastroNovoProduto(Produto produto){
        if(produto.getEan() <= 0){
            Toast.makeText(contexto,"O campo Código EAN não foi preenchido.",Toast.LENGTH_LONG).show();
            return false;
        }

        if(produto.getNome().isEmpty()){
            Toast.makeText(contexto,"O campo Nome não foi preenchido.",Toast.LENGTH_LONG).show();
            return false;
        }

        if(produto.getDepartamento().isEmpty()){
            Toast.makeText(contexto,"O campo Departamento não foi preenchido.",Toast.LENGTH_LONG).show();
            return false;
        }

        if(produto.getPreco() <= 0){
            Toast.makeText(contexto,"O campo Preço não foi preenchido.",Toast.LENGTH_LONG).show();
            return false;
        }

        produto.setId(db.nextIdObjectRealm(Produto.class));
        //gera a tabela registo e registro pendente
        prepararNovoRegistro(produto);

        return db.create(produto);
    }

    //-----------------------------------------------------------------------
    //Registro
    public boolean prepararNovoRegistro(Produto produto){
        boolean sucess = false;

        Registro registro = new Registro();
        registro.setId(db.nextIdObjectRealm(Registro.class));
        registro.setCliente_id(produto.getCliente_id());
        registro.setData_hora(Calendar.getInstance().getTime());
        registro.setEstabelecimento_id(produto.getEstabelecimento_id());
        registro.setPreco_digitado(produto.getPreco());
        registro.setProduto_id(produto.getId());
        registro.setPreco_verificado(false);

        if(db.create(registro)){
            sucess = prepararNovoRegistroPendente(registro);
        }

        return sucess;
    }

    public boolean prepararNovoRegistro(Estabelecimento estabelecimento){
        boolean sucess = false;

        Registro registro = new Registro();
        registro.setId(db.nextIdObjectRealm(Registro.class));
        registro.setCliente_id(Sessao.getInstance().getIdSession());
        registro.setData_hora(Calendar.getInstance().getTime());
        registro.setNovo_estabelecimento(estabelecimento.getEndereço());
        registro.setEstabelecimento_id(estabelecimento.getId());
        registro.setPreco_digitado(0);
        registro.setProduto_id(0);
        registro.setPreco_verificado(false);

        if(db.create(registro)){
            sucess = prepararNovoRegistroPendente(registro);
        }

        return sucess;
    }

    //-----------------------------------------------------------------------
    //RegistroPendente
    public boolean prepararNovoRegistroPendente(Registro registro){
        RegistroPendente registroPendente = new RegistroPendente();
        registroPendente.setId(db.nextIdObjectRealm(RegistroPendente.class));
        registroPendente.setRegistro_i(registro.getId());
        registroPendente.setValidado(false);
        return db.create(registroPendente);
    }


}
