package app.models;

import java.util.ArrayList;

import app.enums.Horarios;

public class MaskSociety {
    private ArrayList<Membro> listaMembros = new ArrayList<Membro>();
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

    public ArrayList<Membro> getListaMembros() {
        return listaMembros;
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

    public void ApresentarMembros() {
        for (Membro membro : listaMembros) {
            membro.Apresentar();
        }
    }
    public void PostarMensagem() {
        for (Membro membro : listaMembros) {
            membro.Mensagem(this.horarioTrabalho);
        }
    }

    

    
}