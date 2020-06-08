package app.models;

import app.enums.Funcoes;


public abstract class Membro {
    
    String email;
    String nome;
    Funcoes funcao;

    public Membro(final String email, final String nome, final Funcoes funcao) {
        
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcoes getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcoes funcao) {
        this.funcao = funcao;
    }
    
}