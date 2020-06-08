package app.models;

import app.enums.Funcoes;
import app.enums.Horarios;

public class ScriptGuys extends Membro {

    public ScriptGuys(String email, String nome, Funcoes funcao) {
        super(email, nome, funcao);
        
    }

    @Override
    public void Mensagem(Horarios horario) {
        switch (horario) {
            case horaNormal:
                System.out.format("%s - Prazer em ajudar novos amigos de código!", this.getNome());
                break;
            case horaExtra:
                System.out.format("%s - QU3Ro_S3us_r3curs0s.py", this.getNome());
                break;
            default:
                break;
        }

    }

    @Override
    public void Apresentar() {
        System.out.println(toString());
    }
    
}