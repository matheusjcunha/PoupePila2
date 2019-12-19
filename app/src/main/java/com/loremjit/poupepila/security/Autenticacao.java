package com.loremjit.poupepila.security;

import com.loremjit.poupepila.classes.Basico;
import com.loremjit.poupepila.classes.Premium;
import com.loremjit.poupepila.classes.Usuario;
import com.loremjit.poupepila.database.PoupePilaDAO;
import com.loremjit.poupepila.database.model.Cliente;
import com.loremjit.poupepila.database.model.Lista;

public class Autenticacao {

    public boolean connect(String login, String pass){
        boolean sucess = false;
        PoupePilaDAO db = PoupePilaDAO.getInstance();
        Cliente cliente = db.getCliente(login,pass);
        Usuario usuario;

        //Verifica se encontrou o usuário
        if(cliente != null){
            //Verifica se é usuário premium
            if(cliente.isPremium()) {
                usuario = new Premium();
            }else{
                usuario = new Basico();
            }

            //Cria o registro único na tabela de Lista
            if(db.getListaCliente(cliente.getId()) == null){
                Lista lista = new Lista();
                lista.setId(db.nextIdObjectRealm(Lista.class));
                lista.setCliente_id(cliente.getId());
                db.create(lista);
            }

            //Prepara o usuário
            usuario.setEmail(login);
            usuario.setSenha(pass);
            usuario.setNome(cliente.getNome());
            usuario.setTelefone(cliente.getTelefone());
            Sessao.getInstance().setUsuario(usuario);
            Sessao.getInstance().setIdSession(cliente.getId());
            sucess = true;
        }

        return sucess;
    }
}
