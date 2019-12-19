package com.loremjit.poupepila.security;

import com.loremjit.poupepila.classes.Usuario;

public final class Sessao {
    private Usuario usuario;
    private int idSession;
    private int estabelecimentoAtualId;
    private static Sessao Instance;

    private Sessao() {
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

    public int getEstabelecimentoAtualId() {
        return estabelecimentoAtualId;
    }

    public void setEstabelecimentoAtualId(int estabelecimentoAtualId) {
        this.estabelecimentoAtualId = estabelecimentoAtualId;
    }
}
