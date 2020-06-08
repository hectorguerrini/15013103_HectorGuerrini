package app.models;

import app.enums.Funcoes;
import app.enums.Horarios;

public class BigBrothers extends Membro {

    public BigBrothers(String email, String nome, Funcoes funcao) {
        super(email, nome, funcao);        
    }

    
    /** 
     * @param horario
     */
    @Override
    public void Mensagem(Horarios horario) {
        switch (horario) {
            case horaNormal:
                System.out.format("%s - Sempre ajudando as pessoas membros ou não S2!\n", this.getNome());
                break;
            case horaExtra:
                System.out.format("%s - ...\n", this.getNome());
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