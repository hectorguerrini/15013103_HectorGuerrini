package app.models;

import java.util.ArrayList;

import app.enums.Horarios;

public class MaskSociety {
    private ArrayList<Membro> listaMembros;
    private Horarios horarioTrabalho;

    public MaskSociety(Horarios horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;        
    }

    public ArrayList<Membro> getListaMembros() {
        return listaMembros;
    }

    
    public Horarios getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(Horarios horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    
}