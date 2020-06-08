package app.models;

import app.enums.Funcoes;
import app.enums.Horarios;

public class HeavyLifters extends Membro {

    public HeavyLifters(String email, String nome, Funcoes funcao) {
        super(email, nome, funcao);        
    }

    
    /** 
     * @param horario
     */
    @Override
    public void Mensagem(Horarios horario) {
        switch (horario) {
            case horaNormal:
                System.out.format("%s - Podem contar conosco!\n", this.getNome());
                break;
            case horaExtra:
                System.out.format("%s - N00b_qu3_n_Se_r3pita.bat\n", this.getNome());
                break;
            default:
                break;
        }

    }

    @Override
    public void Apresentar() {
        System.out.println(this.toString());
    }

    
}