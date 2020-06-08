package app.models;

import java.util.ArrayList;

import app.enums.Horarios;

public class MaskSociety {
    private ArrayList<Membro> listaMembros;
    private Horarios horarioTrabalho;

    public MaskSociety(Horarios horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;        
    }

    public void cadastrarMembro(Membro membro) {
        this.listaMembros.add(membro);
    }

    public void excluirMembro(Membro membro){
        this.listaMembros.remove(membro);
    }

    public Horarios getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void trocarHorarioTrabalho() {
        switch (this.horarioTrabalho){
            case horaNormal:
                this.horarioTrabalho = Horarios.horaExtra;
                break;
            case horaExtra:
                this.horarioTrabalho = Horarios.horaNormal;
                break;
            default:
                break;
        }
    }
    
    
}