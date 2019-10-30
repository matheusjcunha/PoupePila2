package com.loremjit.poupepila.security;

import com.loremjit.poupepila.classes.Usuario;

public class Sessao {
    private Usuario usuario;
    private int idSession;
    private static Sessao Instance;

    private Sessao() {
        this.usuario = null;
    }

    public static synchronized Sessao getInstance() {
        if (Instance == null)
            Instance = new Sessao();

        return Instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }
}
