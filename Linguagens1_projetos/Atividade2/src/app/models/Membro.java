package app.models;

import app.enums.Funcoes;
import app.interfaces.Apresentacoes;
import app.interfaces.PostarMensagem;


public abstract class Membro implements PostarMensagem, Apresentacoes {
    
    private String email;
    private String nome;
    private Funcoes funcao;
    public Membro(String email, String nome, Funcoes funcao) {
        this.email = email;
        this.nome = nome;
        this.funcao = funcao;
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

    @Override
    public String toString() {
        return "Membro: \nE-mail: " + email +"\n" + "Função: " + funcao + "\n"+ "Nome: " + nome + "\n";
    }
    
}